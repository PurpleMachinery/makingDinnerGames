package JogoCirculo;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class JogoCirculo extends Engine.Game {

    int posX;
    int posY;
    int accX;
    int accY;

    @Override
    public void onLoad() {
        posX = 0;
        posY = 0;
        accX = 2;
        accY = 2;
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
    public void onRender(Graphics2D g) {
        g.setColor(Color.white);
        g.fillOval(posX, posY, 20, 20);

        //TESTE
        Shape r = new Rectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
        Shape c = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
        Shape l = new Line2D.Float(100, 100, getWidth() / 2, getHeight() / 2);

        g.draw(r);


    }
}
