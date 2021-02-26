package ru.netology.data;


import lombok.*;
@Data
@AllArgsConstructor

public class UserData {
    private final String login;
    private final String password;
    private final String status;
}
