package modelo;

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

public class PersonaDB extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Persona objPersona = (Persona) obj;
        try {
            String sql = "INSERT INTO persona(documento,nombre,apellido,direccion,ciudad,telefono,email,rol_id) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objPersona.getDocumento());
            preparedStatement.setString(2, objPersona.getNombre());
            preparedStatement.setString(3, objPersona.getApellido());
            preparedStatement.setString(4, objPersona.getDireccion());
            preparedStatement.setString(5, objPersona.getCiudad());
            preparedStatement.setString(6, objPersona.getTelefono());
            preparedStatement.setString(7, objPersona.getEmail());
            preparedStatement.setInt(8, objPersona.getRolId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objPersona.setId(rs.getInt(1));
            }
            preparedStatement.close();
//            JOptionPane.showMessageDialog(null, "La inserción de la persona fue exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la persona: " + e.getMessage());
        }
        cerrarConexion();
        return objPersona;
    }

    @Override
    public boolean actualizar(Object obj) {
        Persona objPersona = (Persona) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE persona SET documento=?,nombre=?,apellido=?,direccion=?,ciudad=?,telefono=?,email=?,rol_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objPersona.getDocumento());
            preparedStatement.setString(2, objPersona.getNombre());
            preparedStatement.setString(3, objPersona.getApellido());
            preparedStatement.setString(4, objPersona.getDireccion());
            preparedStatement.setString(5, objPersona.getCiudad());
            preparedStatement.setString(6, objPersona.getTelefono());
            preparedStatement.setString(7, objPersona.getEmail());
            preparedStatement.setInt(8, objPersona.getRolId());
            preparedStatement.setInt(9, objPersona.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización de la persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Persona objPersona = (Persona) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM persona WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    public boolean eliminar(String documento) {
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM persona WHERE documento=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, documento);
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Persona objPersona = (Persona) obj;
        try {
            String sql = "SELECT * FROM persona WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona.setDocumento(resultSet.getString("documento"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setCiudad(resultSet.getString("ciudad"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setRolId(resultSet.getInt("rol_id"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objPersona;
    }

    public Object listarUno(String documento) {
        Connection conex = abrirConexion();
        Persona objPersona = new Persona();

        try {
            String sql = "SELECT * FROM persona WHERE documento = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, documento);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona.setId(resultSet.getInt("id"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setCiudad(resultSet.getString("ciudad"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setRolId(resultSet.getInt("rol_id"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objPersona;
    }

    public Object listarUno(int id) {
        Connection conex = abrirConexion();
        Persona objPersona = new Persona();

        try {
            String sql = "SELECT * FROM persona WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona.setId(resultSet.getInt("id"));
                objPersona.setDocumento(resultSet.getString("documento"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setCiudad(resultSet.getString("ciudad"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setRolId(resultSet.getInt("rol_id"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objPersona;
    }

    @Override
    public List<Object> listarTodos() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Persona objPersona;
        try {
            String sql = "SELECT * FROM persona ORDER BY apellido ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona = new Persona();
                objPersona.setId(resultSet.getInt("id"));
                objPersona.setDocumento(resultSet.getString("documento"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setApellido(resultSet.getString("apellido"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setCiudad(resultSet.getString("ciudad"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setRolId(resultSet.getInt("rol_id"));
                rowsQuery.add(objPersona);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        cerrarConexion();
        return rowsQuery;
    }

}
