package form;

import action.WordEditModal;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.JBColor;
import form.listener.focus.WordEditModalFocusListener;
import form.listener.key.impl.WordEditModalKeyListenerImpl;
import form.listener.key.impl.WordEditModalValueListenerImpl;
import util.WordFileUtil;
import util.WordUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class WordEditModalForm extends JDialog implements WordEditModal {

    private final String TITLE = "CustomWordTranslation";
    private final String KEY_PLACEHOLDER_TEXT = "용어를 입력해 주세요.";
    private final String VALUE_PLACEHOLDER_TEXT = "약어를 입력해 주세요.";
    private final Font PLACE_HOLDER_FONT = new Font("DesktopIcon", Font.ITALIC, 13);

    private final WordUtil wordUtil;
    private JPanel btnPanel;
    private JButton okBtn;
    private JButton deleteBtn;
    private JButton resetBtn;
    private JPanel contentPanel;
    private JTextField keyTextField;
    private JTextField valueTextField;
    private JTextArea wordTextArea;
    private JPanel userInputPanel;

    public WordEditModalForm() {
        init();
        wordUtil = new WordUtil();

        keyTextField.addFocusListener(new WordEditModalFocusListener(keyTextField, KEY_PLACEHOLDER_TEXT));
        valueTextField.addFocusListener(new WordEditModalFocusListener(valueTextField, VALUE_PLACEHOLDER_TEXT));
        setPlaceHolder();

        keyTextField.addKeyListener(new WordEditModalKeyListenerImpl(keyTextField, valueTextField, wordTextArea));
        valueTextField.addKeyListener(new WordEditModalValueListenerImpl(valueTextField, keyTextField, wordTextArea));

        Font font = new Font("DesktopIcon.font", Font.BOLD, 18);
        wordTextArea.setFont(font);
        wordTextArea.setEditable(false);
        wordTextArea.setText(wordUtil.getWordData());

        okBtn.addActionListener(e -> updateData());
        resetBtn.addActionListener(e -> setResetData());
        deleteBtn.addActionListener(e -> deleteData());
    }

    public void onShowing(AnActionEvent e) {
        // 이 창의 크기를 하위 구성요소의 기본 크기 및 레이아웃에 맞도록 조정합니다.
        this.pack();
        this.setTitle(TITLE);
        // 설정된 객체를 중앙에 배치함
        this.setLocationRelativeTo(Objects.requireNonNull(WindowManager.getInstance().getFrame(e.getProject())).getRootPane().getParent());
        this.setVisible(true);
    }

    public void init() {
        setContentPane(contentPanel);
        setModal(true);
        // x 버튼을 누를 경우 수행되는 로직
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPanel.registerKeyboardAction(
                e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    private void updateData() {
        if (isUserInput()) {
            String writeValue = getUpdateWordData();
            boolean isKeyExistence = wordUtil.getKeyList().stream().anyMatch(key -> key.equals(keyTextField.getText().trim()));

            if (isKeyExistence) {
                int userSelect = JOptionPane.showConfirmDialog(null, "이미 용어가 존재 합니다. 덮어 씌우시나요?", TITLE, JOptionPane.OK_CANCEL_OPTION);

                if (userSelect == JOptionPane.OK_OPTION) {
                    wordUpdateLogic(wordTextArea, writeValue);
                    setPlaceHolder();
                }
            } else {
                wordUpdateLogic(wordTextArea, writeValue);
                setPlaceHolder();
            }
        } else if (isReset()) {
            CompletableFuture.runAsync(() -> wordResetLogic(wordTextArea.getText()));
        }
    }

    private boolean isUserInput() {
        return ! (keyTextField.getText().trim().equals("")
                || valueTextField.getText().trim().equals("")
                || keyTextField.getText().equals(KEY_PLACEHOLDER_TEXT)
                || valueTextField.getText().equals(VALUE_PLACEHOLDER_TEXT));
    }

    private String getUpdateWordData() {
        String keyText = keyTextField.getText();
        String valueText = valueTextField.getText();
        return keyText + "\t" + valueText + "\n";
    }
    
    private void setPlaceHolder() {
        keyTextField.setText(KEY_PLACEHOLDER_TEXT);
        keyTextField.setFont(PLACE_HOLDER_FONT);
        keyTextField.setForeground(JBColor.GRAY);

        valueTextField.setText(VALUE_PLACEHOLDER_TEXT);
        valueTextField.setFont(PLACE_HOLDER_FONT);
        valueTextField.setForeground(JBColor.GRAY);
    }

    private boolean isReset() {
        return WordFileUtil.getWordInitData().equals(wordTextArea.getText());
    }

    private void setResetData() {
        wordTextArea.setText(WordFileUtil.getWordInitData());
        setPlaceHolder();
        JOptionPane.showMessageDialog(null, "적용 버튼을 눌러야 초기화가 적용 됩니다.");
    }

    private void deleteData() {
        if (wordTextArea.getText().equals(wordUtil.getWordData())) {
            return;
        }

        int userSelect = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시나요?", TITLE, JOptionPane.OK_CANCEL_OPTION);

        if (userSelect == JOptionPane.OK_OPTION) {
            selectDeleteTextRegex();
        }
    }

    private void selectDeleteTextRegex() {
        Pattern deletePattern = Pattern.compile(".+\n");
        Matcher deleteMatcher = deletePattern.matcher(wordTextArea.getText());

        if (deleteMatcher.find()) {
            CompletableFuture.runAsync(() -> wordDeleteLogic(deleteMatcher.group(), wordTextArea));
            setPlaceHolder();
        } else {
            selectDeleteTextRegex2();
        }
    }

    private void selectDeleteTextRegex2() {
        Pattern deletePattern2 = Pattern.compile(".+");
        Matcher deleteMatcher2 = deletePattern2.matcher(wordTextArea.getText());

        if (deleteMatcher2.find()) {
            CompletableFuture.runAsync(() -> wordDeleteLogic(deleteMatcher2.group() + "\n", wordTextArea));
            setPlaceHolder();
        }
    }

}
