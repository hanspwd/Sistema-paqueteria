package model;

import model.enums.TipoPaquete;

public class Paquete {

    private String idPaquete;
    private TipoPaquete tipoPaquete;
    private String contenido; // PUEDEN SER PRODUCTOS ETC (SE HARA UNA IMPLEMENTACION BASICA POR AHORA)

    public Paquete(String idPaquete, TipoPaquete tipoPaquete, String contenido) throws Exception{
        this.setIdPaquete(idPaquete);
        this.setTipoPaquete(tipoPaquete);
        this.setContenido(contenido);
    }

    public Paquete(TipoPaquete tipoPaquete, String contenido) throws Exception{
        this.setTipoPaquete(tipoPaquete);
        this.setContenido(contenido);
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    public TipoPaquete getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(TipoPaquete tipoPaquete) throws Exception {
        if(tipoPaquete != null) {
            this.tipoPaquete = tipoPaquete;
        } else {
            throw new Exception("El tipo de paquete no puede ser nulo");
        }
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) throws Exception {
        if(!contenido.isBlank()) {
            this.contenido = contenido;
        } else {
            throw new Exception("El paquete y/o su contenido no puede estar vacio");
        }
    }
}
