package com.arhiser.todolist.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.arhiser.todolist.model.User;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE login IN (:login)")
    List<User> loadAllByIds(int[] login);

    @Query("SELECT * FROM user WHERE login LIKE :login AND " +
            "password LIKE :password LIMIT 1")
    User findByName(String login, String password);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}

