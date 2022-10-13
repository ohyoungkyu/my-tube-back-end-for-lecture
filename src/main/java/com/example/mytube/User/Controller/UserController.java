package com.example.mytube.User.Controller;

import com.example.mytube.User.Entity.User;
import com.example.mytube.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody User user) {

        System.out.println("email: " + user.getEmail());

        userService.join(user);

        return "user";
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User loginedUser = userService.login(user);
        return loginedUser;
    }

}

