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
    public List<Direccion> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Direccion> list = null;
        Direccion direccion = null;
        String sql = "SELECT * FROM direccion";

        try {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                if (resultSet == null) {
                    return null;
                }
                list = new java.util.ArrayList<Direccion>();
                while (resultSet.next()) {
                    direccion = new Direccion();
                    direccion.setId(resultSet.getInt("ID"));
                    direccion.setAlcaldiaP(resultSet.getString("ALCALDIA"));
                    direccion.setColoniaP(resultSet.getString("COLONIA"));
                    direccion.setCalleP(resultSet.getString("CALLE"));
                    direccion.setNumeroP(resultSet.getInt("NUMERO"));
                    direccion.setCpP(resultSet.getInt("CP"));
                    list.add(direccion);
                }
                resultSet.close();
                closeConnection();
                return list;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean save(Direccion direccion) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO direccion (ALCALDIA, COLONIA, CALLE, NUMERO, CP) VALUES (?, ?, ?, ?, ?)";
        /*try {
            preparedStatement.setString(1,direccion.getAlcaldiaP());
            preparedStatement.setString(2,direccion.getColoniaP());
            preparedStatement.setString(3,direccion.getCalleP());
            preparedStatement.setInt(4,direccion.getNumeroP());
            preparedStatement.setInt(5,direccion.getCpP());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, direccion.getAlcaldiaP());
            preparedStatement.setString(2, direccion.getColoniaP());
            preparedStatement.setString(3, direccion.getCalleP());
            preparedStatement.setInt(4,direccion.getNumeroP());
            preparedStatement.setInt(5, direccion.getCpP());

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
        String sql ="SELECT * FROM direccion WHERE   ID = %d";
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
                direccion.setId( resultSet.getInt( "IDDIRECCION" ) );
                direccion.setAlcaldiaP( resultSet.getString( "ALCALDIA" ) );
                direccion.setColoniaP( resultSet.getString( "COLONIA" ) );
                direccion.setCalleP( resultSet.getString( "CALLE" ) );
                direccion.setNumeroP( resultSet.getInt( "NUMERO" ) );
                direccion.setCpP( resultSet.getInt( "CP" ) );

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
