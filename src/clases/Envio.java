package clases;

public class Envio {

    private int id;
    private String descripcion;
    private String direccion;
    private String ciudadDestino;
    private String ciudadOrigen;
    private String fechaEnvio;
    private double costo;
    private String observaciones;
    private int personaId;

    public Envio() {
        this.id = 0;
        this.descripcion = "";
        this.direccion = "";
        this.ciudadDestino = "";
        this.ciudadOrigen = "";
        this.fechaEnvio = "";
        this.costo = 0;
        this.observaciones = "";
        this.personaId = 0;
    }

    public Envio(int id, String descripcion, String direccion, String ciudadDestino, String ciudadOrigen, String fechaEnvio, double costo, String observaciones, int personaId) {
        this.id = id;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.fechaEnvio = fechaEnvio;
        this.costo = costo;
        this.observaciones = observaciones;
        this.personaId = personaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Override
    public String toString() {
        return "Envio{" + "id=" + id + ", descripcion=" + descripcion + ", direccion=" + direccion + ", ciudadDestino=" + ciudadDestino + ", ciudadOrigen=" + ciudadOrigen + ", fechaEnvio=" + fechaEnvio + ", costo=" + costo + ", observaciones=" + observaciones + ", personaId=" + personaId + '}';
    }

}
