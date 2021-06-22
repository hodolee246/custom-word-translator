package action.impl;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import form.DialogForm;
import org.jetbrains.annotations.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class DialogAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        DialogForm dialog = new DialogForm();
        dialog.onShowing(anActionEvent);
    }

}
