
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
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int left = (width - size * 80 / 100) / 2;
        int top = (height - size * 60 / 100) / 2;

        g.setColor(new Color(0, 100, 0));
        g.fillRect(0, 0, width, height);

        g.setColor(Color.WHITE);
        g.fillRect(left + size * 3 / 100, top, size * 34 / 100, size * 13 / 100);
        g.fillRect(left + size * 14 / 100, top, size * 12 / 100, size * 60 / 100);

        g.setColor(new Color(204, 255, 204));
        g.fillRect(left + size * 44 / 100, top, size * 12 / 100, size * 60 / 100);
        g.fillRect(left + size * 44 / 100, top, size * 32 / 100, size * 13 / 100);
        g.fillRect(left + size * 65 / 100, top, size * 12 / 100, size * 34 / 100);
        g.fillRect(left + size * 45 / 100, top + size * 27 / 100, size * 32 / 100, size * 13 / 100);
    }
}
