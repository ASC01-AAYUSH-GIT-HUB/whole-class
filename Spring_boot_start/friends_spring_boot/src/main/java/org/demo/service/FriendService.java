package org.demo.service;

import org.demo.entity.FriendEntity;

import java.util.List;

public interface FriendService {
    List<FriendEntity> getAllFriends();
    FriendEntity getFriendById(Long id);
    FriendEntity addFriend(FriendEntity friend);
    void deletFriend(Long id);
    FriendEntity updateFriendById(Long id,FriendEntity existingFriend);
}
