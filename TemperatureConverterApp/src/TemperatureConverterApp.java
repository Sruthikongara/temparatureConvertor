import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Added some spacing

        JLabel inputLabel = new JLabel("Enter temperature:");
        JTextField inputField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Adjust font size and style

        String[] scales = {"Celsius to Fahrenheit", "Celsius to Kelvin", "Fahrenheit to Celsius", "Fahrenheit to Kelvin", "Kelvin to Celsius", "Kelvin to Fahrenheit"};
        JComboBox<String> scaleComboBox = new JComboBox<>(scales);
        scaleComboBox.setPreferredSize(new Dimension(200, 30)); // Set a specific size

        inputField.setPreferredSize(new Dimension(150, 30)); // Set a specific size
        convertButton.setPreferredSize(new Dimension(100, 30)); // Set a specific size
        convertButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjust font size

        frame.add(inputLabel);
        frame.add(inputField);
        frame.add(scaleComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(inputField.getText());
                    String selectedConversion = (String) scaleComboBox.getSelectedItem();

                    double result;
                    String resultText = "Result: ";
                    resultLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Adjust font size and style

                    if (selectedConversion.equals("Celsius to Fahrenheit")) {
                        result = (inputTemp * 9/5) + 32;
                        resultText += result + " °F";
                    } else if (selectedConversion.equals("Celsius to Kelvin")) {
                        result = inputTemp + 273.15;
                        resultText += result + " K";
                    } else if (selectedConversion.equals("Fahrenheit to Celsius")) {
                        result = (inputTemp - 32) * 5/9;
                        resultText += result + " °C";
                    } else if (selectedConversion.equals("Fahrenheit to Kelvin")) {
                        result = (inputTemp - 32) * 5/9 + 273.15;
                        resultText += result + " K";
                    } else if (selectedConversion.equals("Kelvin to Celsius")) {
                        result = inputTemp - 273.15;
                        resultText += result + " °C";
                    } else if (selectedConversion.equals("Kelvin to Fahrenheit")) {
                        result = (inputTemp - 273.15) * 9/5 + 32;
                        resultText += result + " °F";
                    } else {
                        resultText = "Result: Invalid conversion";
                    }
                    resultLabel.setText(resultText);
                } catch (NumberFormatException ex) {
                    resultLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Adjust font size and style
                    resultLabel.setText("Result: Invalid input");
                }
            }
        });

        frame.setVisible(true);
    }
}
