package util;


import com.intellij.AbstractBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;


/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class KeyAndValueDataBundle {

    /**
     * The {@link ResourceBundle} path.
     */
    @NonNls
    private static final String BUNDLE_NAME = "keyAndValueData";

    /**
     * The {@link ResourceBundle} instance.
     */
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public KeyAndValueDataBundle() {
    }

    public static @Nls String message(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object... params) {
        return AbstractBundle.message(BUNDLE, key, params);
    }

    public static int getBundleKeyCount() {
        return BUNDLE.keySet().size() / 2;
    }
}
