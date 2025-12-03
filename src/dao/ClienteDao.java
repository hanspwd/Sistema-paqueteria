package dao;

import config.Conexion;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements ICrud<Cliente>{


    @Override
    public void create(Cliente cliente) throws Exception {
        Conexion cnx = new Conexion();

        try(Connection con = cnx.conectar()) {

            String sql = "INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `email`, `telefono`) VALUES (NULL, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.executeUpdate();
        }

    }

    @Override
    public List<Cliente> readAll() throws Exception {

        List<Cliente> lista = new ArrayList<>();
        Conexion cnx = new Conexion();
        try(Connection con = cnx.conectar()) {
            String sql = "SELECT * FROM `cliente`;";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
                lista.add(cliente);
            }
        }

        return lista;
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        String sql = "UPDATE `cliente` SET `nombre`=?,`apellido`=?,`email`=?,`telefono`=? WHERE `id`= ?";
        Conexion cnx = new Conexion();
        try(Connection con = cnx.conectar()) {

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.setInt(5, cliente.getId());
            pst.executeUpdate();

            con.close();
            pst.close();
        }

    }

    @Override
    public void delete(int id) throws Exception {
        String sql =  "DELETE FROM `cliente` WHERE id=?";

        Conexion cnx = new Conexion();
        try(Connection con = cnx.conectar()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    @Override
    public Cliente readById(int id) throws Exception {
        String sql = "SELECT * FROM cliente WHERE id = ?";

        Conexion cnx = new Conexion();

        try (Connection con = cnx.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                return cliente;
            }

            return null; // No encontró nada
        }
    }

}
