package form.listener.focus;

import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class WordEditModalFocusListener implements FocusListener {

    private final String EMPTY_TEXT = "";
    private final Font PLACEHOLDER_FONT = new Font("DesktopIcon", Font.ITALIC, 14);
    private final Font INPUT_FONT = new Font("DesktopIcon.font", Font.BOLD, 14);

    private final JTextField textField;
    private final String placeHolderText;

    public WordEditModalFocusListener(JTextField textField, String placeHolderText) {
        this.textField = textField;
        this.placeHolderText = placeHolderText;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(placeHolderText)) {
            textField.setText(EMPTY_TEXT);
            textField.setFont(INPUT_FONT);
            textField.setForeground(JBColor.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if ((textField.getText().equals(EMPTY_TEXT)) || (textField.getText().length() == 0)) {
            textField.setText(placeHolderText);
            textField.setFont(PLACEHOLDER_FONT);
            textField.setForeground(JBColor.GRAY);
        }
    }
    
}
