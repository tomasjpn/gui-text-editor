
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

    public static File chooseTextFile(Component parent) {
        JFileChooser fileChooser = createTextFileChooser();

        int returnVal = fileChooser.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    public static File chooseSaveTextFile(Component parent, File suggestedFile) {
        JFileChooser fileChooser = createTextFileChooser();
        if (suggestedFile != null) {
            fileChooser.setSelectedFile(suggestedFile);
        }

        int returnVal = fileChooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }

    private static JFileChooser createTextFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text, CSV, und Java Dateien (*.txt, *.csv, *.java)", "txt", "csv", "java");
            fileChooser.setFileFilter(filter);
        return fileChooser;
    }
}
