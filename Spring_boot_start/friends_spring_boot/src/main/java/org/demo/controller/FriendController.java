package org.demo.controller;

import org.demo.entity.FriendEntity;
import org.demo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;
    @Autowired
    public FriendController(FriendService friendService){
        this.friendService=friendService;
    }

    @GetMapping("/goodfriend")
    List<FriendEntity> getAllFriend(){
        return friendService.getAllFriends();
    }

    @GetMapping("/{id}")
    FriendEntity getFriendById(@PathVariable Long id){
        return friendService.getFriendById(id);
    }
    @PostMapping("/addfriend")
    FriendEntity addingFriend(@RequestBody FriendEntity friend){
        return friendService.addFriend(friend);
    }
    @DeleteMapping("/delete{id}")
    void deleteFriend(@PathVariable Long id){
        friendService.deletFriend(id);
    }
    @PutMapping("/update{id}")
    FriendEntity updatingFriend(@PathVariable Long id,@RequestBody FriendEntity updateFriend){
        return friendService.updateFriendById(id,updateFriend);
    }


}
