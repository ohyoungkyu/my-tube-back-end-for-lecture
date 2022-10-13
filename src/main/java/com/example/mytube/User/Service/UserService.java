package com.example.mytube.User.Service;

import com.example.mytube.User.DTO.Userdto;
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

    public Userdto login(User user) throws Exception {
        Optional<User> opUser = userRepository.findByEmail(user.getEmail());
        if(opUser.isPresent()) {
            User loginedUser = opUser.get();
            if(loginedUser.getPassword().equals(user.getPassword())){
                Userdto userdto = new Userdto();
                userdto.setEmail(loginedUser.getEmail());
                userdto.setId(loginedUser.getId());
                userdto.setUsername(loginedUser.getUsername());

                return userdto;
            }
            throw new Exception();
        }
        throw new Exception();
    }
}
