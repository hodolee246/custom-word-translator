package action;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class WordEditActionTest implements WordEditModal {

    WordUtil wordUtil;

    @BeforeEach
    void setUp() {
        wordUtil = new WordUtil();
        wordUtil.writeWordData(WordFileUtil.getWordInitData());
    }

    @Test
    void 단어_검색_테스트() {
        String key = "희망";
        String value = "hope";
        String wordData = key + "\t" + value;

        String findByKey = userInputToResultData(key, "key");
        String findByValue = userInputToResultData(value, "value");

        assertEquals(wordData, findByKey);
        assertEquals(wordData, findByValue);
    }

    @Test
    void 단어_추가_테스트() {
        wordAdd();
    }

    private void wordAdd() {
        String key = "인우";
        String value = "inwoo";
        String writeWord = key + "\t" + value + "\n";

        wordUtil.writeWordData(writeWord);

        assertEquals(writeWord, wordUtil.getWordData());
    }

    @Test
    void 단어_삭제_테스트() {
        wordAdd();

        wordUtil.deleteWordData(wordUtil.getWordData());

        assertEquals("", wordUtil.getWordData());
    }

    @AfterEach
    void rollBack() {
        wordUtil.writeWordData(WordFileUtil.getWordInitData());
    }

}
