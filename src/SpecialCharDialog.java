
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SpecialCharDialog extends JDialog implements ActionListener {

    private String character;

    public SpecialCharDialog(JFrame parent) {
        super(parent, "Sonderzeichen einfügen", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 7));

        String[] specialCharacters = {
            "\u00A0", "\u00A1", "\u00A2", "\u00A3", "\u00A4", "\u00A5", "\u00A9",
            "\u00B1", "\u00B7", "\u00D7", "\u00F7", "\u00AA", "\u00BA", "\u00AB",
            "\u00BB", "\u00BC", "\u00BD", "\u00BE", "\u2713", "\u2610", "\u2611"
        };

        for (String charSymbol : specialCharacters) {
            JButton btnChar = new JButton(charSymbol);
            btnChar.addActionListener(this);
            add(btnChar);
        }

        pack();
        setLocationRelativeTo(parent);
    }

    public void showDialog() {
        character = null;
        setVisible(true);
    }

    public String getCharSymbol() {
        return character;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        character = ((JButton) event.getSource()).getText();
        setVisible(false);
    }
}
