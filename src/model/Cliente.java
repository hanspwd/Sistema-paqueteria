package model;

import dao.ClienteDao;

import java.util.List;

public final class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String telefono) throws  Exception {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setTelefono(telefono);
    }

    public Cliente(int id, String nombre, String apellido, String email, String telefono) throws Exception {
        this.setId(id);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setTelefono(telefono);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)throws Exception {
        if(!nombre.isBlank()) {
            this.nombre = nombre;
        } else{
            throw new Exception("El nombre del cliente no puede estar vacío");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception{
        if(!apellido.isBlank()) {
            this.apellido = apellido;
        } else{
            throw new Exception("El apellido del cliente no puede estar vacío");
        }
    }

    public String getEmail() {
        return email;
    }

    // Por mejorar (Debe verificar formato de email para confirmar su validez).
    public void setEmail(String email)  throws  Exception {
        if(!email.isBlank()) {
            this.email = email;
        } else{
            throw new Exception("El email del cliente no puede estar vacío");
        }

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws  Exception{
        if(!telefono.isBlank()) {
            this.telefono = telefono;
        } else{
            throw new Exception("El teléfono del cliente no puede estar vacío");
        }
    }

    public void crearCliente() throws Exception {
        // Comunicación con DAO
        ClienteDao dao = new ClienteDao();
        dao.create(this);
    }

    public List<Cliente> listarCliente() throws Exception {
        ClienteDao dao = new ClienteDao();
        return dao.readAll();
    }

    public void actualizarDatos() throws Exception {
        ClienteDao dao = new ClienteDao();
        dao.update(this);
    }

    public Cliente buscarPorId(int id) throws Exception {
        ClienteDao dao = new ClienteDao();
        return dao.readById(id);
    }

    public void eliminaCliente(int id) throws Exception {
        ClienteDao dao = new ClienteDao();
        dao.delete(id);
    }
}
