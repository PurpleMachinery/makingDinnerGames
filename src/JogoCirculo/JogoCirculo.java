package JogoCirculo;

import jdk.nashorn.internal.ir.WhileNode;

import javax.swing.*;
import java.awt.*;

public class JogoCirculo extends Engine.Game {

    int posX;
    int posY;
    int accX;
    int accY;

    @Override
    public void onLoad() {
        posX = 0;
        posY = 0;
        accX = 10;
        accY = 10;
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
        }
    }

    @Override
    public void onRender(Graphics2D g) {
        g.setColor(Color.white);
        g.fillOval(posX, posY, 20, 20);
    }
}
