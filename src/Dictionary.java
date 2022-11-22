import java.io.*;
import java.util.*;

public class Dictionary {
    public Map<String, Set<String>> dictionary;
    public Map<String, Set<String>> subDictionary;
    public Dictionary() {
        this.dictionary = new HashMap<String, Set<String>>();
    }

    public void readFile(String fileName) throws IOException {
        BufferedReader bw;
        try {
            bw = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf8"));
        } catch (FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        }

        String previousKey = "";
        while (true) {
            String str = bw.readLine();
            if (str == null)
                break;

            String[] keyValues = str.split("`");

            if (keyValues.length == 2) {
                String[] values = keyValues[1].split("\\| ");
                Set<String> valueSet = new HashSet<String>(values.length);

                for (String value : values) {
                    valueSet.add(value);
                }

                dictionary.put(keyValues[0], valueSet);
                previousKey = keyValues[0];
            } else {
                Set<String> valueSet = dictionary.get(previousKey);
                valueSet.add(keyValues[0]);
                dictionary.put(previousKey, valueSet);
            }
        }
    }

    public void searchWordBySlangWord(String keyWord){
        this.subDictionary = new HashMap<String, Set<String>>();

        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
           String key = entry.getKey();

           if(key.toLowerCase().indexOf(keyWord.toLowerCase()) == 0){
               subDictionary.put(key, entry.getValue());
           }
        }
    }
    public void printMap(Map<String, Set<String>> map) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.print("Values: ");
            for(int i = 0; i < entry.getValue().size(); i++){
                System.out.print(entry.getValue().toArray()[i]);
                if(i < entry.getValue().size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
