package model;

import model.enums.EstadoEnvio;

public class Envio {

    private int  idEnvio;

    private Cliente remitente;
    private Cliente destinatario;
    private String direccionEnvio;

    private Paquete paquete;
    private double precioEnvio;

    private EstadoEnvio estadoEnvio;

    public Envio() {
    }

    public Envio(Cliente remitente, Cliente destinatario, String direccionEnvio,
                 Paquete paquete, double precioEnvio, EstadoEnvio estadoEnvio) throws Exception {

        this.setRemitente(remitente);
        this.setDestinatario(destinatario);
        this.setDireccionEnvio(direccionEnvio);
        this.setPaquete(paquete);
        this.setPrecioEnvio(precioEnvio);
        this.setEstadoEnvio(estadoEnvio);
    }

    public Envio(int idEnvio, Cliente remitente, Cliente destinatario, String direccionEnvio,
                 Paquete paquete, double precioEnvio, EstadoEnvio estadoEnvio) throws Exception {

        this.setIdEnvio(idEnvio);
        this.setRemitente(remitente);
        this.setDestinatario(destinatario);
        this.setDireccionEnvio(direccionEnvio);
        this.setPaquete(paquete);
        this.setPrecioEnvio(precioEnvio);
        this.setEstadoEnvio(estadoEnvio);
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Cliente getRemitente() {
        return remitente;
    }

    public void setRemitente(Cliente remitente) throws Exception{
        if(remitente != null){
            this.remitente = remitente;
        } else {
            throw new Exception("Remitente nulo");
        }
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) throws Exception{
        if(destinatario != null){
            this.destinatario = destinatario;
        } else {
            throw new Exception("Destinatario nulo");
        }
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) throws Exception{
        if(!direccionEnvio.isBlank()){
            this.direccionEnvio = direccionEnvio;
        }  else {
            throw new Exception("La dirección de envió no puede estar vacía");
        }

    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) throws Exception{
        if(paquete != null){
            this.paquete = paquete;
        } else {
            throw new Exception("El paquete no puede ser nulo");
        }
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) throws Exception {
        if(precioEnvio > 0){
            this.precioEnvio = precioEnvio;
        } else {
            throw new Exception("El precio del envio no puede ser negativo");
        }
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) throws Exception{
        if(estadoEnvio != null){
            this.estadoEnvio = estadoEnvio;
        } else {
            throw new Exception("El estado del envio no puede ser nulo");
        }
    }
}
