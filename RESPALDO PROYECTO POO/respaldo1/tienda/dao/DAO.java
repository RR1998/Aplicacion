package tienda.dao;

import tienda.connection.Conexion;

import java.util.List;

public interface DAO<T> {
    /**
     * Get a conecction to the database whitout know the password
     */
    Conexion con = Conexion.getInstance();

    /**
     * Get all register in the database
     *
     * @return ArrayList<T>
     */
    List<T> findAll();

    /**
     * Get all register in the database where the table are equals to value in the object
     *
     * @param <T> Object with a value to find
     * @param String name of the table to compare in the search
     * @return ArrayList<T>
     */
    List<T> findBy(T find, String by);

    /**
     * Insert Object in the database and add  id value
     *
     * @param insertObject data to insert
     * @return true is inserted in another case return false
     */
    boolean insert(T insertObject);

    /**
     * Update Object in the database where id value
     *
     * @param updateObject
     * @return
     */
    boolean update(T updateObject);

    /**
     * Delete Object in the database where id value are equals to object id table
     *
     * @param deleteObject
     * @return
     */
    boolean delete(T deleteObject);


}
