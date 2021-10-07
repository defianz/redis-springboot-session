package me.defian.sessionspringboot.dto;

public class MemberRequestDto {

    private String username;
    private String password;

    public MemberRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
