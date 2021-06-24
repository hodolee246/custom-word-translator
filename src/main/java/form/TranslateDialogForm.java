package form;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.WindowManager;
import form.listener.KeyReleasedListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class TranslateDialogForm extends JDialog {

    private final static String TITLE = "CustomWordTranslation";
    private JPanel contentPanel;
    private JTextField textField;
    private JPanel panel;
    private JTextArea resultArea;

    public TranslateDialogForm() {
        init();
        // JtextArea default font
        Font font = new Font("DesktopIcon.font", Font.BOLD, 18);
        resultArea.setFont(font);
        textField.addKeyListener(new KeyReleasedListener(resultArea, textField));
    }

    public void onShowing(AnActionEvent e) {
        // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        this.pack();
        this.setTitle(TITLE);
        // 설정된 객체를 중앙에 배치함
        this.setLocationRelativeTo(Objects.requireNonNull(WindowManager.getInstance().getFrame(e.getProject())).getRootPane().getParent());
        this.setVisible(true);
    }

    public void init() {
        // contentPane property
        setContentPane(contentPanel);
        setModal(true);
        // call onCancel() when cross is clicked
        // Sets the operation that will happen by default when the user initiates a "close" on this dialog.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  //  Automatically hide and dispose the dialog after invoking any registered WindowListener objects.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        // call onCancel() on ESCAPE
        contentPanel.registerKeyboardAction(
                e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
