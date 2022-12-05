package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Uritorco
 */
public class Calculadora implements ActionListener {

    JFrame frame;
    JTextField textfield, textField2;
    JLabel labelUSD, labelARS, labelEUR;
    JButton[] botonNumero = new JButton[10];
    JButton[] bontonFunc = new JButton[13];
    JButton btnSuma, btnResta, btnMulti, btnDiv, negButton;
    JButton btnDecimal, btnIgual, btnBorrar, btnLimpiar;
    JButton btnRaizCuadrada, btnRaizCubica, btnPotencia;
    JButton dummy1, dummy2;
    JPanel panel;

    Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    double num1 = 0, num2 = 0, resultado = 0;
    char operador;


    Calculadora() {
        frame = new JFrame("Calculadora del Uritorco");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setLayout(null);

        textfield = new JTextField(); //textfield -> editText
        textfield.setBounds(50,25,300,50);
        textfield.setFont(fuente);
        textfield.setEditable(false); //Esto para que solo se pueda ingresar los números desde los botones
        textfield.setBackground(Color.white);


        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMulti = new JButton("*");
        btnDiv = new JButton("/");
        btnDecimal = new JButton(".");
        btnIgual = new JButton("=");
        btnBorrar = new JButton("Borrar");
        btnLimpiar = new JButton("Limpiar");
        negButton = new JButton("(-)");
        btnRaizCuadrada = new JButton("√");
        btnRaizCubica = new JButton("∛");
        btnPotencia = new JButton("^");

        //Botones vacíos para espacio
        dummy1 = new JButton();
        dummy2 = new JButton();
        Color transparente = new Color(1f,0f,0f,.5f );
        dummy1.setBackground(transparente);
        dummy1.setOpaque(false);
        dummy1.setBorderPainted(false);
        dummy1.setFocusable(false);
        dummy2.setBackground(transparente);
        dummy2.setOpaque(false);
        dummy2.setBorderPainted(false);
        dummy2.setFocusable(false);

        labelARS = new JLabel("ARS");
        labelEUR = new JLabel("EUR");
        labelUSD = new JLabel("USD");

        bontonFunc[0] = btnSuma;
        bontonFunc[1] = btnResta;
        bontonFunc[2] = btnMulti;
        bontonFunc[3] = btnDiv;
        bontonFunc[4] = btnDecimal;
        bontonFunc[5] = btnIgual;
        bontonFunc[6] = btnBorrar;
        bontonFunc[7] = btnLimpiar;
        bontonFunc[8] = negButton;
        bontonFunc[9] = btnRaizCuadrada;
        bontonFunc[11] = btnRaizCubica;
        bontonFunc[10] = negButton;
        bontonFunc[12] = btnPotencia;



        for (int i = 0; i < 13 ; i++) {
            bontonFunc[i].addActionListener(this);
            bontonFunc[i].setFocusable(false);
            bontonFunc[i].setFont(fuente);
            bontonFunc[i].setBackground(Color.pink);
            bontonFunc[i].setForeground(Color.black);
        }
        for (int i = 0; i < 10; i++) {
            botonNumero[i] = new JButton(String.valueOf(i));
            botonNumero[i].addActionListener(this);
            botonNumero[i].setFocusable(false);
            botonNumero[i].setBackground(Color.black);
            botonNumero[i].setForeground(Color.white);
        }

        btnIgual.setBackground(Color.black);
        btnIgual.setForeground(Color.white);

        //negButton.setBounds(50,430,105,50);
        btnIgual.setBounds(250,430,105, 50);
        btnBorrar.setBounds(150,430,105,50);
        btnLimpiar.setBounds(50,430,105,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(6,4, 5,5));
        //panel.setBackground(Color.gray);

        panel.add(botonNumero[7]);
        panel.add(botonNumero[8]);
        panel.add(botonNumero[9]);
        panel.add(btnSuma);
        panel.add(botonNumero[4]);
        panel.add(botonNumero[5]);
        panel.add(botonNumero[6]);
        panel.add(btnResta);
        panel.add(botonNumero[1]);
        panel.add(botonNumero[2]);
        panel.add(botonNumero[3]);
        panel.add(btnMulti);
        panel.add(dummy1);
        panel.add(botonNumero[0]);
        panel.add(dummy2);
        panel.add(btnDiv);
        panel.add(btnDecimal);
        panel.add(btnPotencia);
        panel.add(btnRaizCuadrada);
        panel.add(btnRaizCubica);
        //panel.add(btnIgual);

        //negButton.setBackground(Color.black);
        negButton.setForeground(Color.white);
        btnLimpiar.setBackground(Color.black);
        btnLimpiar.setForeground(Color.white);
        btnBorrar.setBackground(Color.black);
        btnBorrar.setForeground(Color.white);


        frame.add(panel);
        //frame.add(negButton);
        frame.add(btnBorrar);
        frame.add(btnLimpiar);
        frame.add(textfield);
        frame.add(btnIgual);
        frame.setVisible(true);

       // panel.add(labelARS, BorderLayout.SOUTH);
        frame.add(labelARS).setBounds(50,500,105,50);
        frame.add(labelEUR).setBounds(50,520,105,50);
        frame.add(labelUSD).setBounds(50,540,105,50);

    }

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == botonNumero[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == btnDecimal) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == btnSuma) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '+';
            textfield.setText("");
        }
        if (e.getSource() == btnResta) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '-';
            textfield.setText("");
        }
        if (e.getSource() == btnMulti) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '*';
            textfield.setText("");
        }
        if (e.getSource() == btnDiv) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '/';
            textfield.setText("");
        }
        if (e.getSource() == btnPotencia) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '^';
            textfield.setText("");
        }
        if (e.getSource() == btnIgual) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operador) {
                case '+' -> resultado = num1 + num2;
                case '-' -> resultado = num1 - num2;
                case '*' -> resultado = num1 * num2;
                case '/' -> resultado = num1 / num2;
                case '^' -> resultado = Math.pow(num1, num2);
            }

            textfield.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if (e.getSource() == btnLimpiar) {
            textfield.setText("");

        }
        if (e.getSource() == btnBorrar) {
           String string = textfield.getText();
           textfield.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
           double temp = Double.parseDouble(textfield.getText());
           temp*=-1;
           textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == btnRaizCuadrada){
            double temp = Double.parseDouble(textfield.getText());
            temp = Math.sqrt(temp);
            textfield.setText(String.valueOf(temp));
        }

        if(e.getSource() == btnRaizCubica){
            double temp = Double.parseDouble(textfield.getText());
            temp = Math.cbrt(temp);
            textfield.setText(String.valueOf(temp));
        }


        if (textfield.getText().equalsIgnoreCase("")) {
            labelARS.setText("ARS: ");
            labelEUR.setText("EUR: ");
            labelUSD.setText("USD: ");
        } else {
            double parcial = Double.parseDouble(textfield.getText());
            if (parcial > 0) {
                labelARS.setText("ARS: " + parcial);
                labelEUR.setText("EUR: " + (parcial * 0.0056));
                labelUSD.setText("USD: " + (parcial * 0.0060));
            }
        }
    }
}