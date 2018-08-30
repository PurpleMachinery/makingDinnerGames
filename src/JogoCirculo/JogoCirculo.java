package JogoCirculo;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class JogoCirculo extends Engine.Game {

    int posX;
    int posY;
    int accX;
    int accY;
    URL urlImgBola = getClass().getResource("./bola.png");
    BufferedImage imgBola;
    @Override
    public void onLoad() throws IOException {
        posX = 0;
        posY = 0;
        accX = 2;
        accY = 2;
        imgBola = ImageIO.read(urlImgBola);
    }

    @Override
    public void onUnload() {

    }

    @Override
    public void onUpdate() {
        posX += accX;
        posY += accY;
        if (posX < 0 || posX > getWidth()) {
            accX *= -1;
        }
        if (posY < 0 || posY > getHeight()) {
            accY *= -1;
        } else if (accY > 0 && posY > getHeight() - 20) {
            accY *= -1;
        } else if (accX > 0 && posX > getWidth() - 20) {
            accX *= -1;
        }
    }

    @Override
    public void onRender(Graphics2D g) throws IOException {
        g.setColor(Color.white);
        Shape r = new Rectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
        g.draw(r);
        g.drawImage(imgBola, posX, posY, 20,20, null);
    }
}
