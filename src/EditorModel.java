
import javax.swing.JTextArea;

public class EditorModel extends JTextArea {

    private String message = "";
    private int findPosition = -1;
    InputDialog InputDialog = new InputDialog();

    public String getMessage() {
        return message;
    }

    public int getFindPosition() {
        return findPosition;
    }

    public boolean find(String searchInputValue, boolean ignoreCase) {
        String textEditorContent = this.getText();
        int startPosition = this.getCaretPosition();

        if (ignoreCase) {
            textEditorContent = textEditorContent.toLowerCase();
            searchInputValue = searchInputValue.toLowerCase();

        }

        findPosition = textEditorContent.indexOf(searchInputValue, startPosition);

        if (findPosition < 0 && InputDialog.questionMessage() == javax.swing.JOptionPane.YES_OPTION) {
            findPosition = textEditorContent.indexOf(searchInputValue, 0);
        }

        if (findPosition < 0) {
            message = "'" + searchInputValue + "' nicht gefunden.";
            return false;
        } else {
            message = "'" + searchInputValue + "' an Position " + findPosition
                    + " gefunden.";
            this.setSelectionStart(findPosition);
            this.setSelectionEnd(findPosition + searchInputValue.length());
            return true;
        }
    }
}
