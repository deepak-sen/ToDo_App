package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDAO {

    @Insert
    public void Insert(UsernamePassword... usernamePasswords);

    @Update
    public void Update(UsernamePassword... usernamePasswords);

    @Delete
    public void Delete(UsernamePassword usernamePassword);

    @Query("Select * from login where usename = :username")
    public UsernamePassword getUserwithUsername(String username);

    @Query("Select * from login where isloggedIn = 1")
    public UsernamePassword getLoggedInUser();


}
