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

    @Override
    public FriendEntity getFriendById(Long id) {
        System.err.println("Getting particular friend");
        return friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found with id " + id));
    }


    @Override
    public FriendEntity addFriend(FriendEntity friend) {
        System.err.println("friend is going to added");
        return this.friendRepository.save(friend);
    }

    @Override
    public void deletFriend(Long id) {
        System.err.println("Friend with id: "+id+" is removed from friend list");
        this.friendRepository.deleteById(id);
    }

    @Override
    public FriendEntity updateFriendById(Long id,FriendEntity existingFriend) {
        System.err.println("friend with id: "+id+" is going to get updated");
        FriendEntity friendEntity= friendRepository.findById(id).get();
        friendEntity.setFirstName(existingFriend.getFirstName());
        friendEntity.setLastName(existingFriend.getLastName());
        friendEntity.setAge(existingFriend.getAge());
        friendEntity.setEmail(existingFriend.getEmail());
        return friendRepository.save(friendEntity);
    }
}
