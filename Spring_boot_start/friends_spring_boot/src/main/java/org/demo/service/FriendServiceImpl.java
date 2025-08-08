package org.demo.service;

import org.demo.entity.FriendEntity;
import org.demo.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;
    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository){
        this.friendRepository=friendRepository;
    }
    @Override
    public List<FriendEntity> getAllFriends() {
        System.err.println("Database value is returned");
        return this.friendRepository.findAll();
    }
}
