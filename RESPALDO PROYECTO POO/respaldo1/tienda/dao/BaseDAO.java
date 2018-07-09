package tienda.dao;

//PENE

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public abstract class BaseDAO<T> implements DAO<T> {

    protected TableData table;
    
    

    public BaseDAO() {}

    public BaseDAO(TableData table) {
        this.table = table;
    }

    abstract T mapToObject(ResultSet resultSet);

    abstract PreparedStatement getSelectStatement(Connection con, T find, String by);

    abstract PreparedStatement getInsertStatement(Connection con, T _new);

    abstract PreparedStatement getDeleteStatement(Connection con, T deleteObject);
    
    abstract PreparedStatement getUpdateStatement(Connection con, T updateObject);

    @Override
    public List<T> findAll() {
        Connection con = null;
        ArrayList<T> listObject = new ArrayList<>(); // Result in Objet format
        try {
            con = this.con.getConnection(); //Conect to database
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table.TABLE_NAME);

            while (resultSet.next()) {
                T row = mapToObject(resultSet);
                listObject.add(row);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(con);
        }
        return listObject;
    }

    @Override
    public List<T> findBy(T find, String by) {
        Connection con = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getSelectStatement(con, find, by);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T row = mapToObject(resultSet);
                list.add(row);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(con);
        }
        return list;
    }

    @Override
    public boolean insert(T insertObject) {
        Connection con = null;
        boolean inserted = false;
        try {
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getInsertStatement(con, insertObject);
            inserted = preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(con);
        }
        return inserted;
    }

    @Override
    public boolean update(T updateObject) {
        Connection con = null;
        boolean updated = false;
        try {
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getUpdateStatement(con, updateObject);
            updated = preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(con);
        }
        return updated;
    }

    @Override
    public boolean delete(T deleteObject) {
        Connection con = null;
        boolean delete = false;
        try {
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getDeleteStatement(con,deleteObject);
            if(preparedStatement.executeUpdate() > 0){
                delete = true;
            }
            preparedStatement.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            close(con);
        }
        return delete;
    }

    private void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    class TableData {
        final String TABLE_NAME;
        final String PRIMARY_KEY;
        final String fields[];

        public TableData(String table_name, String primary_key, String[] fields) {
            TABLE_NAME = table_name;
            PRIMARY_KEY = primary_key;
            this.fields = fields;
        }
    }
}
