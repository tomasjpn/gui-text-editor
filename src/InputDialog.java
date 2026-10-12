
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class InputDialog extends JTextArea {

    public int showQuestionMessage() {
        return JOptionPane.showOptionDialog(
                this,
                "Vom Textanfang suchen?",
                "Nicht gefunden",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );
    }

    public void showInfoMessage() {
        JOptionPane.showMessageDialog(
                this,
                "<html>"
                + "<b><h1>Tomas Pham</h1></b>"
                + "<p>ITO8<br>28.09.2026</p>"
                + "</html>",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static int showConfirmExitDialog(Component parent) {
        return showConfirmation(parent, "Der Text wurde geändert. Möchten Sie den Editor wirklich beenden?", "Editor beenden");
    }

    public static int showConfirmOverwriteFileDialog(Component parent) {
        return showConfirmation(parent, "Die Datei existiert bereits. Soll sie überschrieben werden?", "Datei überschreiben");
    }

    private static int showConfirmation(
            Component parent, String message, String title) {
        return JOptionPane.showConfirmDialog(
                parent, message, title, JOptionPane.YES_NO_OPTION
        );
    }
}
