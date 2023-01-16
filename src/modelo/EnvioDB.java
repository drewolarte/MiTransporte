package modelo;

import clases.Envio;
import database.CRUD;
import database.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EnvioDB extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Envio objEnvio = (Envio) obj;
        try {
            String sql = "INSERT INTO envio(descripcion,direccion,ciudad_destino,ciudad_origen,fecha_envio,costo,observaciones,persona_id) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objEnvio.getDescripcion());
            preparedStatement.setString(2, objEnvio.getDireccion());
            preparedStatement.setString(3, objEnvio.getCiudadDestino());
            preparedStatement.setString(4, objEnvio.getCiudadOrigen());
            preparedStatement.setString(5, objEnvio.getFechaEnvio());
            preparedStatement.setDouble(6, objEnvio.getCosto());
            preparedStatement.setString(7, objEnvio.getObservaciones());
            preparedStatement.setInt(8, objEnvio.getPersonaId());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objEnvio.setId(rs.getInt(1));
            }
            preparedStatement.close();
//            JOptionPane.showMessageDialog(null, "La inserción del envío fue exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el envío: " + e.getMessage());
        }
        cerrarConexion();
        return objEnvio;
    }

    @Override
    public boolean actualizar(Object obj) {
        Envio objEnvio = (Envio) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE envio SET descripcion=?,direccion=?,ciudad_destino=?,ciudad_origen=?,fecha_envio=?,costo=?,observaciones=?,persona_id=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objEnvio.getDescripcion());
            preparedStatement.setString(2, objEnvio.getDireccion());
            preparedStatement.setString(3, objEnvio.getCiudadDestino());
            preparedStatement.setString(4, objEnvio.getCiudadOrigen());
            preparedStatement.setString(5, objEnvio.getFechaEnvio());
            preparedStatement.setDouble(6, objEnvio.getCosto());
            preparedStatement.setString(7, objEnvio.getObservaciones());
            preparedStatement.setInt(8, objEnvio.getPersonaId());
            preparedStatement.setInt(9, objEnvio.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la actualización del envío: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Envio objEnvio = (Envio) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM envio WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEnvio.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el envío: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    public boolean eliminar(int id) {

        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM envio WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el envío: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Envio objEnvio = (Envio) obj;
        try {
            String sql = "SELECT * FROM envio WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objEnvio.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEnvio.setId(resultSet.getInt("id"));
                objEnvio.setDescripcion(resultSet.getString("descripcion"));
                objEnvio.setDireccion(resultSet.getString("direccion"));
                objEnvio.setCiudadDestino(resultSet.getString("ciudad_destino"));
                objEnvio.setCiudadOrigen(resultSet.getString("ciudad_origen"));
                objEnvio.setFechaEnvio(resultSet.getString("fecha_envio"));
                objEnvio.setCosto(resultSet.getDouble("costo"));
                objEnvio.setObservaciones(resultSet.getString("observaciones"));
                objEnvio.setPersonaId(resultSet.getInt("persona_id"));

            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objEnvio;
    }

    public Object listarUno(int id) {
        Connection conex = abrirConexion();
        Envio objEnvio = new Envio();
        try {
            String sql = "SELECT * FROM envio WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEnvio.setId(resultSet.getInt("id"));
                objEnvio.setDescripcion(resultSet.getString("descripcion"));
                objEnvio.setDireccion(resultSet.getString("direccion"));
                objEnvio.setCiudadDestino(resultSet.getString("ciudad_destino"));
                objEnvio.setCiudadOrigen(resultSet.getString("ciudad_origen"));
                objEnvio.setFechaEnvio(resultSet.getString("fecha_envio"));
                objEnvio.setCosto(resultSet.getDouble("costo"));
                objEnvio.setObservaciones(resultSet.getString("observaciones"));
                objEnvio.setPersonaId(resultSet.getInt("persona_id"));

            }

            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: " + ex.getMessage());

        }

        cerrarConexion();
        return objEnvio;
    }

    @Override
    public List<Object> listarTodos() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Envio objEnvio;
        try {
            String sql = "SELECT * FROM envio ORDER BY id ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objEnvio = new Envio();
                objEnvio.setId(resultSet.getInt("id"));
                objEnvio.setDescripcion(resultSet.getString("descripcion"));
                objEnvio.setDireccion(resultSet.getString("direccion"));
                objEnvio.setCiudadDestino(resultSet.getString("ciudad_destino"));
                objEnvio.setCiudadOrigen(resultSet.getString("ciudad_origen"));
                objEnvio.setFechaEnvio(resultSet.getString("fecha_envio"));
                objEnvio.setCosto(resultSet.getDouble("costo"));
                objEnvio.setObservaciones(resultSet.getString("observaciones"));
                objEnvio.setPersonaId(resultSet.getInt("persona_id"));
                rowsQuery.add(objEnvio);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        cerrarConexion();
        return rowsQuery;
    }
}
