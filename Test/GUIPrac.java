import java.awt.*;
import java.awt.event.*;

public class GUIPrac implements ActionListener {
    // Components for the calculator
    private Frame frame;
    private TextField textField;
    private String operator = "";
    private double num1, num2, result;

    public GUIPrac() {
        frame = new Frame("Calculator");

        // TextField to display input and results
        textField = new TextField();
        textField.setBounds(50, 20, 230, 40);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(textField);

        // Create buttons
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button divide = new Button("/");

        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button multiply = new Button("x");

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button plus = new Button("+");

        Button button0 = new Button("0");
        Button minus = new Button("-");
        Button equals = new Button("=");

        // Set button bounds
        button7.setBounds(50, 60, 50, 50);
        button8.setBounds(110, 60, 50, 50);
        button9.setBounds(170, 60, 50, 50);
        divide.setBounds(230, 60, 50, 50);

        button4.setBounds(50, 120, 50, 50);
        button5.setBounds(110, 120, 50, 50);
        button6.setBounds(170, 120, 50, 50);
        multiply.setBounds(230, 120, 50, 50);

        button1.setBounds(50, 180, 50, 50);
        button2.setBounds(110, 180, 50, 50);
        button3.setBounds(170, 180, 50, 50);
        plus.setBounds(230, 180, 50, 50);

        button0.setBounds(50, 240, 110, 50);
        minus.setBounds(170, 240, 50, 50);
        equals.setBounds(230, 240, 50, 50);

        // Add buttons to the frame
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(divide);

        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(multiply);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(plus);

        frame.add(button0);
        frame.add(minus);
        frame.add(equals);

        // Add action listeners
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        divide.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        multiply.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        plus.addActionListener(this);
        button0.addActionListener(this);
        minus.addActionListener(this);
        equals.addActionListener(this);

        // Window listener to close the application
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Frame settings
        frame.setLayout(null);
        frame.setSize(300, 350);
        frame.setVisible(true);
    }

    // Action handling for button clicks
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If a digit button is clicked
        if (Character.isDigit(command.charAt(0))) {
            textField.setText(textField.getText() + command);
        }
        // If an operator button is clicked
        else if (command.equals("+") || command.equals("-") || command.equals("x") || command.equals("/")) {
            operator = command;
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
        // If the equal button is clicked
        else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        new GUIPrac();
    }
}







// import java.awt.*;
// import java.awt.event.*;

// public class GUIPrac {
//     public static void main(String[] args) {
//         Frame frame = new Frame("Calculator");

//         Button button7 = new Button("7");
//         Button button8 = new Button("8");
//         Button button9 = new Button("9");

//         Button button4 = new Button("4");
//         Button button5 = new Button("5");
//         Button button6 = new Button("6");

//         Button button1 = new Button("1");
//         Button button2 = new Button("2");
//         Button button3 = new Button("3");
//         Button button0 = new Button("0");


//       //operations buton
//         Button plus = new Button("+");

//         Button minus = new Button("-");

//         Button multiply = new Button("x");

//         Button divide = new Button("/");

//         Button equals = new Button("=");

//         frame.setLayout(null);
//         frame.setSize(300, 300);

//         button7.setBounds(50, 50, 50, 50);
//         button8.setBounds(110, 50, 50, 50);
//         button9.setBounds(170, 50, 50, 50);
//         divide.setBounds(230, 50, 50, 50);

//         button4.setBounds(50, 110, 50, 50);
//         button5.setBounds(110, 110, 50, 50);
//         button6.setBounds(170, 110, 50, 50);
//         multiply.setBounds(230, 110, 50, 50);

//         button1.setBounds(50, 170, 50, 50);
//         button2.setBounds(110, 170, 50, 50);
//         button3.setBounds(170, 170, 50, 50);
//         plus.setBounds(230, 170, 50, 50);

