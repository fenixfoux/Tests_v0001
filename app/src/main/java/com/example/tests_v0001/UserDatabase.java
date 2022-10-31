package com.example.tests_v0001;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public static String DB_NAME = "userDB";
    public abstract DAO_User getDAO_User();

    public static UserDatabase userDB;

    public static UserDatabase getInstance(Context context){
        if(null == userDB){
            userDB = buildDatabaseInstance(context);
        }
        return userDB;
    }

    private static UserDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context,
                UserDatabase.class,
                DB_NAME).allowMainThreadQueries().build(); //разрешает запросы в главном потоке
    }

    public void cleanUp(){
        userDB = null;
    }

}
