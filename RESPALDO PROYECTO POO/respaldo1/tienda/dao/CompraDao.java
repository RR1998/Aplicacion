/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dao;

import tienda.entidades.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author intel
 */
public class CompraDao extends BaseDAO<Compra>{

    public CompraDao(){
        table= new TableData(
                "compra",
                "idCompra",
                new String[]{"idJugador","idBooster","idCompra"}
        );
    }
    
    @Override
    Compra mapToObject(ResultSet resultSet) {
        Compra c = new Compra();
        try{
            c.setIdCompra(resultSet.getInt(table.PRIMARY_KEY));
            c.setIdJugador(resultSet.getInt(table.fields[1]));
            c.setIdBooster(resultSet.getInt(table.fields[2]));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return c;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Compra find, String by) {
        String query="SELECT * FROM "+table.TABLE_NAME+" WHERE "+by+" = ?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY))
                preparedStatement.setInt(1, find.getIdCompra());
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Compra _new) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(
                    "INSERT INTO " + table.TABLE_NAME +
                            "(" + table.fields[0] + "," + table.fields[1] + ")"
                            + " VALUES(?,?)");

            preparedStatement.setInt(1, _new.getIdJugador());
            preparedStatement.setInt(2, _new.getIdBooster());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        return preparedStatement;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Compra deleteObject) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement("DELETE FROM " + table.TABLE_NAME +" WHERE " + table.PRIMARY_KEY + " = ?" );
            preparedStatement.setInt(1,deleteObject.getIdCompra());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Compra updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
