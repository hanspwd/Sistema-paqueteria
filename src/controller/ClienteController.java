package controller;

import model.Cliente;
import view.Alerta;
import view.ClientePanel;
import javax.swing.table.DefaultTableModel;

public class ClienteController {

    private ClientePanel view;
    private Cliente cliente;

    public ClienteController(ClientePanel view) {
        this.view = view;
        init();
    }

    private void init() {
        cliente = new Cliente();

        try {
            listarClientes();
        } catch (Exception e) {
            Alerta.mensaje(
            "Ocurrió un error al intentar listar a los clientes a la tabla",
            "ERROR",
            0);
        }

        view.getBtnActualizar().setEnabled(false);
        setBtnListeners();
    }


    private void setBtnListeners() {
        view.getBtnAgregar().addActionListener(e -> {
            try {
                agregarCliente();
                reiniciarCampos();
                listarClientes();
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "Error", 0);
            }
        });

        view.getBtnActualizar().addActionListener(e -> {
            try {
                actualizarDatosCliente();
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "Error", 0);
            }

        });

        view.getBtnEliminar().addActionListener(e -> {
            try {
                eliminarCliente();
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "Error", 0);
            }
        });

        view.getBtnBuscar().addActionListener(e -> {
            try {
                buscarClientePorId();
                view.getBtnActualizar().setEnabled(true);
            } catch (Exception ex) {
                Alerta.mensaje(ex.getMessage(), "Error", 0);
            }
        });

        view.getBtnLimpiarTodo().addActionListener(e -> {
            reiniciarCampos();
        });
    }

    private void eliminarCliente() throws Exception {
        int id = Integer.parseInt(view.getTxtId().getText());
        cliente.eliminaCliente(id);
        reiniciarCampos();
        listarClientes();
    }


    /* TODO, Al hacer click el botón para buscar por id dejar activado solo, actualizar, eliminar y limpiar campos*/
    private void buscarClientePorId() throws Exception {
        Cliente c = cliente.buscarPorId(Integer.parseInt(view.getTxtId().getText()));

        view.getTxtId().setEnabled(false);
        view.getBtnAgregar().setEnabled(false);
        if(c != null) {
            view.getTxtNombre().setText(c.getNombre());
            view.getTxtApellido().setText(c.getApellido());
            view.getTxtEmail().setText(c.getEmail());
            view.getTxtTelefono().setText(c.getTelefono());
        } else {
            Alerta.mensaje("El id del cliente no existe", "Alerta", 1);
        }
    }

    private void actualizarDatosCliente() throws Exception{
        getDatosPanelCliente();
        String id = view.getTxtId().getText();
        cliente.setId(Integer.parseInt(id));

        cliente.actualizarDatos();
        reiniciarCampos();
        listarClientes();
    }

    private void agregarCliente() throws Exception {
        // SI ES LO CONTRARIO DE TRUE, RETORNAMOS PARA DETENER LA EJECUCIÓN DEL MÉTODO.
        if (!getDatosPanelCliente()) {
            return;
        }
        cliente.crearCliente();
        Alerta.mensaje("Cliente registrado correctamente", "Éxito", 1);
    }

    private void listarClientes() throws Exception {
        String[] header = {"ID", "NOMBRE", "APELLIDO", "EMAIL", "FONO"};
        DefaultTableModel tableModel = new  DefaultTableModel(header, 0);
        String[] datos = new String[header.length+1];
        for (Cliente cliente : cliente.listarCliente()) {
            datos[0] = String.valueOf(cliente.getId());
            datos[1] = cliente.getNombre();
            datos[2] = cliente.getApellido();
            datos[3] = cliente.getEmail();
            datos[4] = cliente.getTelefono();
            tableModel.addRow(datos);
        }
        view.getTblDatosCliente().setModel(tableModel);
    }
    /*
    * Aca abajo cosas útiles
    * */

    // Limpiar textFields
    private void reiniciarCampos() {
        view.getTxtId().setEnabled(true);
        view.getBtnAgregar().setEnabled(true);
        view.getBtnActualizar().setEnabled(false);
        view.getBtnBuscar().setEnabled(true);
        view.getBtnLimpiarTodo().setEnabled(true);
        
        view.getTxtId().setText("");
        view.getTxtNombre().setText("");
        view.getTxtApellido().setText("");
        view.getTxtEmail().setText("");
        view.getTxtTelefono().setText("");
    }

    // Obtener datos cliente
    private boolean getDatosPanelCliente() {
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
