
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

    public static File chooseImage(Component parent) {
        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter
                = new FileNameExtensionFilter(
                        "Textdateien", "txt", "java", "xml", "html", "sql", "jsp");

        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(parent);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }
}
