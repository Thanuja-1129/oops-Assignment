

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Components
        JLabel num1Label = new JLabel("Number 1:");
        num1Field = new JTextField();

        JLabel num2Label = new JLabel("Number 2:");
        num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        // Adding FocusListener to highlight fields
        addFocusListener(num1Field);
        addFocusListener(num2Field);

        // Adding ActionListener to buttons
        addButton.addActionListener(this::handleOperation);
        subtractButton.addActionListener(this::handleOperation);
        multiplyButton.addActionListener(this::handleOperation);
        divideButton.addActionListener(this::handleOperation);

        // Adding KeyListener for ENTER key functionality
        addKeyListenerToField(num1Field);
        addKeyListenerToField(num2Field);

        // Adding Components to Frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        setVisible(true);
    }

    // Handle arithmetic operations
    private void handleOperation(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Add FocusListener to highlight text fields
    private void addFocusListener(JTextField field) {
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.setBackground(Color.WHITE);
            }
        });
    }

    // Add KeyListener for ENTER key functionality
    private void addKeyListenerToField(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleOperation(new ActionEvent(addButton, ActionEvent.ACTION_PERFORMED, ""));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}


