package com.songpa.songpaalgo.board.controller;

import com.songpa.songpaalgo.board.domain.User;
import com.songpa.songpaalgo.board.dto.UserDto;
import com.songpa.songpaalgo.board.dto.UserDto;
import com.songpa.songpaalgo.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/test")
    public ResponseEntity<UserDto> test(@RequestBody UserDto user) {
        System.out.println(user.getUserid()+" : "+user.getUserpw());
        return null;
    }
    @PutMapping("/put-test/{id}")
    public ResponseEntity<UserDto> putTest(@PathVariable int id, @RequestBody UserDto user) {
        System.out.println(user.getUserid()+" : "+user.getUserpw()+" : "+id);
        return null;
    }
    @DeleteMapping("/del-test/{id}")
    public ResponseEntity<UserDto> delTest(@PathVariable int id, @RequestBody UserDto user) {
        System.out.println(user.getUserid()+" : "+user.getUserpw()+" : "+id);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto) {
        User u = User.builder().userid(userDto.getUserid()).userpw(userDto.getUserpw()).build();
        userService.signup(u);
        return ResponseEntity.ok(new UserDto(u));
    }
    //@GetMapping
    //public ResponseEntity<UserDto>
}
