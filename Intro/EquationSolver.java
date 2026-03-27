import javax.swing.JOptionPane;

public class EquationSolver {
    public static void main(String[] args) {
        String[] options = {
                "1. First-degree equation (ax + b = 0)",
                "2. System of first-degree equations",
                "3. Second-degree equation (ax^2 + bx + c = 0)",
                "0. Exit"
        };

        while (true) {
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select the type of equation to solve:",
                    "Equation Solver Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == null || choice.startsWith("0")) {
                break;
            } else if (choice.startsWith("1")) {
                solveLinearEquation();
            } else if (choice.startsWith("2")) {
                solveLinearSystem();
            } else if (choice.startsWith("3")) {
                solveQuadraticEquation();
            }
        }
        System.exit(0);
    }

    private static void solveLinearEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Equation: ax + b = 0\nEnter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "The solution is x = " + x);
        }
    }

    private static void solveLinearSystem() {
        JOptionPane.showMessageDialog(null, "System format:\na11*x1 + a12*x2 = b1\na21*x1 + a22*x2 = b2");
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

        double d = a11 * a22 - a21 * a12;
        double d1 = b1 * a22 - b2 * a12;
        double d2 = a11 * b2 - a21 * b1;

        if (d == 0) {
            if (d1 == 0 && d2 == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.");
            }
        } else {
            double x1 = d1 / d;
            double x2 = d2 / d;
            JOptionPane.showMessageDialog(null, "The solutions are:\nx1 = " + x1 + "\nx2 = " + x2);
        }
    }

    private static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Equation: ax^2 + bx + c = 0\nEnter a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "Since a = 0, this becomes a linear equation: bx + c = 0");
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The solution is x = " + (-c / b));
            }
            return;
        }

        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "The equation has no real roots.");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has a double root: x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has two distinct real roots:\nx1 = " + x1 + "\nx2 = " + x2);
        }
    }
}