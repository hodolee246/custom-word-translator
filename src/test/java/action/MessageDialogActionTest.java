package action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.WordFileUtil;
import util.WordUtil;


import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class MessageDialogActionTest {

    WordUtil wordUtil;

    @BeforeEach
    void setUp() {
        wordUtil = new WordUtil();
        wordUtil.writeWordData(WordFileUtil.getWordInitData());
    }

    @Test
    void findValueByKey() {
        String key = "호스트";

        String value = wordUtil.findValueByKey(key);

        assertEquals(value, "host");
    }

}
