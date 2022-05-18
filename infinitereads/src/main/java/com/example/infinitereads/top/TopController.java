package com.example.infinitereads.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
@RequestMapping(path = "api/v1/top")
public class TopController {
    private final TopService topService;

    @Autowired
    public TopController(TopService topService) {
        this.topService = topService;
    }
    @GetMapping
    public List<Top> getTops(){return topService.getTops();}

    @GetMapping(path="/userid/{userId}")
    public List<Top> getTopsByUserId(@PathVariable("userId")Long userId){
        return topService.getTopsByUserId(userId);
    }
    @GetMapping(path="/username/{username}")
    public List<Top> getTopsByUserUsername(@PathVariable("username")String username){
        return topService.getTopsByUserAuthorUsername(username);
    }
    @PostMapping
    public void addNewTopEntry(@RequestBody Top top){topService.addNewTop(top);}

    @DeleteMapping(path = "/{tier}/{userId}")
    public void deleteTopEntry(@PathVariable("tier")Integer tier,@PathVariable("userId")Long userId){
        topService.deleteTop(tier,userId);
    }

}
