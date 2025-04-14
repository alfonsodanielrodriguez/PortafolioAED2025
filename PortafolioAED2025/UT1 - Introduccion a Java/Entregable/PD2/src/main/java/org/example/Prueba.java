package org.example;

import javax.swing.*;

public class Prueba {
    private JPanel panel1;
    private JCheckBox checkBox1;
    private JRadioButton opcion1RadioButton;
    private JButton OKButton;
    private JRadioButton opcion2RadioButton;
    private JRadioButton opcion3RadioButton;
    private JTextField textField1;
    private JLabel cantidadLetrasLabel;

    public Prueba() {
        OKButton.addActionListener(e -> {
            String texto = textField1.getText();
            JLabel label = new JLabel("Cantidad de letras: " + texto.length());
            JOptionPane.showMessageDialog(null, label);
        });

        opcion1RadioButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Selecciono la opcion 1 ");
        });
        opcion2RadioButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Selecciono la opcion 2 ");
        });
        opcion3RadioButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Selecciono la opcion 3 ");
        });

    }
    public void IniciarProgramaPrueba(){
        JFrame frame = new JFrame("Prueba");
        Prueba prueba = new Prueba();
        frame.setContentPane(prueba.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
