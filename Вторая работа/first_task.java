import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class first_task {
    public static void main(String[] args) {
        String inputFilePath = "./assets/gore-ot-uma.txt";
        String outputFilePath = "output.txt";

        List<String> hyphenatedWords = findHyphenatedWords(inputFilePath);

        writeWordsToFile(hyphenatedWords, outputFilePath);
    }

    // Метод для нахождения слов с дефисом
    public static List<String> findHyphenatedWords(String filePath) {
        List<String> hyphenatedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\S*-\\S*\\b");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    hyphenatedWords.add(matcher.group());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return hyphenatedWords;
    }

    // Метод для записи слов в файл
    public static void writeWordsToFile(List<String> words, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}

