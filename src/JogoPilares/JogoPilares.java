package JogoPilares;

import Engine.Game;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class JogoPilares extends Game {

    private Point circle;
    private Point speed;
    private BufferedImage imgBola;
    private BufferedImage imgPilarVermelho;
    private BufferedImage imgPilarAmarelo;
    AudioClip musica;

    public JogoPilares() {
        circle = new Point(10, 10);
        speed = new Point(5, 5);
        try {
            URL imgUrl = getClass().getResource("./ball.png");
            if (imgUrl == null) {
                throw new RuntimeException(
                        "A imagem ./ball.png não foi encontrada.");
            } else {
                imgBola = ImageIO.read(imgUrl);
            }
            imgUrl = getClass().getResource("./pilar_vermelho.png");
            if (imgUrl == null) {
                throw new RuntimeException(
                        "A imagem ./pilar_vermelho.png não foi encontrada.");
            } else {
                imgPilarVermelho = ImageIO.read(imgUrl);
            }
            imgUrl = getClass().getResource("./pilar_amarelo.png");
            if (imgUrl == null) {
                throw new RuntimeException(
                        "A imagem ./pilar_amarelo.png não foi encontrada.");
            } else {
                imgPilarAmarelo = ImageIO.read(imgUrl);
            }
            URL url = getClass().getResource("./bgmusic.wav");
            musica = Applet.newAudioClip(url);
            musica.loop();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void onLoad() {

    }

    public void onUnload() {
        musica.stop();
    }

    public void onUpdate() {
        circle.x += speed.x;
        circle.y += speed.y;
        if (circle.x < 0 || circle.x > getWidth()) {
            speed.x *= -1;
        }
        if (circle.y < 0 || circle.y > getHeight()) {
            speed.y *= -1;
        }
        if (speed.x > 0 && circle.x > getWidth() - 50) {
            speed.x *= -1;
        }
        if (speed.y > 0 && circle.y > getHeight() - 50) {
            speed.y *= -1;
        }

        try {
            Thread.sleep(25);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public void onRender(Graphics2D g) {
        g.drawImage(imgPilarAmarelo, 130, 0, null);
        g.drawImage(imgPilarAmarelo, 550, 0, null);
        g.drawImage(imgPilarAmarelo, 710, 0, null);
        g.drawImage(imgBola, circle.x, circle.y, 50, 50, null);
        g.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.8f));
        g.drawImage(imgPilarVermelho, 50, 0, null);
        g.drawImage(imgPilarVermelho, 450, 0, null);
        g.setComposite(AlphaComposite.SrcOver);
        g.setColor(Color.white);
        Shape wFrame = new Rectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
        g.draw(wFrame);
    }
}