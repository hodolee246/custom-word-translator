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
public class WordEditModalValueListenerImpl extends KeyAdapter implements WordEditModal, WordEditModalKeyListener {

    private final JTextField VALUE_TEXT_FIELD;
    private final JTextField KEY_TEXT_FIELD;
    private final JTextArea RESULT_AREA;

    public WordEditModalValueListenerImpl(JTextField valueTextField, JTextField keyTextField, JTextArea resultArea) {
        VALUE_TEXT_FIELD = valueTextField;
        KEY_TEXT_FIELD = keyTextField;
        RESULT_AREA = resultArea;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (! isPlaceHolderText(KEY_TEXT_FIELD.getText())) {
            return;
        }

        String userInputText = VALUE_TEXT_FIELD.getText().toLowerCase();

        if (userInputText.equals("") && isPlaceHolderText(KEY_TEXT_FIELD.getText())) {
            WordUtil wordUtil = new WordUtil();
            RESULT_AREA.setText(wordUtil.getWordData());
        } else if (userInputValidate(userInputText)) {
            findAll(userInputText, "value", RESULT_AREA);
        }
    }

}
