package kr.code6150.data;

import java.security.PrivateKey;

public class User {

    private final int number;
    private final String id;
    private final String password;
    private final String nickname;

    public User(int number, String id, String password, String nickname) {
        this.number = number;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    public int getNumber() {
        return number;
    }

    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
