package com.example.infinitereads.toread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ToReadService {
    private final ToReadRepository toReadRepository;

    @Autowired
    public ToReadService(ToReadRepository toReadRepository) {
        this.toReadRepository = toReadRepository;
    }
   public List<ToRead> getToReads(){return toReadRepository.findAll();}
    public List<ToRead> getToReadsByUserId(Long userId) {
        return toReadRepository.findToReadsByUserId(userId);
    }
    public List<ToRead> getToReadsByUserUsername(String username) {
        return toReadRepository.findToReadsByUserUsername(username);
    }
    public void addNewToRead(ToRead toRead){
        toReadRepository.save(toRead);
    }
    @Transactional
    public void deleteToRead(Long id,String title){

        toReadRepository.deleteByUserIdAndBookTitle(id,title);
    }
}
