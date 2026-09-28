
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

}
