package Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

abstract public class Game implements WindowListener {
    private JFrame mainWindow;
    private boolean active;
    private BufferStrategy bufferStrategy;

    public Game() {
        mainWindow = new JFrame("Desenvolvimento de Jogos For Sad");
        mainWindow.setSize(800, 600);
        mainWindow.addWindowListener(this);
        active = false;
    }

    public void terminate() {
        active = false;
    }

    public void run() throws IOException {
        active = true;
        load();
        while (active) {
            update();
            render();
        }
        unload();
    }

    public void load() throws IOException {
        mainWindow.setUndecorated(true);
        mainWindow.setIgnoreRepaint(false);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
        mainWindow.createBufferStrategy(2);
        bufferStrategy = mainWindow.getBufferStrategy();
        onLoad();
    }

    public void unload() {
        onUnload();
        bufferStrategy.dispose();
        mainWindow.dispose();
    }

    public void render() throws IOException {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, mainWindow.getWidth(), mainWindow.getHeight());
        onRender(g);
        g.dispose();
        bufferStrategy.show();
    }

    abstract public void onLoad() throws IOException;

    abstract public void onUnload();

    abstract public void onUpdate();

    abstract public void onRender(Graphics2D g) throws IOException;

    public int getWidth() {
        return mainWindow.getWidth();
    }

    public int getHeight() {
        return mainWindow.getHeight();
    }

    public void update() {
        onUpdate();
        Thread.yield();
    }

    public void windowClosing(WindowEvent e) {
        terminate();
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
