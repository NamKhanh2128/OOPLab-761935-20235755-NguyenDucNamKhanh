import javax.swing.JOptionPane;

public class CalculateTwoDoubleNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Enter the first number:", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Enter the second number:", "Input", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotientStr;

        if (num2 == 0) {
            quotientStr = "Cannot divide by zero!";
        } else {
            quotientStr = String.valueOf(num1 / num2);
        }

        String result = "You entered: " + num1 + " and " + num2 + "\n"
                      + "------------------\n"
                      + "Sum: " + sum + "\n"
                      + "Difference: " + difference + "\n"
                      + "Product: " + product + "\n"
                      + "Quotient: " + quotientStr;

        JOptionPane.showMessageDialog(null, result, "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}