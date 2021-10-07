package me.defian.sessionspringboot.dto;

public class MemberResponseDto {

    private Long id;
    private String username;

    public MemberResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "MemberResponseDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
