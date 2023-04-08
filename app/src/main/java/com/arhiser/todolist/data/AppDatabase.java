package com.arhiser.todolist.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.arhiser.todolist.model.Note;
import com.arhiser.todolist.model.User;

@Database(entities = {Note.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
    public abstract UserDao userDao();
}
