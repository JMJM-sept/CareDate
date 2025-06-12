package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DireccionJdbcImpl extends Conexion<Direccion> implements DireccionJdbc {

    private static DireccionJdbcImpl direccionJdbc;

    private DireccionJdbcImpl( )
    {
        super( );
    }


    public static DireccionJdbcImpl getInstance( )
    {
        if( direccionJdbc == null )
        {
            direccionJdbc = new DireccionJdbcImpl();
        }
        return direccionJdbc;
    }

    @Override
    public List<Direccion> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Direccion> list = null;
        Direccion direccion = null;
        String sql ="Select * from direccion";


        try
        {
            if( !openConnection() )
            {
                System.out.println("ERROR");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            list =  new java.util.ArrayList<Direccion>( );
            while( resultSet.next( ) )
            {
                direccion = new Direccion();
                direccion.setId( resultSet.getInt( "ID" ) );
                direccion.setEstado( resultSet.getString( "ESTADO" ) );
                direccion.setMunicipio(resultSet.getString("MUNICIPIO"));
                direccion.setColonia(resultSet.getString("COLONIA"));
                direccion.setCalle(resultSet.getString("CALLE"));
                direccion.setNumero(resultSet.getInt("NUMERO"));
                direccion.setCp(resultSet.getInt("CP"));
                list.add( direccion );
            }
            resultSet.close( );
            closeConnection( );
            return list;
        }
        catch (SQLException e)
        {
            return null;
        }
    }

    @Override
    public boolean save(Direccion direccion) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO direccion (ESTADO) VALUES (?)";
        query = "INSERT INTO direccion (MUNICIPIO) VALUES (?)";
        query = "INSERT INTO direccion (COLONIA) VALUES (?)";
        query = "INSERT INTO direccion (CALLE) VALUES (?)";
        query = "INSERT INTO direccion (NUMERO) VALUES (?)";
        query = "INSERT INTO direccion (CP) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, direccion.getEstado());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Direccion direccion) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE direccion SET ESTADO = ? WHERE ID = ?";
        query = "UPDATE direccion SET ESTADO = ? WHERE ID = ?";
        query = "UPDATE direccion SET MUNICIPIO = ? WHERE ID = ?";
        query = "UPDATE direccion SET COLONIA = ? WHERE ID = ?";
        query = "UPDATE direccion SET CALLE = ? WHERE ID = ?";
        query = "UPDATE direccion SET NUMERO = ? WHERE ID = ?";
        query = "UPDATE direccion SET CP = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, direccion.getEstado());
            preparedStatement.setInt(2, direccion.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Direccion direccion) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM direccion WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, direccion.getEstado());
            preparedStatement.setInt(1, direccion.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Direccion findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Direccion direccion = null;
        String sql ="Select * from direccion where ID = %d";
        try
        {
            if( !openConnection() )
            {
                return null;
            }
            sql = String.format(sql, id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( !openConnection() )
            {
                return null;
            }
            sql = String.format(sql, id);

            while( resultSet.next( ) )
            {
                direccion = new Direccion();
                direccion.setId( resultSet.getInt( "ID" ) );
                direccion.setEstado( resultSet.getString( "ESTADO" ) );
                direccion.setMunicipio( resultSet.getString( "MUNICIPIO" ) );
                direccion.setColonia( resultSet.getString( "COLONIA" ) );
                direccion.setCalle( resultSet.getString( "CALLE" ) );
                direccion.setNumero( resultSet.getInt( "NUMERO" ) );
                direccion.setCp( resultSet.getInt( "CP" ) );

            }
            resultSet.close( );
            closeConnection( );
            return direccion;
        }
        catch (SQLException e)
        {
            return null;
        }    }
}
