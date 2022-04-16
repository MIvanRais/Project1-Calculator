//**The file in functions package */
package functions;

//**Import from library Java */
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class LengthFunctions extends JFrame implements ActionListener {
    //**Declare in MyFrame scope */
    JTextField textFieldInput, textFieldResult;
    JComboBox comboBoxLength, comboBoxLengthIn, comboBoxLengthOut;
    JLabel labelEqual, labelFormulaLogo, labelFormula;

    String inputValue, getSelectedItemOut;
    Integer result;

    String[] option = { "Standard", "Temperature", "Mass", "Length" };
    String[] optionLength = { "Km", "Hm", "Dam", "m", "Dm", "Cm", "Mm" };

    LengthFunctions() {
        // **Create a frame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 0, 0, 0));
        this.setSize(430, 350);
        this.setTitle("Mass");
        this.setResizable(false);

        // **Declare panel */
        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();

        // **Create the panelNorth */
        panelNorth.setBackground(new Color(236, 219, 186));
        panelNorth.setLayout(null);

        // **Create the comboBoxTemp */
        comboBoxLength = new JComboBox(option);
        comboBoxLength.setBounds(73, 23, 300, 20);
        comboBoxLength.setFocusable(false);

        // **Add components to the panelNorth */
        panelNorth.add(comboBoxLength);

        // **Create the panelCenter */
        panelCenter.setBackground(new Color(238, 238, 238));
        panelCenter.setLayout(null);

        // **Create the textFieldInput */
        textFieldInput = new JTextField();
        textFieldInput.setBounds(60, 15, 120, 40);
        textFieldInput.setFont(new Font(null, Font.BOLD, 20));
        textFieldInput.addActionListener(this); // **this = MyFrame class
        textFieldInput.setText("0");
        textFieldInput.setHorizontalAlignment(JTextField.CENTER);

        // **Create the labelEqual */
        labelEqual = new JLabel("=");
        labelEqual.setForeground(Color.black);
        labelEqual.setBounds(210, 15, 40, 40);
        labelEqual.setFont(new Font(null, Font.PLAIN, 30));

        // **create the textFieldResult */
        textFieldResult = new JTextField();
        textFieldResult.setFont(new Font(null, Font.BOLD, 20));
        textFieldResult.setBounds(270, 15, 120, 40);
        textFieldResult.addActionListener(this); // **this == MyFrame class
        textFieldResult.setHorizontalAlignment(JTextField.CENTER);
        textFieldResult.setEditable(false);

        // **Create the comboBoxTempIn */
        comboBoxLengthIn = new JComboBox(optionLength);
        comboBoxLengthIn.setBounds(60, 70, 120, 20);
        comboBoxLengthIn.setFocusable(false);

        // **Create the comboBoxTempOut */
        comboBoxLengthOut = new JComboBox(optionLength);
        comboBoxLengthOut.setBounds(270, 70, 120, 20);
        comboBoxLengthOut.setFocusable(false);

        // **Add component to panelCenter */
        panelCenter.add(comboBoxLengthOut);
        panelCenter.add(comboBoxLengthIn);
        panelCenter.add(textFieldResult);
        panelCenter.add(textFieldInput);
        panelCenter.add(labelEqual);

        // **panelSouth */
        panelSouth.setBackground(new Color(236, 219, 186));
        panelSouth.setLayout(null);

        // **create a labelFormulaLogo */
        labelFormulaLogo = new JLabel("Formula");
        labelFormulaLogo.setFont(new Font(null, Font.BOLD, 12));
        labelFormulaLogo.setForeground(new Color(255, 255, 255));
        labelFormulaLogo.setBackground(new Color(249, 171, 0));
        labelFormulaLogo.setOpaque(true); // **setOpaque to true in order to background appear.
        labelFormulaLogo.setBounds(60, 30, 60, 20);
        labelFormulaLogo.setHorizontalAlignment(JLabel.CENTER);
        labelFormulaLogo.setVerticalAlignment(JLabel.CENTER);
        labelFormulaLogo.setVisible(false);

        // **create a labelFormula */
        labelFormula = new JLabel();
        labelFormula.setFont(new Font(null, Font.PLAIN, 12));
        labelFormula.setBounds(130, 30, 260, 20);
        labelFormula.setVisible(false);

        // **Add components to the panelSouth */
        panelSouth.add(labelFormulaLogo);
        panelSouth.add(labelFormula);

        // **Add components to the frame */
        this.add(panelNorth);
        this.add(panelCenter);
        this.add(panelSouth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textFieldInput) {
            // **When we hit Enter on textFieldInput, what will happen? */
            getSelectedItemOut = String.valueOf(comboBoxLengthOut.getSelectedItem()); // **Convert object to String
            if (comboBoxLengthIn.getSelectedItem() == "Km") {
                switch (getSelectedItemOut) {
                    case "Hm":
                        // **Km to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result)); // **convert Integer to String */
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **Km to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Km to m */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **Km to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **Km to Cm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **Km to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 6)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Km to Km */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Hm") {
                switch (getSelectedItemOut) {
                    // **Hm to Km */
                    case "Km":
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **Hm to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Hm to m */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **Hm to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **Hm to Cm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **Hm to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Hm to Hm */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Dam") {
                switch (getSelectedItemOut) {
                    case "Km":
                        // **Dam to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hm":
                        // **Dam to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Dam to m */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **Dam to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **Dam to Cm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **Dam to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Dam to Dam */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "m") {
                switch (getSelectedItemOut) {
                    case "Km":
                        // **m to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hm":
                        // **m to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **m to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **m to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **m to Cm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **m to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **m to m */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Dm") {
                switch (getSelectedItemOut) {
                    case "Km":
                        // **Dm to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hm":
                        // **Dm to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **Dm to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Dm to m */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **Dm to cm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **Dm to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Dm to Dm */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Cm") {
                switch (getSelectedItemOut) {
                    case "Km":
                        // **Cm to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hm":
                        // **Cm to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **Cm to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Cm to m */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **Cm to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mm":
                        // **Cm to Mm */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Cm to Cm */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Mm") {
                switch (getSelectedItemOut) {
                    case "Km":
                        // **Mm to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 6)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hm":
                        // **Mm to Hm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dam":
                        // **Mm to Dam */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "m":
                        // **Mm to m */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dm":
                        // **Mm to Dm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cm":
                        // **Mm to Cm */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Mm to Mm */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            }
        }
    }

}
