import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordHashTable {
    public static void main(String[] args) {
        String fileName = "C:/Users/onyxe/Desktop/untitled/src/words.txt";
        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    word = word.toLowerCase().replaceAll("[^a-z0-9çğıöşü]", "");
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int distinctWords = wordCount.size();
        String mostRepeatedWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeatedWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("Distinct words: " + distinctWords);
        System.out.println("Most repeated word: " + mostRepeatedWord + " (repeated " + maxCount + " times)");
    }
}
