//**The file in functions package */
package functions;

//**Import from library Java */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.lang.StringBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasiCalculatorFunctions extends JFrame implements ActionListener {
    // **Declare in MyFrame scope */
    char operator;
    String value;
    int num1, num2, result;

    JComboBox comboBox;
    JTextField textFieldInput;
    String getSelectedItemComboBox;
    JPanel panelSouth;
    JButton addButton, subButton, mulButton, divButton, expoButton, equButton, delButton, clrButton;
    JLabel labelFormulaLeft, labelFormulaRightL, labelFormulaRightR;
    StringBuilder stringBuilder;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    String[] option = { "Calculator", "Temperature", "Mass", "Length" };

    Font myFont = new Font(null, Font.PLAIN, 18);

    // **Constructor of MyFrame */
    public BasiCalculatorFunctions() {
        // **Create a frame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Standard");
        this.setSize(350, 635);
        this.setResizable(false);
        this.setLayout(null);

        // **Create the comboBox */
        comboBox = new JComboBox(option);
        comboBox.setBounds(25, 20, 300, 20);
        comboBox.setFocusable(false);
        comboBox.removeItem("Calculator");
        comboBox.addActionListener(this);

        // **Create the labelFormulaLeft */
        labelFormulaLeft = new JLabel();
        labelFormulaLeft.setBounds(25, 125, 150, 30);
        labelFormulaLeft.setFont(new Font(null, Font.BOLD, 20));

        // **Create the labelFormulaRightL */
        labelFormulaRightL = new JLabel();
        labelFormulaRightL.setBounds(175, 125, 75, 30);
        labelFormulaRightL.setFont(new Font(null, Font.BOLD, 20));
        labelFormulaRightL.setHorizontalAlignment(JLabel.LEFT);

        // **Create the labelFormulaRightR */
        labelFormulaRightR = new JLabel();
        labelFormulaRightR.setBounds(250, 125, 75, 30);
        labelFormulaRightR.setFont(new Font(null, Font.BOLD, 20));
        labelFormulaRightR.setHorizontalAlignment(JLabel.RIGHT);

        // **Create the textFieldInput *
        textFieldInput = new JTextField();
        textFieldInput.setBounds(25, 170, 300, 40);
        textFieldInput.setFont(new Font(null, Font.BOLD, 20));
        textFieldInput.setEditable(false);

        // **Create the panelSouth */
        panelSouth = new JPanel();
        panelSouth.setBounds(25, 220, 300, 350);
        panelSouth.setOpaque(true);
        panelSouth.setLayout(new GridLayout(5, 4, 10, 10));

        // **Create fucntionButtons */
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("÷");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("AC");
        expoButton = new JButton("^");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = expoButton;

        for (int init = 0; init < 8; init++) {
            functionButtons[init].addActionListener(this);
            functionButtons[init].setFont(myFont);
            functionButtons[init].setFocusable(false);
        }

        // **Create a numberButtons */
        for (int init = 0; init < 10; init++) {
            numberButtons[init] = new JButton(String.valueOf(init));
            numberButtons[init].addActionListener(this);
            numberButtons[init].setFocusable(false);
            numberButtons[init].setFont(myFont);
        }

        // **Add components to panelSouth */
        panelSouth.add(clrButton);
        panelSouth.add(delButton);
        panelSouth.add(expoButton);
        panelSouth.add(divButton);
        panelSouth.add(numberButtons[7]);
        panelSouth.add(numberButtons[8]);
        panelSouth.add(numberButtons[9]);
        panelSouth.add(mulButton);
        panelSouth.add(numberButtons[4]);
        panelSouth.add(numberButtons[5]);
        panelSouth.add(numberButtons[6]);
        panelSouth.add(subButton);
        panelSouth.add(numberButtons[1]);
        panelSouth.add(numberButtons[2]);
        panelSouth.add(numberButtons[3]);
        panelSouth.add(addButton);
        panelSouth.add(numberButtons[0]);

        // **Create the equButton */
        equButton.setBounds(103, 508, 220, 63);

        // **Add components to frame */
        this.add(equButton);
        this.add(panelSouth);
        this.add(textFieldInput);
        this.add(labelFormulaLeft);
        this.add(labelFormulaRightR);
        this.add(labelFormulaRightL);
        this.add(comboBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // **Invoked when the mouse button has been clicked (pressed and released) on a
        // ** component */
        for (int init = 0; init < 10; init++) {
            if (e.getSource() == numberButtons[init]) {

                textFieldInput.setText(textFieldInput.getText().concat(String.valueOf(init)));
            }
        }
        for (int init = 0; init < 8; init++) {
            if (e.getSource() == functionButtons[init]) {
                // **When I click a functionButtons, it will appear in textFieldInput */
                if (functionButtons[init] == functionButtons[0]) {
                    // **addButton */
                    num1 = Integer.parseInt(textFieldInput.getText());
                    operator = '+';
                    textFieldInput.setText("");
                }
                if (functionButtons[init] == functionButtons[1]) {
                    // **subButton */
                    num1 = Integer.parseInt(textFieldInput.getText());
                    operator = '-';
                    textFieldInput.setText("");
                }
                if (functionButtons[init] == functionButtons[2]) {
                    // **mulButton */
                    num1 = Integer.parseInt(textFieldInput.getText());
                    operator = '*';
                    textFieldInput.setText("");
                }
                if (functionButtons[init] == functionButtons[3]) {
                    // **divButton */
                    num1 = Integer.parseInt(textFieldInput.getText());
                    operator = '/';
                    textFieldInput.setText("");
                }
                if (functionButtons[init] == functionButtons[4]) {
                    // **equButton */
                    num2 = Integer.parseInt(textFieldInput.getText());
                    String number1 = String.valueOf(num1),
                            number2 = String.valueOf(num2);

                    // **labelFormulaRightL and labelFormulaRightR */
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            labelFormulaLeft.setText(number1 + " + " + number2);
                            labelFormulaRightR.setText(String.valueOf(result));
                            labelFormulaRightL.setText("=");
                            textFieldInput.setText("");
                            break;
                        case '-':
                            result = num1 - num2;
                            labelFormulaLeft.setText(number1 + " - " + number2);
                            labelFormulaRightR.setText(String.valueOf(result));
                            labelFormulaRightL.setText("=");
                            textFieldInput.setText("");
                            break;
                        case '/':
                            result = num1 / num2;
                            labelFormulaLeft.setText(number1 + " ÷ " + number2);
                            labelFormulaRightR.setText(String.valueOf(result));
                            labelFormulaRightL.setText("=");
                            textFieldInput.setText("");
                            break;
                        case '*':
                            result = num1 * num2;
                            labelFormulaLeft.setText(number1 + " * " + number2);
                            labelFormulaRightR.setText(String.valueOf(result));
                            labelFormulaRightL.setText("=");
                            textFieldInput.setText("");
                            break;
                        case '^':
                            result = (int) Math.pow(num1, num2);
                            labelFormulaLeft.setText(number1 + " ^ " + number2);
                            labelFormulaRightR.setText(String.valueOf(result));
                            labelFormulaRightL.setText("=");
                            textFieldInput.setText("");
                            break;
                    }

                }
                if (functionButtons[init] == functionButtons[5]) {
                    // **delButton */
                    int getLength = textFieldInput.getText().length();
                    stringBuilder = new StringBuilder(textFieldInput.getText());
                    stringBuilder.deleteCharAt(getLength - 1);
                    String result = stringBuilder.toString();
                    textFieldInput.setText(result);
                }
                if (functionButtons[init] == functionButtons[6]) {
                    // **clrButton */
                    textFieldInput.setText("");
                }
                if (functionButtons[init] == functionButtons[7]) {
                    // **expoButton */
                    num1 = Integer.parseInt(textFieldInput.getText());
                    operator = '^';
                    textFieldInput.setText("");
                }
            }
        }
        if (e.getSource() == comboBox) {
            // **When we click comboBox, a window will open */
            getSelectedItemComboBox = String.valueOf(comboBox.getSelectedItem());
            switch (getSelectedItemComboBox) {
                case "Length":
                    this.dispose(); // **it's going to close the frame */
                    new LengthFunctions();
                    break;
                case "Mass":
                    this.dispose(); // **it's going to close the frame */
                    new MassFunctions();
                    break;
                default:
                    this.dispose(); // **it's going to close the frame */
                    new TemperatureFunctions();
            }
        }

    }

}
