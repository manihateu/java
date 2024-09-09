import javax.swing.*;
import java.awt.*;

public class CalculatorUI {
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
        }

        buttonPanel.add(new JButton(""));
        numberButtons[0] = new JButton("0");
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(new JButton(""));

        JPanel operationPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton plusButton = new JButton("+");
        JButton equalsButton = new JButton("=");
        operationPanel.add(plusButton);
        operationPanel.add(equalsButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.add(operationPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
