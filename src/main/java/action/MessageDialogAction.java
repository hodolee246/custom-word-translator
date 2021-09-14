package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import component.MessageDialog;
import org.jetbrains.annotations.NotNull;
import util.WordUtil;


/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class MessageDialogAction extends AnAction {

    private WordUtil wordUtil;

    public MessageDialogAction() {
        wordUtil = new WordUtil();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        ExceptionDialog.setAnActionEvent(e);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        Editor componentEditor = PlatformDataKeys.EDITOR.getData(e.getDataContext());
        SelectionModel selectionModel = editor.getSelectionModel();
        String dialogData = getAutoSelectUserData(selectionModel);
        MessageDialog messageDialog = new MessageDialog(editor, componentEditor);
        messageDialog.showMessageDialog(dialogData);
    }

    private String getAutoSelectUserData(SelectionModel selectionModel) {
        if (selectionModel.getSelectedText() != null) {
            return findValueByKey(selectionModel.getSelectedText());
        }

        selectionModel.selectWordAtCaret(false);
        return findValueByKey(selectionModel.getSelectedText());
    }

    private String findValueByKey(String userInputText) {
        return wordUtil.findValueByKey(userInputText);
    }

}
