package util;

import action.ExceptionDialog;

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
        WordFileUtil.createSettingFile();
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
        } catch (IOException e) {
            ExceptionDialog.showExceptionDialog();
        }

        setWordData();
    }

    public String findValueByKey(String key) {
        if (wordMap.get(key) != null) {
            return wordMap.get(key);
        }
        return "조회 결과가 없습니다.";
    }

    private void setWordData() {
        keyList = new ArrayList(Arrays.asList(wordMap.keySet().toArray()));
        keyList = Collections.synchronizedList(keyList);
        keyList.sort(Comparator.naturalOrder());

        synchronized (keyList) {
            StringBuilder readData = new StringBuilder();

            for (String key : keyList) {
                readData.append(key).append("\t").append(findValueByKey(key)).append("\n");
            }

            this.wordData = readData.toString();
        }
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
