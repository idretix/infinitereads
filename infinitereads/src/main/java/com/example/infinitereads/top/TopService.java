package com.example.infinitereads.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TopService {

    private final TopRepository topRepository;

    @Autowired
    public TopService(TopRepository topRepository) {
        this.topRepository = topRepository;
    }
    public List<Top> getTops(){return topRepository.findAll();}
    public List<Top> getTopsByUserId(Long userId){return  topRepository.findTopsByUserAuthorId(userId);}
    public List<Top> getTopsByUserAuthorUsername(String username){return  topRepository.findTopsByUserAuthorUsername(username);}
    public void addNewTop(Top top){topRepository.save(top);}
    @Transactional
    public void deleteTop(Integer tier,Long userId) {
        topRepository.deleteByTierAndUserAuthorId(tier,userId);
    }
}
