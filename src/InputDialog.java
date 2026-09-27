
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

}