//         button0.setBounds(50, 230, 110, 50);
//         minus.setBounds(170, 230, 50, 50);
//         equals.setBounds(230, 230, 50, 50);

        
//         frame.add(button7);
//         frame.add(button8);
//         frame.add(button9);
//         frame.add(divide);

//         frame.add(button4);
//         frame.add(button5);
//         frame.add(button6);
//         frame.add(multiply);

//         frame.add(button1);
//         frame.add(button2);
//         frame.add(button3);
//         frame.add(plus);

//         frame.add(button0);
//         frame.add(minus);
//         frame.add(equals);


//         frame.addWindowListener(new WindowAdapter() {
//             public void windowClosing(WindowEvent e) {
//                 System.exit(0);
//             }
//         });

//         frame.setVisible(true);
//     }
// }








// import java.awt.*;
// import java.awt.event.*;

// public class CalculatorAWT extends Frame implements ActionListener {
//     // Components for the calculator
//     TextField textField;
//     Button[] digitButtons = new Button[10]; // Buttons 0-9
//     Button addButton, subButton, mulButton, divButton, eqButton, clrButton; // Operation buttons
//     String operator = "";
//     double num1, num2, result;

//     // Constructor
//     public CalculatorAWT() {
//         // Create the layout
//         setLayout(new BorderLayout());

//         // TextField to display input and results
//         textField = new TextField();
//         textField.setEditable(false);
//         add(textField, BorderLayout.NORTH);

//         // Panel to hold digit buttons and operator buttons
//         Panel buttonPanel = new Panel();
//         buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

//         // Initialize digit buttons
//         for (int i = 0; i <= 9; i++) {
//             digitButtons[i] = new Button(String.valueOf(i));
//             digitButtons[i].addActionListener(this);
//             buttonPanel.add(digitButtons[i]);
//         }

//         // Initialize operator buttons
//         addButton = new Button("+");
//         subButton = new Button("-");
//         mulButton = new Button("*");
//         divButton = new Button("/");
//         eqButton = new Button("=");
//         clrButton = new Button("C");

//         // Add action listeners for operator buttons
//         addButton.addActionListener(this);
//         subButton.addActionListener(this);
//         mulButton.addActionListener(this);
//         divButton.addActionListener(this);
//         eqButton.addActionListener(this);
//         clrButton.addActionListener(this);

//         // Add operator buttons to the panel
//         buttonPanel.add(clrButton);
//         buttonPanel.add(addButton);
//         buttonPanel.add(subButton);
//         buttonPanel.add(mulButton);
//         buttonPanel.add(divButton);
//         buttonPanel.add(eqButton);

//         add(buttonPanel, BorderLayout.CENTER);

//         // Frame settings
//         setTitle("Simple Calculator");
//         setSize(300, 400);
//         setVisible(true);

//         // Close the window on clicking close
//         addWindowListener(new WindowAdapter() {
//             public void windowClosing(WindowEvent we) {
//                 dispose();
//             }
//         });
//     }

//     // Action handling for button clicks
//     public void actionPerformed(ActionEvent e) {
//         String command = e.getActionCommand();

//         // If a digit button is clicked
//         if (Character.isDigit(command.charAt(0))) {
//             textField.setText(textField.getText() + command);
//         }
//         // If an operator button is clicked
//         else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
//             operator = command;
//             try {
//                 num1 = Double.parseDouble(textField.getText());
//                 textField.setText("");
//             } catch (NumberFormatException ex) {
//                 textField.setText("Error");
//             }
//         }
//         // If the equal button is clicked
//         else if (command.equals("=")) {
//             try {
//                 num2 = Double.parseDouble(textField.getText());
//                 switch (operator) {
//                     case "+":
//                         result = num1 + num2;
//                         break;
//                     case "-":
//                         result = num1 - num2;
//                         break;
//                     case "*":
//                         result = num1 * num2;
//                         break;
//                     case "/":
//                         if (num2 != 0) {
//                             result = num1 / num2;
//                         } else {
//                             textField.setText("Error");
//                             return;
//                         }
//                         break;
//                 }
//                 textField.setText(String.valueOf(result));
//             } catch (NumberFormatException ex) {
//                 textField.setText("Error");
//             }
//         }
//         // If the clear button is clicked
//         else if (command.equals("C")) {
//             textField.setText("");
//             num1 = num2 = result = 0;
//             operator = "";
//         }
//     }

