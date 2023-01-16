package modelo;

import clases.Rol;
import database.CRUD;
import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RolDB extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Rol objRol = (Rol) obj;
        try {
            String sql = "INSERT INTO rol(rol) VALUES(?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objRol.getRol());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objRol.setId(rs.getInt(1));
            }
            preparedStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el rol: " + e.getMessage());
        }
        cerrarConexion();
        return objRol;
    }

    @Override
    public boolean actualizar(Object obj) {
        Rol objRol = (Rol) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE rol SET rol=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objRol.getRol());
            preparedStatement.setInt(2, objRol.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización del rol: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Rol objRol = (Rol) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM rol WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el rol: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Rol objRol = (Rol) obj;
        try {
            String sql = "SELECT * FROM rol WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol.setRol(resultSet.getString("rol"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objRol;
    }

    public Object listarUno(int rolId) {
        Connection conex = abrirConexion();
        Rol objRol = new Rol();
        try {
            String sql = "SELECT * FROM rol WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, rolId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol.setRol(resultSet.getString("rol"));
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objRol;
    }

    @Override
    public List<Object> listarTodos() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Rol objRol;
        try {
            String sql = "SELECT * FROM rol ORDER BY rol ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol = new Rol();
                objRol.setId(resultSet.getInt("id"));
                objRol.setRol(resultSet.getString("rol"));
                rowsQuery.add(objRol);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        cerrarConexion();
        return rowsQuery;
    }

}
