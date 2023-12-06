package com.charlesedu.megamanapi.dto;

import java.io.Serializable;

import com.charlesedu.megamanapi.entities.UserModel;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(UserModel userModel) {
        this.setUsername(userModel.getUsername());
        this.setPassword(userModel.getPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
