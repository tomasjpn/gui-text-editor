
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CustomLogo extends JPanel {

    public CustomLogo() {
        this(40, 30, Color.BLUE);
    }

    public CustomLogo(int xSize, int ySize, Color bgColor) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(xSize, ySize));
    }

    @Override
    public void paintComponent(Graphics g) {
        int h = this.getHeight();
        int w = this.getWidth();

        g.setColor(this.getBackground());
        g.fillRect(0, 0, w, h);
        g.setColor(Color.RED);
        g.drawLine(0, 0, w, h);
        g.setColor(Color.GREEN);
        g.drawLine(0, h, w, 0);
        g.dispose();

    }
}
