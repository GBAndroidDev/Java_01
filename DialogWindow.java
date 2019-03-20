import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DialogWindow extends SetBoundsPosition {
    public DialogWindow(MyWindow myWindow){
        setTitle("Диалоговое окно");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds("width: 350; height: 300; v_align:center; h_align:center;");
        setLayout(null);

        Label labelFullNameInput = new Label("Введите ваше ФИО");
        labelFullNameInput.setBounds(50,30, 250,30);
        add(labelFullNameInput);

        JTextField[] fieldsData = new JTextField[3];
        for (int i = 0; i < fieldsData.length; i++) {
            fieldsData[i] = new JTextField();
            fieldsData[i].setBounds(120,70 + i * 40, 180,30);
            add(fieldsData[i]);
        }

        Label[] labelFieldsData = new Label[3];
        for (int i = 0; i < labelFieldsData.length; i++) {
            switch (i) {
                case 0: labelFieldsData[i] = new Label("Имя"); break;
                case 1: labelFieldsData[i] = new Label("Отчество"); break;
                case 2: labelFieldsData[i] = new Label("Фамилия"); break;
            }
            labelFieldsData[i].setBounds(50,70 + i * 40, 70,30);
            add(labelFieldsData[i]);
        }

        JButton saveButton = new JButton("Сохранить");
        saveButton.setBounds(100,210,150,30);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuffer resStr = new StringBuffer();
                for (int i = 0; i < fieldsData.length; i++) {
                    if (!fieldsData[i].getText().isEmpty()) {
                        resStr.append(fieldsData[i].getText() + " ");
                    }
                }
                myWindow.labelFullName.setText(resStr.toString().trim());
                setVisible(false);
            }
        });
    }

}
