package com.example.mytube.User.Service;

import com.example.mytube.User.Dao.UserRepository;
import com.example.mytube.User.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(User user) {
        userRepository.save(user);
    }

    public User login(User user) {
        Optional<User> opUser = userRepository.findByEmail(user.getEmail());
        if(opUser.isPresent()) {
            User loginedUser = opUser.get();
            if(loginedUser.getPassword().equals(user.getPassword())){
                return loginedUser;
            }
            return null;
        }
        return null;
    }
}
