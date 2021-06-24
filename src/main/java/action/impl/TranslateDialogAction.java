package action.impl;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import form.TranslateDialogForm;
import org.jetbrains.annotations.NotNull;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class TranslateDialogAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        TranslateDialogForm dialog = new TranslateDialogForm();
        dialog.onShowing(anActionEvent);
    }

}
