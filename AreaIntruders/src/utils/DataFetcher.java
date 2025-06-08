package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFetcher {

    public static List<TopScoreEntry> fetchData() {
        List<TopScoreEntry> topScores = new ArrayList<>();

        URL download_url;

        try {
            if (Constants.USE_LOCAL_ENDPOINTS) {
                download_url = new URL(Constants.DOWNLOAD_LOCAL_ENDPOINT);
            } else {
                download_url = new URL(Constants.DOWNLOAD_ENDPOINT);
            }
            HttpURLConnection connection = (HttpURLConnection) download_url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            String rawText = response.toString();
            if (rawText.startsWith("[")) {
                rawText = rawText.substring(1, rawText.length());
            }
            if (rawText.endsWith("]")) {
                rawText = rawText.substring(0, rawText.length() - 1);
            }

            String[] entries = rawText.split(",");
            topScores = Stream.of(entries)
                    .map(entry -> entry = entry.trim().replaceAll("\"", ""))
                    .map(entry -> {
                        String[] parts = entry.split(";");
                        TopScoreEntry topScoreEntry = new TopScoreEntry();
                        topScoreEntry.no = Integer.parseInt(parts[0]);
                        topScoreEntry.score = Integer.parseInt(parts[1]);
                        topScoreEntry.name = parts[2];
                        return topScoreEntry;
                    })
                    .collect(Collectors.toList());

        } catch (MalformedURLException e) {
            System.out.println("Malformed Download URL");
            return topScores;
        } catch (IOException e) {
            System.out.println("IO Error Downloading top-scores");
            return topScores;
        }
        return topScores;
    }
}


