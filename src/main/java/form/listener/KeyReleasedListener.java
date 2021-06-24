package form.listener;

import action.TranslateDialog;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class KeyReleasedListener extends KeyAdapter implements TranslateDialog {

    private JTextArea resultArea;
    private JTextField textField;
    private final static int BACK_SPACE = 8;
    private final static String englishValidateRegex = "^[a-zA-Z\\s0-9]+$";
    private final static String koreanValidateRegex = "^[가-힣]+$";

    public KeyReleasedListener(JTextArea resultArea, JTextField textField) {
        this.resultArea = resultArea;
        this.textField = textField;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String userInputText = textField.getText();

        if (userInputText.equals("")) {
            resultArea.setText("");
        } else if (userInputValidate(userInputText) || isBackSpaceKey(e.getKeyCode())) {
            dialogReplaceLogic(resultArea, userInputText);
        }
    }

    private boolean userInputValidate(String userInput) {
        Pattern englishValidatePattern = Pattern.compile(englishValidateRegex);
        Pattern koreanValidatePattern = Pattern.compile(koreanValidateRegex);
        Matcher englishValidateMatcher = englishValidatePattern.matcher(userInput);
        Matcher koreanValidateMatcher = koreanValidatePattern.matcher(userInput);
        return englishValidateMatcher.find() || koreanValidateMatcher.find();
    }

    private boolean isBackSpaceKey(int keyCode) {
        return keyCode == BACK_SPACE;
    }

}
