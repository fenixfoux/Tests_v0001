package com.example.tests_v0001;

import android.provider.SyncStateContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO_User {
    @Query("SELECT * FROM user") //user - is a table name
    List<User> getAll();
    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    void insert(User user);
    /*
     * update the object in database
     * @param note, object to be updated
     */
    @Update
    void update(User repos);
    /*
     * delete the object from database
     * @param note, object to be deleted
     */
    @Delete
    void delete(User user);
    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(User... user); // User... is varargs, here note is an array
}
