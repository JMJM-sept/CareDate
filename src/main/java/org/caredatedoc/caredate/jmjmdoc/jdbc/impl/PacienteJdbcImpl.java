package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PacienteJdbcImpl extends Conexion<Paciente> implements PacienteJdbc{
    private static PacienteJdbcImpl pacienteJdbc;

    private PacienteJdbcImpl() {
        super();
    }

    public static PacienteJdbcImpl getInstance() {
        if (pacienteJdbc == null) {
            pacienteJdbc = new PacienteJdbcImpl();
        }
        return pacienteJdbc;
    }

    @Override
    public List<Direccion> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Paciente> list = null;
        Paciente paciente = null;
        String sql ="SELECT * FROM paciente";


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
            list =  new java.util.ArrayList<Paciente>( );
            while( resultSet.next( ) )
            {
                paciente = new Paciente();
                paciente.setId( resultSet.getInt( "ID" ) );
                paciente.setNombre(resultSet.getString("NOMBRE"));
                paciente.setaPaterno(resultSet.getString("APATERNO"));
                paciente.setaMaterno(resultSet.getString("AMATERNO"));
                paciente.setCurp(resultSet.getString("CURP"));
                paciente.setFechaNac(resultSet.getString("FECHANAC"));
                paciente.setSexo(resultSet.getString("SEXO").charAt(0));
                paciente.setEmail(resultSet.getString("EMAILPACIENTE"));

                list.add( paciente );
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
    public boolean save(Paciente paciente) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO direccion (NOMBRE, APATERNO, AMATERNO, CURP, FECHANAC, SEXO, EMAILPACIENTE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getaPaterno());
            preparedStatement.setString(3,paciente.getaMaterno());
            preparedStatement.setString(4,paciente.getCurp());
            preparedStatement.setString(5,paciente.getFechaNac());
            preparedStatement.setString(6, String.valueOf(paciente.getSexo()));
            preparedStatement.setString(7,paciente.getEmail());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int res = 0;
        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
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
    public Paciente findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Paciente paciente = null;
        String sql ="SELECT * FROM direccion WHERE ID = %d";
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
                paciente = new Paciente();
                paciente.setId( resultSet.getInt( "ID" ) );
                paciente.setNombre( resultSet.getString( "NOMBRE" ) );
                paciente.setaPaterno( resultSet.getString( "APATERNO" ) );
                paciente.setaMaterno( resultSet.getString( "AMATERNO" ) );
                paciente.setCurp( resultSet.getString( "CURP" ) );
                paciente.setFechaNac( resultSet.getString( "FECHANAC" ) );
                paciente.setSexo(resultSet.getString("SEXO").charAt(0));
                paciente.setEmail( resultSet.getString( "EMAILPACIENTE" ) );

            }
            resultSet.close( );
            closeConnection( );
            return paciente;
        }
        catch (SQLException e)
        {
            return null;
        }
    }
}
