package finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWithoutQuote {
    public static ArrayList<String> ReadFile(String filename) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean insideQuotes = false;
            while ((line = reader.readLine()) != null) {
                StringBuilder currentWord = new StringBuilder();
                for (char c : line.toCharArray()) {
                    if (c == '"') {
                        insideQuotes = !insideQuotes; // 切换引号状态
                    } else if (Character.isWhitespace(c)) {
                        if (!insideQuotes && currentWord.length() > 0) {
                            words.add(currentWord.toString());
                            currentWord = new StringBuilder();
                        }
                    } else {
                        currentWord.append(c);
                    }
                }
                if (!insideQuotes && currentWord.length() > 0) {
                    words.add(currentWord.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(words);
    }
}