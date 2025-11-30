package dao;

import config.Conexion;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return List.of();
    }

    @Override
    public void update(Cliente cliente) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void readById(int id) throws Exception {

    }
}
