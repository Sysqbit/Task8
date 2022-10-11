package com.example.roomdarabasedemo.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdarabasedemo.models.users;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(users...users);

    @Query("SELECT * FROM USERS")
    public List<users> getAllUsers();

    @Delete
    public void delete(users use);


}
