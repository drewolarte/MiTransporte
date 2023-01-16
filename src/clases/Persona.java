package clases;

public class Persona {

    private int id;
    private String documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String email;
    private int rolId;

    public Persona() {
        this.id = 0;
        this.documento = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.ciudad = "";
        this.telefono = "";
        this.email = "";
        this.rolId = 0;
    }

    public Persona(int id, String documento, String nombre, String apellido, String direccion, String ciudad, String telefono, String email, int rolId) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
        this.rolId = rolId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono + ", email=" + email + ", rolId=" + rolId + '}';
    }

}
