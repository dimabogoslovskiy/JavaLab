import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class XllGood {

    private JFrame frame;
    private JTextField surnameTextField;
    private JTextField nameTextField;
    private JTextField middlenameTextField;
    private JTextField sportTextField;
    private JTextField ageSportTextField;
    static List<Sportsman> listSportsman = new ArrayList<>();
    int count;

    /**
     * Launch the application.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                XllGood window = new XllGood();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public XllGood() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Файлы");
        frame.setBounds(100, 100, 349, 271);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton nextButton = new JButton("+");
        JButton backButton = new JButton("-");

        JLabel label = new JLabel("Имя:");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(93, 11, 72, 14);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("\u0412\u0440\u0435\u043c\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f:");
        label_1.setHorizontalAlignment(SwingConstants.RIGHT);
        label_1.setBounds(50, 36, 120, 14);
        frame.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("Дата создания:");
        label_2.setHorizontalAlignment(SwingConstants.RIGHT);
        label_2.setBounds(50, 61, 120, 14);
        frame.getContentPane().add(label_2);

        JLabel label_4 = new JLabel("Размер:");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(73, 86, 92, 14);
        frame.getContentPane().add(label_4);

        surnameTextField = new JTextField();
        surnameTextField.setBounds(175, 8, 137, 20);
        frame.getContentPane().add(surnameTextField);
        surnameTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setBounds(175, 33, 137, 20);
        frame.getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        middlenameTextField = new JTextField();
        middlenameTextField.setBounds(175, 58, 137, 20);
        frame.getContentPane().add(middlenameTextField);
        middlenameTextField.setColumns(10);

        ageSportTextField = new JTextField();
        ageSportTextField.setBounds(175, 83, 137, 20);
        ((AbstractDocument)ageSportTextField.getDocument()).setDocumentFilter(
                new MyDocumentFilter());
        frame.getContentPane().add(ageSportTextField);
        ageSportTextField.setColumns(10);

        JButton button = new JButton("Применить");
        button.addActionListener(arg0 -> {
            if(surnameTextField.getText().equals("") || nameTextField.getText().equals("") || middlenameTextField.getText().equals("") ||
                     ageSportTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Не все поля заполнены!","ОПА",  JOptionPane.PLAIN_MESSAGE);
                return;
            }
            listSportsman.add(new Sportsman(surnameTextField.getText(), nameTextField.getText(), middlenameTextField.getText(),
                    Integer.parseInt(ageSportTextField.getText())));
            count++;
            JOptionPane.showMessageDialog(null, "Все идет по плану.", "OK!", JOptionPane.PLAIN_MESSAGE);
        });

        button.setBounds(10, 137, 147, 23);
        frame.getContentPane().add(button);


        nextButton.addActionListener(arg0 -> {
            try {
                if(count == listSportsman.size() - 1) return;
                surnameTextField.setText(listSportsman.get(++count).getSurname());
                nameTextField.setText(listSportsman.get(count).getName());
                middlenameTextField.setText(listSportsman.get(count).getMiddlename());
                ageSportTextField.setText(String.valueOf(listSportsman.get(count).getAgeSport()));
            } catch(Exception e) {

            }
        });
        nextButton.setBounds(99, 205, 58, 23);
        frame.getContentPane().add(nextButton);


        backButton.addActionListener(arg0 -> {
            try {
                if(count == 0) return;
                surnameTextField.setText(listSportsman.get(--count).getSurname());
                nameTextField.setText(listSportsman.get(count).getName());
                middlenameTextField.setText(listSportsman.get(count).getMiddlename());
                ageSportTextField.setText(String.valueOf(listSportsman.get(count).getAgeSport()));
                nextButton.setEnabled(true);
            } catch(Exception e) {

            }
        });
        backButton.setBounds(10, 205, 58, 23);
        frame.getContentPane().add(backButton);

        JButton button_2 = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
        button_2.addActionListener(arg0 -> {
            surnameTextField.setText("");
            nameTextField.setText("");
            middlenameTextField.setText("");
            ageSportTextField.setText("");
        });
        button_2.setBounds(10, 171, 147, 23);
        frame.getContentPane().add(button_2);

        JButton btnNewButton_1 = new JButton("\u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u043E\u0432\u0430\u0442\u044C");
        btnNewButton_1.addActionListener(arg0 -> {
            listSportsman.set(count, new Sportsman(surnameTextField.getText(), nameTextField.getText(),
                    middlenameTextField.getText(), Integer.parseInt(ageSportTextField.getText())));
        });
        btnNewButton_1.setBounds(167, 137, 147, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
        btnNewButton_2.addActionListener(arg0 -> {
            try {
                listSportsman.remove(count);
                surnameTextField.setText(listSportsman.get(count).getSurname());
                nameTextField.setText(listSportsman.get(count).getName());
                middlenameTextField.setText(listSportsman.get(count).getMiddlename());
                ageSportTextField.setText(String.valueOf(listSportsman.get(count).getAgeSport()));
            } catch(Exception e) {

            }
        });
        btnNewButton_2.setBounds(167, 171, 147, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton button_3 = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
        button_3.addActionListener(arg0 -> {
            surnameTextField.setText("");
            nameTextField.setText("");
            middlenameTextField.setText("");
            ageSportTextField.setText("");
            count = listSportsman.size();
        });
        button_3.setBounds(167, 205, 147, 23);
        frame.getContentPane().add(button_3);
    }
}

class MyDocumentFilter extends DocumentFilter
{
    @Override
    public void insertString(DocumentFilter.FilterBypass fp, int offset, String string, AttributeSet aset)
            throws BadLocationException
    {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++)
        {
            if (!Character.isDigit(string.charAt(i)))
            {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger)
            super.insertString(fp, offset, string, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fp, int offset
            , int length, String string, AttributeSet aset)
            throws BadLocationException
    {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++)
        {
            if (!Character.isDigit(string.charAt(i)))
            {
                isValidInteger = false;
                break;
            }
        }
        if (isValidInteger)
            super.replace(fp, offset, length, string, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}
