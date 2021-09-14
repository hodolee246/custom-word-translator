package component;

import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.awt.RelativePoint;

import javax.swing.*;
import java.awt.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class MessageDialog {

    private Editor editor;
    private Editor componentEditor;

    public MessageDialog(Editor editor, Editor componentEditor) {
        this.editor = editor;
        this.componentEditor = componentEditor;
    }

    public void showMessageDialog(String translateText) {
        Point point = editor.visualPositionToXY(getVisualPosition());
        JComponent jComponent = componentEditor.getContentComponent();
        String text = "<p style='color:white; font-size:18px'><b>" + translateText + "</b></p>";

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(
                        text,
                        null,
                        Color.GRAY,
                        null
                ).setFadeoutTime(5000)
                .createBalloon()
                .show(new RelativePoint(jComponent, point),
                        Balloon.Position.below);
    }

    private VisualPosition getVisualPosition() {
        int line = 0;
        int column = 0;

        if(editor != null){
            VisualPosition start = editor.getSelectionModel().getSelectionStartPosition();
            VisualPosition end = editor.getSelectionModel().getSelectionEndPosition();

            if (end != null && start != null) {
                line = end.getLine() + 1;
                column = start.getColumn() + ((end.column - start.getColumn()) /2);
            }
        }

        return new VisualPosition(line, column);
    }
}
