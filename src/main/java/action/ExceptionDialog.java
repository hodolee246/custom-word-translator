package action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class ExceptionDialog {

    private static AnActionEvent anActionEvent;

    public static void setAnActionEvent(AnActionEvent anActionEvent) {
        ExceptionDialog.anActionEvent = anActionEvent;
    }

    private static final String ERROR_TITLE = "ERROR";
    private static final String ERROR_MESSAGE = "플러그인 단어를 불러오는 중 오류가 발생했습니다.";

    public static void showExceptionDialog() {
        if (anActionEvent == null) {
            return;
        }

        Messages.showMessageDialog(anActionEvent.getProject(), ERROR_MESSAGE, ERROR_TITLE, Messages.getErrorIcon());
    }
}
