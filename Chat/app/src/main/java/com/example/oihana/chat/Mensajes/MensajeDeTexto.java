package com.example.oihana.chat.Mensajes;

/**
 * Created by Oihana on 17/07/2018.
 */

public class MensajeDeTexto {
    private  String id;
    private  String mensaje;
    private  int tipoMensaje;
    private String HoraDelMensaje;

    public MensajeDeTexto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(int tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getHoraDelMensaje() {
        return HoraDelMensaje;
    }

    public void setHoraDelMensaje(String horaDelMensaje) {
        HoraDelMensaje = horaDelMensaje;
    }
}
