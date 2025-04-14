package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SaludoForm saludoForm = new SaludoForm();
            saludoForm.inicializarListeners(); // Aquí ya están los componentes inicializados

            JFrame frame = new JFrame("Saludo");
            frame.setContentPane(saludoForm.getPanel()); // Usamos getPanel() para acceder al JPanel
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
