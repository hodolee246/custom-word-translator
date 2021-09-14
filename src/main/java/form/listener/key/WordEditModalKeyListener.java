package form.listener.key;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface WordEditModalKeyListener {

    String ENG_VALIDATE_REGEX = "^[a-zA-Z0-9]+$";
    String KOR_VALIDATE_REGEX = "^[가-힣0-9]+$";
    String KEY_PLACEHOLDER_TEXT = "용어를 입력해 주세요.";
    String VALUE_PLACEHOLDER_TEXT = "약어를 입력해 주세요.";

    default boolean userInputValidate(String userInputText) {
        Pattern englishValidatePattern = Pattern.compile(ENG_VALIDATE_REGEX);
        Pattern koreanValidatePattern = Pattern.compile(KOR_VALIDATE_REGEX);
        Matcher englishValidateMatcher = englishValidatePattern.matcher(userInputText);
        Matcher koreanValidateMatcher = koreanValidatePattern.matcher(userInputText);
        return englishValidateMatcher.find() || koreanValidateMatcher.find();
    }

    default boolean isPlaceHolderText(String userInputText) {
        return userInputText.equals(KEY_PLACEHOLDER_TEXT) || userInputText.equals(VALUE_PLACEHOLDER_TEXT);
    }

}
