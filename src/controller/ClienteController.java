package controller;

import model.Cliente;
import view.Alerta;
import view.ClientePanel;

public class ClienteController {

    private ClientePanel view;
    private Cliente cliente;

    public ClienteController(ClientePanel view) {
        this.view = view;
        init();
    }

    public void init() {
        view.getBtnAgregar().addActionListener(e -> {
            try {
                agregarCliente();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void agregarCliente() throws Exception {

        // SI ES LO CONTRARIO DE TRUE, RETORNAMOS PARA DETENER LA EJECUCIÓN DEL MÉTODO.
        if (!getDatosPanelCliente()) {
            return;
        }
        cliente.crearCliente();
        Alerta.mensaje("Cliente registrado correctamente", "Éxito", 1);
    }

    // Obtener datos cliente
    public boolean getDatosPanelCliente() {
        String nombre = view.getTxtNombre().getText();
        String apellido = view.getTxtApellido().getText();
        String email = view.getTxtEmail().getText();
        String telefono = view.getTxtTelefono().getText();

        try {
            cliente = new Cliente(nombre, apellido, email, telefono);
            return  true;
        } catch (Exception e) {
            Alerta.mensaje(e.getMessage(), "Error", 0);
            return false;
        }
    }

}
