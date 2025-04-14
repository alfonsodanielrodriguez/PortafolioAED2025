package org.example;

import javax.swing.*;

public class SaludoForm {
    private JPanel panel1;
    private JButton BotonSaludar;
    private JTextField CampoTexto;

    public JPanel getPanel() {
        return panel1;
    }

    public void inicializarListeners() {
        BotonSaludar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Hola " + CampoTexto.getText());
        });
    }
}
