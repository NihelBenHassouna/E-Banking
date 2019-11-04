package com.example.pidev.Controller;


import com.example.pidev.Entities.User;
import com.example.pidev.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping("/hello")
    public String say() {

        List<User> a = new ArrayList<>();
        a=  getalluser();
        a.forEach(System.out::println);
        return "aaa";
    }

    @RequestMapping("/alluser")
    public List<User> getalluser() {
        return userservice.getalluser();

    }

    @RequestMapping("/getuser/{id}")
    public User getuser(@PathVariable Long id) {
        return userservice.getuser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adduser")
    public void adduser(@RequestBody User user) {
        userservice.adduser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateuser/{id}")
    public void updateuser(@RequestBody User user, @PathVariable Long id) {
        userservice.updateuser(user, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser/{id}")
    public void deleteuser(@PathVariable Long id) {
        userservice.deleteuser(id);
    }
}

