package com.arhiser.todolist;

import android.app.Application;
import androidx.room.Room;
import com.arhiser.todolist.data.AppDatabase;
import com.arhiser.todolist.data.NoteDao;
import com.arhiser.todolist.data.UserDao;

public class App extends Application {

    private AppDatabase database;
    private NoteDao noteDao;
    private UserDao userDao;
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
        userDao = database.userDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public UserDao getUserDao(){return userDao;}

    public void setUserDao(UserDao userDao) {this.userDao = userDao;}
}
