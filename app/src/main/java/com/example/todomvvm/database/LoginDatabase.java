package com.example.todomvvm.database;


import android.content.Context;
import android.provider.CalendarContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;



@Database(entities = {UsernamePassword.class},version = 1)
@TypeConverters({DateConverter.class})
public abstract class LoginDatabase extends RoomDatabase {

    private static LoginDatabase INSTANCE = null;

    public abstract RoomDAO getRoomDAO();

    public static LoginDatabase geLoginDatabase(Context context){

        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),LoginDatabase.class,"users")
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;

    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
