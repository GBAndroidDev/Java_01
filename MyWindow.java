/*1 Необходимо создать окно с 1 полем (Фамилия, Имя, Отчество) и кнопку
2 По нажатии кнопки открывается еще 1 окно с тремя полями и кнопкой, в поля вводишь ФИО и нажимаешь кнопку ОК.
3 Дополнительное окно закрывается и в основном окне в поле оседает ФИО.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyWindow extends SetBoundsPosition {

    // left: 10; top: 30;
    // left: 10; bottom: 30;
    // right: 10; bottom: 30;
    // v_align:center; h_align:center;
    // v_align:left; h_align:right; width: 800; height: 600;
    public Label labelFullName = new Label();
    private static DialogWindow dialogWindow;

    public MyWindow() {
        dialogWindow = new DialogWindow(this);

        setTitle("Моя первая программа с использованием Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds("width: 500; height: 350; v_align:center; h_align:center;");
        setLayout(null);

        labelFullName.setBounds(125,100, 250,30);
        labelFullName.setAlignment(labelFullName.CENTER);
        labelFullName.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelFullName);

        JButton dialogButton = new JButton("Открыть диалоговое окно");
        dialogButton.setBounds(150,50,200,30);
        add(dialogButton);

        dialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogWindow.setVisible(true);
            }
        });

        setVisible(true);
    }
}

