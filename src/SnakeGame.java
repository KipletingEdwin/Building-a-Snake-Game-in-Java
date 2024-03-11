import javax.swing.JPanel;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextLayout;


public class SnakeGame extends  JPanel{

    private  final int width;
    private  final int height;
    public  SnakeGame(final int width, final int height) {
        super();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }
    public void startGame() {
        repaint();
}

     @Override
    protected  void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(30F));
        int currentHeight = height / 4;
        final var graphics2D = (Graphics2D) g;
        final var frc = graphics2D.getFontRenderContext();
        final String message = "This is a\nmulti-line message";
        for(final var line : message.split("\n")){
            final var layout = new TextLayout(line, g.getFont(), frc);
            final var bounds = layout.getBounds();
            final  var targetWidth = (float)(width - bounds.getWidth()) / 2;
            layout.draw(graphics2D, targetWidth, currentHeight);
            currentHeight += graphics2D.getFontMetrics().getHeight();
        }
     }
}
