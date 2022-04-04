package com.example.infinitereads.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UsersService userService;

    @Autowired
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody Users user){
        userService.addNewUser(user);
    }

 /*   @PostMapping(path = "/{userId}")
    public void login(@PathVariable("userId") Long userId){
       // userService.addNewUser(user);
    }*/

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping
    public void updateUser(
           @RequestBody Users user
    ){
        userService.updateUser(user.getId(),user.getUsername(),user.getPassword(), user.getEmail());
    }

}
