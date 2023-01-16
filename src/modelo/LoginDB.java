package modelo;

import clases.Login;
import clases.Persona;
import database.CRUD;
import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LoginDB extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Login objLogin = (Login) obj;
        try {
            String sql = "INSERT INTO login(contrasena,persona_id) VALUES(md5(?),?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objLogin.getContrasena());
            preparedStatement.setInt(2, objLogin.getPersonaId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objLogin.setId(rs.getInt(1));
            }
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "La inserción del login fue exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el login: " + e.getMessage());
        }
        cerrarConexion();
        return objLogin;
    }

    @Override
    public boolean actualizar(Object obj) {
        Login objLogin = (Login) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE login SET contrasena=?,persona_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objLogin.getContrasena());
            preparedStatement.setInt(2, objLogin.getPersonaId());
            preparedStatement.setInt(3, objLogin.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización del login: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Login objLogin = (Login) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM login WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objLogin.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el login: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Login objLogin = (Login) obj;
        try {
            String sql = "SELECT * FROM login WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objLogin.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objLogin.setContrasena(resultSet.getString("contrasena"));
                objLogin.setPersonaId(resultSet.getInt("persona_id"));

            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objLogin;
    }

    public Object listarUno(int idPersona) {
        Connection conex = abrirConexion();
        Login objLogin = new Login();
        try {
            String sql = "SELECT * FROM login WHERE persona_id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, idPersona);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objLogin.setId(resultSet.getInt("id"));
                objLogin.setContrasena(resultSet.getString("contrasena"));
                objLogin.setPersonaId(resultSet.getInt("persona_id"));

            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objLogin;
    }

    @Override
    public List<Object> listarTodos() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Login objLogin;
        try {
            String sql = "SELECT * FROM login ORDER BY id ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objLogin = new Login();
                objLogin.setId(resultSet.getInt("id"));
                objLogin.setContrasena(resultSet.getString("contrasena"));
                objLogin.setPersonaId(resultSet.getInt("persona_id"));
                rowsQuery.add(objLogin);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        cerrarConexion();
        return rowsQuery;
    }

    public boolean insertar(Login objLogin) {
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "INSERT INTO Login(persona_id,contrasena) VALUES(?,md5(?))";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objLogin.getPersonaId());
            preparedStatement.setString(2, objLogin.getContrasena());
            preparedStatement.execute();
            preparedStatement.close();
            flag = true;
//JOptionPane.showMessageDialog(null, "La inserción del login fue exitoso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la contraseña: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    public boolean actualizar(Login objLogin) {
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE Login SET contrasena=md5(?) WHERE persona_id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objLogin.getContrasena());
            preparedStatement.setInt(2, objLogin.getPersonaId());
            preparedStatement.execute();
            preparedStatement.close();
            flag = true;
//JOptionPane.showMessageDialog(null, "La inserción del login fue exitoso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    public boolean eliminar(int idpersona) {
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM Login WHERE persona_id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, idpersona);
            preparedStatement.execute();
            preparedStatement.close();
            flag = true;
//JOptionPane.showMessageDialog(null, "La inserción del login fue exitoso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la contraseña: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    public String obtenerContrasena(int idpersona) {
        Connection conex = abrirConexion();
        String contrasena = "";
        try {
            String sql = "SELECT contrasena FROM login WHERE persona_id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, idpersona);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contrasena = resultSet.getString("contrasena");
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }
        cerrarConexion();
        return contrasena;
    }

    public boolean puedeAccederAlSistema(String identificacion, String contrasena) {

        PersonaDB objPersonaDB = new PersonaDB();
        Persona objPersona = (Persona) objPersonaDB.listarUno(identificacion);
        int total = 0;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT count(id) AS total FROM login WHERE persona_id = ? AND contrasena=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getId());
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getInt("total");
                if (total == 1) {
                    flag = true;
                }
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return flag;
    }

}
