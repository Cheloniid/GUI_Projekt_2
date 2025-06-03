package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class NickValidator {


    public static ArrayList<String> loadForbiddenWords(String resourcePath) {
        try (
                InputStream inputStream = NickValidator.class.getResourceAsStream(resourcePath);
                BufferedReader reader = new BufferedReader((new InputStreamReader(inputStream)))
        ) {
            return (ArrayList<String>) reader
                    .lines()
                    .map(word -> word.replace("'", "").toLowerCase().trim())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error loading list of forbidden words.");
            return new ArrayList<>();
        }
    }

    public static boolean validate(String name) {
        for (String word : loadForbiddenWords("/profanity_list.txt")) {
            if (name.toLowerCase().contains(word)) {
                System.out.println("Forbidden word: " + word);
                return false;
            }
        }
        return true;
    }
}
