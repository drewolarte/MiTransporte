package clases;

public class Login {

    private int id;
    private String contrasena;
    private int personaId;

    public Login() {
        this.id = 0;
        this.contrasena = "";
        this.personaId = 0;
    }

    public Login(int id, String contrasena, int personaId) {
        this.id = id;
        this.contrasena = contrasena;
        this.personaId = personaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", contrasena=" + contrasena + ", personaId=" + personaId + '}';
    }

}
