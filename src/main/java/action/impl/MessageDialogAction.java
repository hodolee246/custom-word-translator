package action.impl;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;
import util.KeyAndValueDataBundle;

import java.util.ArrayList;
import java.util.List;
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

    public static List<String> keyList = new ArrayList<>();
    private final static String KEY = "key";
    private final static String WRONG_DATA = "조회 결과가 없습니다.";
    private final static String USER_INPUT_STRING_REGEX = "(?<=\\:).+";
    private final static String TITLE = "용어 변환기";
    private final static String VALUE_PREFIX = "value.";

    public MessageDialogAction() {
        for (int i=1; i<=KeyAndValueDataBundle.getBundleKeyCount(); i++) {
            keyList.add(KeyAndValueDataBundle.message(KEY + i));
        }
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (isUserInput(e.getData(CommonDataKeys.NAVIGATABLE))) {
            Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
            String userInputData = nav.toString();
            String dialogValue = WRONG_DATA;
            Pattern pattern = Pattern.compile(USER_INPUT_STRING_REGEX);
            Matcher matcher = pattern.matcher(userInputData);

            if (matcher.find() && isKeyExistence(matcher.group())) {
                dialogValue = findValueByKey(matcher.group());
            }
            Messages.showMessageDialog(e.getProject(), dialogValue, TITLE, Messages.getInformationIcon());
        }
    }

    private boolean isUserInput(Navigatable nav) {
        return nav != null;
    }

    private boolean isKeyExistence(String key) {
            return keyList.stream()
                    .anyMatch(l -> l.equals(key));
    }

    private String findValueByKey(String key) {
        return KeyAndValueDataBundle.message(VALUE_PREFIX + key);
    }
}
