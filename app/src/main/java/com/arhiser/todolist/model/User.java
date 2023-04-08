package com.arhiser.todolist.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Objects;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    public String login;

    @ColumnInfo(name = "password")
    public String password;

    public User() {

    }

    public User(@NonNull String login, String password) {
        this.login = login;
        this.password = password;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
