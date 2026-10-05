
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

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

        if (findPosition < 0 && InputDialog.showQuestionMessage() == javax.swing.JOptionPane.YES_OPTION) {
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

    public void updatePositionFields(JFormattedTextField lineInputField,
            JFormattedTextField columnInputField,
            JFormattedTextField characterInputField) {
        String text = this.getText();
        int position = this.getCaretPosition();
        int line = 1;
        int column = 1;

        for (int i = 0; i < position; i++) {
            if (text.charAt(i) == '\n') {
                line++;
                column = 1;
            } else {
                column++;
            }
        }

        lineInputField.setValue(line);
        columnInputField.setValue(column);
        characterInputField.setValue(position);
    }

    public void setCharacterPosition(JFormattedTextField field) {
        int caretPosition = getNumber(field);
        if (caretPosition >= 0 && caretPosition <= getText().length()) {
            setCaretPosition(caretPosition);
        }
    }

    public void setLineNumber(JFormattedTextField field) {
        int requestedLineNumber = getNumber(field);
        String text = getText();
        int position = 0;

        for (int line = 1; line < requestedLineNumber && position >= 0; line++) {
            position = text.indexOf('\n', position);
            if (position >= 0) {
                position++;
            }
        }

        if (requestedLineNumber >= 1 && position >= 0) {
            setCaretPosition(position);
        }
    }

    public void setColumnNumber(JFormattedTextField field) {
        int requestedColumnNumber = getNumber(field);
        String text = getText();
        int startPosition = getCaretPosition();

        while (startPosition > 0 && text.charAt(startPosition - 1) != '\n') {
            startPosition--;
        }

        int endPosition = text.indexOf('\n', startPosition);
        if (endPosition < 0) {
            endPosition = text.length();
        }

        if (requestedColumnNumber >= 1 && requestedColumnNumber <= endPosition - startPosition + 1) {
            setCaretPosition(startPosition + requestedColumnNumber - 1);
        }
    }

    private int getNumber(JFormattedTextField field) {
        Object value = field.getValue();
        return value instanceof Number ? ((Number) value).intValue() : -1;
    }
}
