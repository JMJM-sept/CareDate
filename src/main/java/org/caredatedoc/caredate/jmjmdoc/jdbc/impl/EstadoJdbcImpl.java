package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Estado;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class EstadoJdbcImpl extends Conexion<Estado> implements EstadoJdbc {

    private static EstadoJdbcImpl estadoJdbc;

    private EstadoJdbcImpl() {
        super();
    }

    public static EstadoJdbcImpl getInstance() {
        if( estadoJdbc == null )
        {
            estadoJdbc = new EstadoJdbcImpl();
        }
        return estadoJdbc;
    }

    @Override
    public List<Estado> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Estado> list = null;
        String sql = "Select * from direccion";

        try {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet == null) {
                return null;
            }

            list = new java.util.ArrayList<Estado>();
            while (resultSet.next()) {

            }
        }
    }

    @Override
    public boolean save(Estado estado) {
        return false;
    }

    @Override
    public boolean update(Estado estado) {
        return false;
    }

    @Override
    public boolean delete(Estado estado) {
        return false;
    }

    @Override
    public Estado findById(Integer id) {
        return null;
    }
}
