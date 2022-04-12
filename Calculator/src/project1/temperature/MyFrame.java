package project1.temperature;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class MyFrame extends JFrame implements ActionListener{
    //Declare in MyFrame scope
    JTextField textFieldInput, textFieldResult;
    JComboBox comboBoxTemp, comboBoxTempIn, comboBoxTempOut;
    JLabel labelEqual, labelFormulaLogo, labelFormula;
    String inputValue;
    Integer result;

    String[] option = {"Standard","Temperature","Scientific","Programmer"};
    String[] optionTemp = {"Celcius", "Fahrenheit", "Kelvin"};

    //Constructor of MyFrame
    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,0,0,0)); //rows, columns, hgap, vgap
        this.setTitle("Temperature");
        this.setSize(450, 340); // width, height
        this.setResizable(false);
        
        //Declare JPanel
        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();

        //panelNorth
        panelNorth.setBackground(new Color(236, 219, 186));
        panelNorth.setLayout(null);

        //create a combo box
        comboBoxTemp = new JComboBox(option);
        comboBoxTemp.setBounds(73, 23, 300, 20);
        comboBoxTemp.setFocusable(false);

        //add component to panelNorth
        panelNorth.add(comboBoxTemp);

        //panelCenter
        panelCenter.setBackground(new Color(238, 238, 238));
        panelCenter.setLayout(null);

        //create a text field input
        textFieldInput = new JTextField();
        textFieldInput.setBounds(60, 15, 120, 40);
        textFieldInput.setFont(new Font(null,Font.BOLD,20));
        textFieldInput.addActionListener(this); //this == MyFrame class
        textFieldInput.setText("0");
        textFieldInput.setHorizontalAlignment(JTextField.CENTER);

        //create a label
        labelEqual = new JLabel("=");
        labelEqual.setForeground(Color.black);
        labelEqual.setBounds(210, 15, 40, 40);
        labelEqual.setFont(new Font(null,Font.PLAIN,30));

        //create a text field result
        textFieldResult = new JTextField();
        textFieldResult.setFont(new Font(null,Font.BOLD,20));
        textFieldResult.setBounds(270, 15, 120, 40);
        textFieldResult.addActionListener(this); //this == MyFrame class
        textFieldResult.setHorizontalAlignment(JTextField.CENTER);
        textFieldResult.setEditable(false);

        //create combo box input
        comboBoxTempIn = new JComboBox(optionTemp);
        comboBoxTempIn.setBounds(60, 70, 120, 20);
        comboBoxTempIn.setFocusable(false);

        //create combo box result  
        comboBoxTempOut = new JComboBox(optionTemp);
        comboBoxTempOut.setBounds(270, 70, 120, 20);
        comboBoxTempOut.setFocusable(false);

        //add component to panelCenter
        panelCenter.add(comboBoxTempOut);
        panelCenter.add(comboBoxTempIn);
        panelCenter.add(textFieldResult);
        panelCenter.add(textFieldInput);
        panelCenter.add(labelEqual);

        //panelSouth
        panelSouth.setBackground(new Color(236, 219, 186));
        panelSouth.setLayout(null);


        //create a labelFormulaLogo
        labelFormulaLogo = new JLabel("Formula");
        labelFormulaLogo.setFont(new Font(null,Font.BOLD,12));
        labelFormulaLogo.setForeground(new Color(255, 255, 255));
        labelFormulaLogo.setBackground(new Color(249, 171, 0));
        labelFormulaLogo.setOpaque(true); //setOpaque to true in order to background appear.
        labelFormulaLogo.setBounds(60, 30, 60, 20);
        labelFormulaLogo.setHorizontalAlignment(JLabel.CENTER);
        labelFormulaLogo.setVerticalAlignment(JLabel.CENTER);
        labelFormulaLogo.setVisible(false);

        //create a labelFormula 
        labelFormula = new JLabel();
        labelFormula.setFont(new Font(null,Font.PLAIN,12));
        labelFormula.setBounds(130, 30, 260, 20);
        // labelFormula.setBackground(Color.BLACK);
        // labelFormula.setOpaque(true);
        labelFormula.setVisible(false);
       

        //add components to panelSouth
        panelSouth.add(labelFormulaLogo);
        panelSouth.add(labelFormula);
       
        //add components to frame
        this.add(panelNorth);
        this.add(panelCenter);
        this.add(panelSouth);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String[] optionTemp = {"Celcius", "Fahrenheit", "Kelvin"};
        if(e.getSource()==textFieldInput){
                if(comboBoxTempIn.getSelectedItem()=="Celcius" && comboBoxTempOut.getSelectedItem()=="Fahrenheit"){
                    //Celcius to Fahrenheit
                    inputValue = textFieldInput.getText();
                    result = (Integer.parseInt(inputValue) * 9/5) + 32;
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo 
                    labelFormula.setText("(" + inputValue + "°C x 9/5) + 32 = " + result + " °F" );
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Celcius" && comboBoxTempOut.getSelectedItem()=="Kelvin"){
                    //Celcius to Kelvin
                    inputValue = textFieldInput.getText();
                    result = (Integer.parseInt(inputValue) + 273);
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                     //create labelFormula and labelFormulaLogo
                     labelFormula.setText(inputValue + "°C + 273 = " + result + " °K" );
                     labelFormulaLogo.setVisible(true);
                     labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Celcius" && comboBoxTempOut.getSelectedItem()=="Celcius"){
                    //Celcius to Celcius
                    inputValue = textFieldInput.getText();
                    result = Integer.parseInt(inputValue);
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText(result + " °C");
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Fahrenheit" && comboBoxTempOut.getSelectedItem()=="Celcius"){
                    //Fahrenheit to Celcius
                    inputValue = textFieldInput.getText();
                    result = (Integer.parseInt(inputValue) - 32) * 5/9;
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText("(" + inputValue + "°F - 32) x 5/9 = " + result + " °C" );
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Fahrenheit" && comboBoxTempOut.getSelectedItem()=="Kelvin"){
                    //Fahrenheit to Kelvin
                    inputValue = textFieldInput.getText();
                    result = (Integer.parseInt(inputValue) - 32) * 5/9 + 273;
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText("("+ inputValue + "°F - 32) x 5/9 + 273 = " + result + " °K" );
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Fahrenheit" && comboBoxTempOut.getSelectedItem()=="Fahrenheit"){
                    //Fahrenheit to Fahrenheit
                    inputValue = textFieldInput.getText();
                    result = Integer.parseInt(inputValue);
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText(inputValue + "°F");
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Kelvin" && comboBoxTempOut.getSelectedItem()=="Celcius"){
                    //Kelvin to Celcius
                    inputValue = textFieldInput.getText();
                    result = Integer.parseInt(inputValue) - 273;
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText("("+ inputValue + "°K - 273) = " + result + " °C" );
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else if(comboBoxTempIn.getSelectedItem()=="Kelvin" && comboBoxTempOut.getSelectedItem()=="Fahrenheit"){
                    //Kelvin to Fahrenheit
                    inputValue = textFieldInput.getText();
                    result = (Integer.parseInt(inputValue) - 273) * 9/5 + 32;
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText("("+ inputValue + "°K - 273) x 9/5 + 32 = " + result + " °F" );
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }else {
                    inputValue = textFieldInput.getText();
                    result = Integer.parseInt(inputValue);
                    textFieldResult.setText(Integer.toString(result));
                    textFieldResult.setEditable(false);

                    //create labelFormula and labelFormulaLogo
                    labelFormula.setText(inputValue + "°K");
                    labelFormulaLogo.setVisible(true);
                    labelFormula.setVisible(true);
                }
        }
    } 
}
