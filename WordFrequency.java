package finalproject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void GetWordFrequency(String filename1,String filename2) throws IOException {
    	ArrayList<String> file1 = Read.ReadFile(filename1);
    	ArrayList<String> file2 = Read.ReadFile(filename2);
        Map<String, Integer> frequencyMap11 = calculateWordFrequency1(file1);
        Map<String, Integer> frequencyMap22 = calculateWordFrequency2(file2);
        System.out.println("Word  "+"  "+filename1+"  "+filename2);
        printHashMaps(frequencyMap11,frequencyMap22);
    }
    public static Map<String, Integer> calculateWordFrequency1(ArrayList<String> list1) {
        Map<String, Integer> frequencyMap1 = new HashMap<>();
        for (String word : list1) {
            frequencyMap1.put(word, frequencyMap1.getOrDefault(word, 0) + 1);
        }
        return frequencyMap1;
    }
    public static Map<String, Integer> calculateWordFrequency2(ArrayList<String> list2) {
    	Map<String, Integer> frequencyMap2 = new HashMap<>();
        for (String word : list2) {
            frequencyMap2.put(word, frequencyMap2.getOrDefault(word, 0) + 1);
        }
        return frequencyMap2;
    }
    public static void printHashMaps(Map<String, Integer> hashMap1, Map<String, Integer> hashMap2) {
        for (Map.Entry<String, Integer> entry : hashMap1.entrySet()) {
            String key = entry.getKey();
            int value1 = entry.getValue();
            int value2 = hashMap2.getOrDefault(key, 0);

            System.out.println(key + ": " + value1 + " " + value2);
        }

        for (Map.Entry<String, Integer> entry : hashMap2.entrySet()) {
            String key = entry.getKey();
            if (!hashMap1.containsKey(key)) {
                int value1 = 0;
                int value2 = entry.getValue();

                System.out.println(key + ": " + value1 + " " + value2);
            }
        }
    }
}
