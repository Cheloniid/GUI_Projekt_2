package utils;

import model.DataToUpload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JSONConverter {

    public static String toJSON(DataToUpload data) {
        String nick = data.nickname;
        long score = data.score;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = data.date.format(formatter);

        String user = data.systemUserName;
        String host = data.hostName;
        String os = data.osName;

        long code = data.secretCode;

        String json = String.format(
                "{ \"nick\": \"%s\", \"score\": %d, \"date\": \"%s\"," +
                        " \"user\": \"%s\", \"host\": \"%s\", \"os\": \"%s\", \"code\": %d }",
                escapeJson(nick),
                score,
                date,
                escapeJson(user),
                escapeJson(host),
                escapeJson(os),
                code
        );

        if(Constants.DEBUG_MODE){
            System.out.println(json);
        }

        return json;
    }

    public static String escapeJson(String s) {
        return s
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
