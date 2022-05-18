package com.example.infinitereads.toread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
@RequestMapping(path = "api/v1/toread")
public class ToReadController {
    private final ToReadService toReadService;

    @Autowired
    public ToReadController(ToReadService toReadService) {
        this.toReadService = toReadService;
    }
    @GetMapping
    public List<ToRead> getToReads(){return toReadService.getToReads();}

    @GetMapping(path="/userid/{userId}")
    public List<ToRead> getToReadsByUserId(@PathVariable("userId")Long userId){
        return toReadService.getToReadsByUserId(userId);
    }
    @GetMapping(path="/username/{username}")
    public List<ToRead> getToReadsByUserUsername(@PathVariable("username")String username){
        return toReadService.getToReadsByUserUsername(username);
    }
    @PostMapping
    public void addNewToReadEntry(@RequestBody ToRead toRead){toReadService.addNewToRead(toRead);}
    @DeleteMapping(path = "/{id}/{title}")
    public void deleteToReadEntry(@PathVariable("id") Long id,@PathVariable("title") String title) {
        toReadService.deleteToRead(id,title);
    }
}