//     // Main method to run the program
//     public static void main(String[] args) {
//         new CalculatorAWT();
//     }
// } 







// import java.awt.*;
// import java.awt.event.*;

// public class CalculatorAWT extends Frame implements ActionListener {
//     // Components for the calculator
//     TextField textField;
//     Button[] digitButtons = new Button[10]; // Buttons 0-9
//     Button addButton, subButton, mulButton, divButton, eqButton, clrButton; // Operation buttons
//     String operator = "";
//     double num1, num2, result;

//     // Constructor
//     public CalculatorAWT() {
//         // Create the layout
//         setLayout(new BorderLayout());

//         // TextField to display input and results
//         textField = new TextField();
//         textField.setEditable(false);
//         add(textField, BorderLayout.NORTH);

//         // Panel to hold digit buttons and operator buttons
//         Panel buttonPanel = new Panel();
//         buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

//         // Initialize digit buttons
//         for (int i = 0; i <= 9; i++) {
//             digitButtons[i] = new Button(String.valueOf(i));
//             digitButtons[i].addActionListener(this);
//             buttonPanel.add(digitButtons[i]);
//         }

//         // Initialize operator buttons
//         addButton = new Button("+");
//         subButton = new Button("-");
//         mulButton = new Button("*");
//         divButton = new Button("/");
//         eqButton = new Button("=");
//         clrButton = new Button("C");

//         // Add action listeners for operator buttons
//         addButton.addActionListener(this);
//         subButton.addActionListener(this);
//         mulButton.addActionListener(this);
//         divButton.addActionListener(this);
//         eqButton.addActionListener(this);
//         clrButton.addActionListener(this);

//         // Add operator buttons to the panel
//         buttonPanel.add(addButton);
//         buttonPanel.add(subButton);
//         buttonPanel.add(mulButton);
//         buttonPanel.add(divButton);
//         buttonPanel.add(eqButton);

//         buttonPanel.add(clrButton);

//         add(buttonPanel, BorderLayout.CENTER);

//         // Frame settings
//         setTitle("Simple Calculator");
//         setSize(300, 400);
//         setVisible(true);

//         // Close the window on clicking close
//         addWindowListener(new WindowAdapter() {
//             public void windowClosing(WindowEvent we) {
//                 dispose();
//             }
//         });
//     }

//     // Action handling for button clicks
//     public void actionPerformed(ActionEvent e) {
//         String command = e.getActionCommand();

//         // If a digit button is clicked
//         if (Character.isDigit(command.charAt(0))) {
//             textField.setText(textField.getText() + command);
//         }
//         // If an operator button is clicked
//         else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
//             operator = command;
//             num1 = Double.parseDouble(textField.getText());
//             textField.setText("");
//         }
//         // If the equal button is clicked
//         else if (command.equals("=")) {
//             num2 = Double.parseDouble(textField.getText());
//             switch (operator) {
//                 case "+":
//                     result = num1 + num2;
//                     break;
//                 case "-":
//                     result = num1 - num2;
//                     break;
//                 case "*":
//                     result = num1 * num2;
//                     break;
//                 case "/":
//                     if (num2 != 0) {
//                         result = num1 / num2;
//                     } else {
//                         textField.setText("Error");
//                         return;
//                     }
//                     break;
//             }
//             textField.setText(String.valueOf(result));
//         }
//         // If the clear button is clicked
//         else if (command.equals("C")) {
//             textField.setText("");
//             num1 = num2 = result = 0;
//             operator = "";
//         }
//     }

//     // Main method to run the program
//     public static void main(String[] args) {
//         new CalculatorAWT();
//     }
// }
