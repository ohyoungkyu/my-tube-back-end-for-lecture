package com.example.mytube.User.Service;

import com.example.mytube.User.Dao.UserRepository;
import com.example.mytube.User.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(User user) {
        userRepository.save(user);
    }
}
