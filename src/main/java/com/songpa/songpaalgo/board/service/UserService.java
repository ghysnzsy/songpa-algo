package com.songpa.songpaalgo.board.service;

import com.songpa.songpaalgo.board.domain.User;
import com.songpa.songpaalgo.board.dto.UserDto;
import com.songpa.songpaalgo.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository ur;

    @Transactional
    public void signup(User user) {
        ur.save(user);
    }
}
