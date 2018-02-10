package org.zhxie.firstappdemo.controller;


import org.zhxie.firstappdemo.domain.User;
import org.zhxie.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {

        User user = new User(name);
        if(userRepository.save(user)) {
            System.out.println(String.format("用户%s对象保存成功", name));
        }
        return user;
    }
}
