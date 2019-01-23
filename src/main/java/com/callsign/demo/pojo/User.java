package com.callsign.demo.pojo;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {

    private String id;

    private String password;

    private LocalDateTime lastLogin;


    public User(String id, String password) {
        this.id = Objects.requireNonNull(id);
        this.password = Objects.requireNonNull(password);
        this.lastLogin = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(password, user.password) &&
                Objects.equals(lastLogin, user.lastLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, lastLogin);
    }
}
