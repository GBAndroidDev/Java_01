import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    GameLogical gameLogical = new GameLogical();

    public int mode = 1;
    public int fieldSizeX = 3, fieldSizeY = 3;
    public int winSize = 3;

    int cellHeight, cellWidth;

    public Map() {
        //setBackground(Color.LIGHT_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    void update (MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellWidth;

        System.out.println(cellX + " " + cellY);

        gameLogical.startGame(cellX, cellY);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGame(g);
    }

    boolean initialize = false;

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winSize) {
        this.mode = mode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winSize = winSize;
        GameLogical.SIZE_FIELD_X = fieldSizeX;
        GameLogical.SIZE_FIELD_Y = fieldSizeY;
        GameLogical.WIN_SIZE = winSize;

        initialize = true;

    }

    void paintGame(Graphics g) {
        //if (!initialize) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX - 20;
        cellHeight = panelHeight / fieldSizeY - 20;

        //System.out.println(cellWidth);

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                g.setColor(Color.BLUE);
                g.drawRect(10 + j * (cellWidth + 10), 10 + i * (cellWidth + 10), cellWidth, cellWidth);
                if (gameLogical.getGameField()[i][j] == 'X') {
                    g.drawRect(30 + j * (cellWidth + 10), 30 + i * (cellWidth + 10), cellWidth - 40, cellWidth - 40);
                }
                if (gameLogical.getGameField()[i][j] == 'O') {
                    g.fillOval(30 + j * (cellWidth + 10), 30 + i * (cellWidth + 10), cellWidth - 40, cellWidth - 40);
                }
            }
        }
    }
}
