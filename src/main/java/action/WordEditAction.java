package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import form.WordEditModalForm;
import org.jetbrains.annotations.NotNull;


/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class WordEditAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        WordEditModalForm dialogForm = new WordEditModalForm();
        dialogForm.onShowing(anActionEvent);
    }

}
