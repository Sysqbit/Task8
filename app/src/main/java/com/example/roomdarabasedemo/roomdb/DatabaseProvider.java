package com.example.roomdarabasedemo.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdarabasedemo.dao.UserDao;
import com.example.roomdarabasedemo.models.users;


@Database(entities = {users.class},version = 1)
public abstract class DatabaseProvider extends RoomDatabase {

    public abstract UserDao getuserDao();




    private static DatabaseProvider databaseProvider=null;
    public static DatabaseProvider getDbConnection(Context context){
        if (databaseProvider==null){

            databaseProvider = Room.databaseBuilder(context.getApplicationContext(),DatabaseProvider.class,"mydb")
                    .allowMainThreadQueries()
                    .build();

        }
        return databaseProvider;
    }

}
