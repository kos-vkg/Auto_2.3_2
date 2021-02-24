package ru.netology.data;


import lombok.*;
//@Data
//@AllArgsConstructor
//@RequiredArgsConstructor
// lombok запустить так и не удалось.

public class UserData {
    private final String login;
    private final String password;
    private final String status;

    public UserData(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }
}
