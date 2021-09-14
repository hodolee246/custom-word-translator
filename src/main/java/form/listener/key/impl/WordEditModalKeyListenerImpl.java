package form.listener.key.impl;

import action.WordEditModal;
import form.listener.key.WordEditModalKeyListener;
import util.WordUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class WordEditModalKeyListenerImpl extends KeyAdapter implements WordEditModal, WordEditModalKeyListener {

    private final JTextField KEY_TEXT_FIELD;
    private final JTextField VALUE_TEXT_FIELD;
    private final JTextArea RESULT_AREA;

    public WordEditModalKeyListenerImpl(JTextField keyTextField, JTextField valueTextField, JTextArea resultArea) {
        KEY_TEXT_FIELD = keyTextField;
        VALUE_TEXT_FIELD = valueTextField;
        RESULT_AREA = resultArea;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (! isPlaceHolderText(VALUE_TEXT_FIELD.getText())) {
            return;
        }

        String userInputText = KEY_TEXT_FIELD.getText().toLowerCase();

        if (userInputText.equals("") && isPlaceHolderText(VALUE_TEXT_FIELD.getText())) {
            WordUtil wordUtil = new WordUtil();
            RESULT_AREA.setText(wordUtil.getWordData());
        } else if (userInputValidate(userInputText)) {
            findAll(userInputText, "key", RESULT_AREA);
        }
    }

}
