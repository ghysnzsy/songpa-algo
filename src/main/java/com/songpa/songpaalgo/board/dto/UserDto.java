package com.songpa.songpaalgo.board.dto;

import com.songpa.songpaalgo.board.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userid;
    private String userpw;
    public User toEntity() {
        return User.builder()
                   .userid(userid)
                   .userpw(userpw)
                   .build();
    }
    public UserDto(User user) {
        this.id = user.getId();
        this.userid = user.getUserid();
        this.userpw = user.getUserpw();
    }
}
