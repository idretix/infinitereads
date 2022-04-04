package com.example.infinitereads.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(Users user) {
        Optional<Users> userOptional= userRepository.findUserByEmail(user.getEmail());
       /* if(userOptional.isPresent()){
            throw new IllegalStateException("Email taken!");
        }*/
        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long userId) {
         boolean exists = userRepository.existsById(userId);
         if(!exists){
             throw new IllegalStateException(
                     "User with id" + userId + "does not exist!"
             );
         }
         userRepository.deleteById(userId);
    }

/*    public void loginUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "User with id" + userId + "does not exist!"
            );
        }
        userRepository.deleteById(userId);
    }*/

    @Transactional
    public void updateUser(Long userId, String username, String password, String email) {
        Users users = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + "does not exist!"));

        if(username != null && username.length()>0&&!Objects.equals(users.getUsername(),username)){
            users.setUsername(username);
        }
        if(password != null && password.length()>0&&!Objects.equals(users.getPassword(),password)){
            users.setPassword(password);
        }
        if(email != null && email.length()>0&&!Objects.equals(users.getEmail(),email)){
            Optional<Users> usersOptional = userRepository.findUserByEmail(email);
            if(usersOptional.isPresent()){
                throw new IllegalStateException("Email taken!");
            }
            users.setEmail(email);
        }
    }
}
