/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.dao;

import tienda.connection.Conexion;
import tienda.entidades.Booster;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author intel
 */
public class BoosterDao extends BaseDAO<Booster>{

    public BoosterDao(){
        table =new TableData(
                "booster",
                "idBooster",
                new String[]{"descripcion","precio","nombre"});
    }
    @Override
    Booster mapToObject(ResultSet resultSet) {
        Booster b = new Booster();
        try{
            b.setId(resultSet.getInt(table.PRIMARY_KEY));
            b.setNombre(resultSet.getString(table.fields[2]));
            b.setDescripcion(resultSet.getString(table.fields[0]));
            b.setPrecio(resultSet.getInt(table.fields[1]));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return b;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Booster find, String by) {
        String query = "SELECT * FROM "+table.TABLE_NAME+" WHERE "+by+" = ?";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY))
                preparedStatement.setInt(1, find.getId());
            if (by.equals(table.fields[3]))
                preparedStatement.setString(1, find.getNombre());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Booster _new) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Booster deleteObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Booster> getBoosters(){
        Connection con =null;
        ArrayList<Booster> boosters = new ArrayList<>();
        try{
            con = Conexion.getInstance().getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM "+table.TABLE_NAME);
            
            while (resultSet.next()){
                boosters.add(mapToObject(resultSet));
            }
            resultSet.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(con != null){
                try{
                    con.close();
                }catch(Exception e){}
            }
        }
        return boosters;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Booster updateObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
