package view;

import javax.swing.*;

public class Alerta {

    public static void mensaje(String mensaje, String titulo, int icono) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, icono);
    }

}
