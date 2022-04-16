package project1.mass;

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

public class MyFrame extends JFrame implements ActionListener {
    // **Declare in MyFrame scope */
    JTextField textFieldInput, textFieldResult;
    JComboBox comboBoxLength, comboBoxLengthIn, comboBoxLengthOut;
    JLabel labelEqual, labelFormulaLogo, labelFormula;

    String inputValue, getSelectedItemOut;
    Integer result;

    String[] option = { "Standard", "Temperature", "Mass", "Length" };
    String[] optionLength = { "Kg", "Ons", "Dag", "g", "Dg", "Cg", "Mg" };

    MyFrame() {
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
            if (comboBoxLengthIn.getSelectedItem() == "Kg") {
                switch (getSelectedItemOut) {
                    case "Ons":
                        // **Kg to Ons */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result)); // **convert Integer to String */
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **Kg to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Kg to g */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **Kg to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **Kg to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **Kg to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 6)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Kg to Kg */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Ons") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **Ons to Kg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **Ons to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Ons to g */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **Ons to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **Ons to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **Ons to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Ons to Ons */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Dag") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **Dag to Kg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Ons":
                        // **Dag to Ons */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Dag to g */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **Dag to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **Dag to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **Dag to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Dag to Dag */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "g") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **g to Km */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hg":
                        // **g to Hg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **g to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **g to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **g to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **g to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **m to m */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Dg") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **Dg to Kg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hg":
                        // **Dg to Hg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **Dg to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Dg to g */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **Dg to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **Dg to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Dg to Dg */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Cg") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **Cg to Kg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hg":
                        // **Cg to Hg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **Cg to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Cg to g */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **Cg to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Mg":
                        // **Cg to Mg */
                        result = Integer.parseInt(textFieldInput.getText()) * ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " * 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Cg to Cg */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            } else if (comboBoxLengthIn.getSelectedItem() == "Mg") {
                switch (getSelectedItemOut) {
                    case "Kg":
                        // **Mg to Kg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 6)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Hg":
                        // **Mg to Hg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 5)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dag":
                        // **Mg to Dag */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 4)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "g":
                        // **Mg to g */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 3)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 1000 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Dg":
                        // **Mg to Dg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 2)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 100 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    case "Cg":
                        // **Mg to Cg */
                        result = Integer.parseInt(textFieldInput.getText()) / ((int) Math.round(Math.pow(10, 1)));
                        textFieldResult.setText(String.valueOf(result));
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText() + " / 10 = " + String.valueOf(result));
                        labelFormula.setVisible(true);
                        break;
                    default:
                        // **Mg to Mg */
                        textFieldResult.setText(textFieldInput.getText());
                        labelFormulaLogo.setVisible(true);
                        labelFormula.setText(textFieldInput.getText());
                        labelFormula.setVisible(true);
                }
            }
        }
    }

}
