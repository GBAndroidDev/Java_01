import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameVisualization extends JFrame {
    private static DialogWindow dialogWindow;
    private static Map field;

    public GameVisualization(GameLogical gameLogical) {
        dialogWindow = new DialogWindow(this);

        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(125,100, 500,550);
        //setLayout(null);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2));
        JButton btnStartGame = new JButton("Новая игра");
        JButton btnExitGame = new JButton("Выход из игры");

        field = new Map();
        add(field,BorderLayout.CENTER);

        bottomPanel.add(btnStartGame);
        bottomPanel.add(btnExitGame);

        add(bottomPanel,BorderLayout.SOUTH);

        btnExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogWindow.setVisible(true);
            }
        });

        /*JButton dialogButton = new JButton("Открыть диалоговое окно");
        dialogButton.setBounds(150,50,200,30);
        add(dialogButton);

        dialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dialogWindow.setVisible(true);
                gameLogical.startGame(1,1);
            }
        });*/

        setVisible(true);
    }

}
