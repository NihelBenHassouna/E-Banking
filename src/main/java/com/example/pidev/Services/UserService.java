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

    private List<User> userlist = new ArrayList<>(Arrays.asList(
            new User("med", "hammami", "rue", "med@.com", "etudiant"),
            new User("hjkh", "nndd", "jlkjklj", "bkbkbbkbk", "hhlhkj")));

    public List<User> getalluser() {
        // return userlist;
        List<User> userl = new ArrayList<>();
        userrepository.findAll().forEach(userl::add);
        return userl;
    }

    public User getuser(Long id) {
        //return userlist.stream().filter(U -> U.getId()==(id)).findFirst().get();
        return userrepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid id" + id));
    }

    public void adduser(User user) {
        //userlist.add(user);
        userrepository.save(user);
    }

    public void updateuser(User user, Long id) {
        /*for (int i = 0; i < userlist.size(); i++) {
            User u = userlist.get(i);
            if (u.getId()==id) {
                userlist.set(i, user);
            }
        }*/
        userrepository.save(user);
    }

    public void deleteuser(Long id) {
       // userlist.removeIf(U -> U.getId() == (id));
        userrepository.deleteById(id);
    }
}
