package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataUploader {

    public static boolean uploadData(String json){
        boolean status = true;

        try{
            URL url = new URL(Constants.UPLOAD_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("UPLOAD: response code: " + responseCode);

        } catch (MalformedURLException e) {
            System.out.println("UPLOAD: Malformed URL");
            status = false;
        } catch (IOException e) {
            System.out.println("UPLOAD: Couldn't connect to server");
            status = false;
        }


        return status;
    }
}
