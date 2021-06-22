package action;


import action.impl.SearchAndTranslatorAction;
import util.KeyAndValueDataBundle;

import javax.swing.*;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public interface SearchAndTranslator extends EventListener {

    default String translatorList(String userInputText, List<String> keyList) {
        String result = "";

        if (userInputText.isBlank()) {
            return null;
        }
        List<String> userInputReplaceList = keyList.stream()
                .filter(l -> l.startsWith(userInputText))
                .collect(Collectors.toList());
        if (userInputReplaceList.isEmpty()) {
            return null;
        }
        for (String key : userInputReplaceList) {
            result +=  key + " : " + KeyAndValueDataBundle.message("value." + key) + "\n";
        }
        return result;
    }

    default void dialogReplaceLogic(JTextArea resultArea, JTextField textField) {
        String userInputText = textField.getText();
        String wrongData = "조회 결과가 없습니다.";
        resultArea.setText("용어를 불러오고 있습니다.");

        List<String> keyList = SearchAndTranslatorAction.keyList;
        CompletableFuture.supplyAsync(() -> translatorList(userInputText, keyList))
                .thenAccept(searchText -> {
                    if (searchText == null) {
                        resultArea.setText(wrongData);
                    } else {
                        resultArea.setText(searchText);
                    }
                });
    }

}
