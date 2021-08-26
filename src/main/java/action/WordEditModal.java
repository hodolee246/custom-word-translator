package action;

import util.WordUtil;

import javax.swing.*;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public interface WordEditModal {

    default void wordUpdateLogic(JTextArea wordTextArea, String writeValue) {
        CompletableFuture.supplyAsync(() -> wordUpdate(writeValue))
                .thenAccept(wordTextArea::setText);
    }

    default String wordUpdate(String wordData) {
        WordUtil wordUtil = new WordUtil();
        wordUtil.writeWordData(wordUtil.getWordData() + wordData);
        return wordUtil.getWordData();
    }

    default void wordResetLogic(String wordData) {
        WordUtil wordUtil = new WordUtil();
        wordUtil.writeWordData(wordData);
    }

    default void wordDeleteLogic(String userInputText, JTextArea wordTextArea) {
        WordUtil wordUtil = new WordUtil();
        wordUtil.deleteWordData(userInputText);
        wordTextArea.setText(wordUtil.getWordData());
    }

    default void findAll(String userInputText, String trigger, JTextArea resultArea) {
        CompletableFuture.supplyAsync(() -> userInputToResultData(userInputText, trigger))
                .thenAccept(resultArea::setText);
    }

    default String userInputToResultData(String userInputText, String trigger) {
        WordUtil wordUtil = new WordUtil();
        Map<String, String> containMap = wordUtil.getWordMap().entrySet()
                .stream()
                .filter(entry -> {
                    switch (trigger) {
                        case "key":
                            return entry.getKey().contains(userInputText);
                        case "value":
                            return entry.getValue().contains(userInputText);
                        default:
                            return true;
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return containMap.keySet().stream()
                .sorted()
                .map(key -> key + "\t" + containMap.get(key))
                .collect(Collectors.joining("\n"));
    }

}
