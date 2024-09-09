import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InteractiveCalculatorUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Вариант 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel label1 = new JLabel("Метка 1", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Метка 2", SwingConstants.CENTER);

        JSlider slider = new JSlider();
        topPanel.add(label1, BorderLayout.WEST);
        topPanel.add(slider, BorderLayout.CENTER);
        topPanel.add(label2, BorderLayout.EAST);

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));

        JButton[] numberButtons = new JButton[10];
        for (int i = 1; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);

            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String currentText = textField.getText();
                    textField.setText(currentText + e.getActionCommand());
                }
            });

            numberButtons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    System.out.println("Наведено на кнопку: " + e.getComponent().toString());
                }
            });
        }

        buttonPanel.add(new JButton("")); 
        numberButtons[0] = new JButton("0");
        buttonPanel.add(numberButtons[0]);

        numberButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textField.getText();
                textField.setText(currentText + "0");
            }
        });

        numberButtons[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Наведено на кнопку 0");
            }
        });

        buttonPanel.add(new JButton("")); // пустая кнопка

        JPanel operationPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton plusButton = new JButton("+");
        JButton equalsButton = new JButton("=");
        operationPanel.add(plusButton);
        operationPanel.add(equalsButton);

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + " + ");
            }
        });

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Результат = [сюда можно добавить логику расчета]");
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                textField.setText("Значение ползунка: " + value);
            }
        });

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(operationPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
