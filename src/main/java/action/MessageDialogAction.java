package action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;
import util.WordFileUtil;
import util.WordUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        if (isUserInput(e.getData(CommonDataKeys.NAVIGATABLE))) {
            Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
            String userInputData = nav.toString();
            String dialogValue = "조회 결과가 없습니다.";
            String title = "용어 변환기";

            String userInputStringRegex = "(?<=\\:).+";
            Pattern pattern = Pattern.compile(userInputStringRegex);
            Matcher matcher = pattern.matcher(userInputData);

            if (matcher.find() && isKeyExistence(matcher.group())) {
                dialogValue = findValueByKey(matcher.group());
            }

            Messages.showMessageDialog(e.getProject(), dialogValue, title, Messages.getInformationIcon());
        }
    }

    private boolean isUserInput(Navigatable nav) {
        return nav != null;
    }

    private boolean isKeyExistence(String userInputText) {
        return wordUtil.getKeyList().stream().anyMatch(key -> key.equals(userInputText));
    }

    private String findValueByKey(String userInputText) {
        return wordUtil.findValueByKey(userInputText);
    }

}
