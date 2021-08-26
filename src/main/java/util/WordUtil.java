package util;

import java.io.*;
import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class WordUtil {

    private final String FILE_PATH =  WordFileUtil.getRootPath() + System.getProperty("file.separator") + "customwordtranslator.txt";

    private static List<String> keyList;
    private static Map<String, String> wordMap;
    private static String wordData;

    public List<String> getKeyList() {
        return keyList;
    }

    public Map<String, String> getWordMap() {
        return wordMap;
    }

    public String getWordData() {
        return wordData;
    }

    public WordUtil() {
        readData();
    }

    public void readData() {
        String line;
        String data;
        wordMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((line = br.readLine()) != null) {
                data = line;
                String key = data.replaceAll("\\t.+", "");
                String value = data.replaceAll(".+\\t", "");
                wordMap.put(key, value);
            }
        } catch (IOException ignored) {}

        keyList = new ArrayList(Arrays.asList(wordMap.keySet().toArray()));
        keyList = Collections.synchronizedList(keyList);
        keyList.sort(Comparator.naturalOrder());

        synchronized (keyList) {
            StringBuilder wordData = new StringBuilder();

            for (String key : keyList) {
                wordData.append(key).append("\t").append(findValueByKey(key)).append("\n");
            }

            setWordData(wordData.toString());
        }
    }

    private void setWordData(String wordData) {
        this.wordData = wordData;
    }

    public String findValueByKey(String key) {
        if (wordMap.isEmpty()) {
            return null;
        }

        return wordMap.get(key);
    }

    public void writeWordData(String wordData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(wordData);
            writer.flush();
        } catch (IOException ignored) {}
        readData();
    }

    public void deleteWordData(String wordData) {
        String deleteWordData = getWordData().replaceAll(wordData, "");
        writeWordData(deleteWordData);
    }

}
