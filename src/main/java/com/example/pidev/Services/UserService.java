package com.example.pidev.Services;

import com.example.pidev.Entities.User;
import com.example.pidev.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRep userrepository;

    public List<User> getalluser() {
        List<User> userl = new ArrayList<>();
        userrepository.findAll().forEach(userl::add);
        return userl;
    }

    public User getuser(Long id) {
        return userrepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id" + id));
    }

    public void adduser(User user) {
        userrepository.save(user);
    }

    public void updateuser(User user, Long id) {
        userrepository.save(user);
    }

    public void deleteuser(Long id) {
        userrepository.deleteById(id);
    }
}
