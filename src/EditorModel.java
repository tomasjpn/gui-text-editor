import javax.swing.JTextArea;

public class EditorModel extends JTextArea {
	private String message = "";
	private int findPosition = -1;

	public String getMessage() {
    	    return message; 
	}

	public int getFindPosition() {
	    	return findPosition;
	}

	public boolean find(String searchInputValue) {
    	String textEditorContent = this.getText();
    	int startPosition = this.getCaretPosition();
            
    	findPosition = textEditorContent.indexOf(searchInputValue, startPosition);

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
