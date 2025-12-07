package controller;

import javax.swing.JComboBox;
import model.enums.TipoPaquete;
import view.EnvioPanel;

public class EnvioController {

    EnvioPanel view;

    public EnvioController(EnvioPanel view) {
        this.view = view;
        init();
    }

    private void init() {
        
        
        cargarTipoDePaquete();
    }
    
    private void cargarTipoDePaquete() {
        JComboBox<Object> combo = view.getJbTipoPaquete();
        combo.removeAllItems();
        for (TipoPaquete tipoPaquete : TipoPaquete.values()) {
            combo.addItem(tipoPaquete);
        }
    }

}
