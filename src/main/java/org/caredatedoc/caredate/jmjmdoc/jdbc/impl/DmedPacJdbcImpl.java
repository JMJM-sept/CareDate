package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.DatosMedPac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DmedPacJdbcImpl extends Conexion<DatosMedPac> implements DmedPacJdbc {

    private static DmedPacJdbcImpl dmedPacJdbc;

    private DmedPacJdbcImpl() {
        super();
    }

    public static DmedPacJdbcImpl getInstance() {
        if (dmedPacJdbc == null) {
            dmedPacJdbc = new DmedPacJdbcImpl();
        }
        return dmedPacJdbc;
    }

    @Override
    public List<DatosMedPac> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<DatosMedPac> list = null;
        DatosMedPac datosMedPac = null;
        String sql ="Select * from TBL_ARTISTA";

        try
        {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                if (resultSet == null) {
                    return null;
                }
                list = new java.util.ArrayList<DatosMedPac>();
                while (resultSet.next()) {
                    datosMedPac = new DatosMedPac();
                    datosMedPac.setId(resultSet.getInt("ID"));
                    datosMedPac.setAlergias(resultSet.getString("nombre"));
                    datosMedPac.setMedicamentos(resultSet.getString(""));
                    datosMedPac.setCirugiasPre(resultSet.getString(""));
                    datosMedPac.setTipoSangre(resultSet.getString(""));
                    datosMedPac.setEnfCronicas(resultSet.getString(""));
                    list.add(datosMedPac);
                }
                resultSet.close();
                closeConnection();
                return list;
            }
        }
        catch (SQLException e)
        {
            return null;
        }
    }


    @Override
    public boolean save(DatosMedPac datosMedPac) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_ARTISTA (nombre) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, datosMedPac.getAlergias());
            preparedStatement.setString(1, datosMedPac.getMedicamentos());
            preparedStatement.setString(1, datosMedPac.getCirugiasPre());
            preparedStatement.setString(1, datosMedPac.getTipoSangre());
            preparedStatement.setString(1, datosMedPac.getEnfCronicas());
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
    public boolean update(DatosMedPac datosMedPac) {
            PreparedStatement preparedStatement = null;
            String query = "UPDATE TBL_ARTISTA SET nombre = ? WHERE ID = ?";
            int res = 0;

            try {
                if (!openConnection()) {
                    System.out.println("ERROR DE CONEXIÓN");
                    return false;
                }
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, datosMedPac.getAlergias());
                preparedStatement.setInt(2, datosMedPac.getId());
                preparedStatement.setString(2, datosMedPac.getMedicamentos());
                preparedStatement.setString(2, datosMedPac.getCirugiasPre());
                preparedStatement.setString(2, datosMedPac.getTipoSangre());
                preparedStatement.setString(2, datosMedPac.getEnfCronicas());

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
    public boolean delete(DatosMedPac datosMedPac) {
                PreparedStatement preparedStatement = null;
                String query = "DELETE FROM TBL_ARTISTA WHERE ID = ?";
                int res = 0;

                try {
                    if (!openConnection()) {
                        System.out.println("ERROR DE CONEXIÓN");
                        return false;
                    }
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, datosMedPac.getAlergias());
                    preparedStatement.setString(1, datosMedPac.getMedicamentos());
                    preparedStatement.setString(1, datosMedPac.getCirugiasPre());
                    preparedStatement.setString(1, datosMedPac.getTipoSangre());
                    preparedStatement.setString(1, datosMedPac.getEnfCronicas());

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
    public DatosMedPac findById(Integer id) {
                Statement statement = null;
                ResultSet resultSet = null;
                DatosMedPac datosMedPac = null;
                String sql ="Select * from TBL_ARTISTA where ID = %d";
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
                        datosMedPac = new DatosMedPac();
                        datosMedPac.setId( resultSet.getInt( "ID" ) );
                        datosMedPac.setAlergias( resultSet.getString( "nombre" ) );
                        datosMedPac.setMedicamentos( resultSet.getString( "nombre" ) );
                        datosMedPac.setCirugiasPre( resultSet.getString( "nombre" ) );
                        datosMedPac.setTipoSangre( resultSet.getString( "nombre" ) );
                        datosMedPac.setEnfCronicas( resultSet.getString( "nombre" ) );

                    }
                    resultSet.close( );
                    closeConnection( );
                    return datosMedPac;
                }
                catch (SQLException e)
                {
                    return null;
                }    }
    }
