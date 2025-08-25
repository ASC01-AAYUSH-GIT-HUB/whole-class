package org.com.userEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class UserIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,name = "UserId")
    private String userId;
    private String userName;
    private String userPass;
    @PrePersist
    public void generateUserId(){
        if (id !=null){
            userId=String.format("U%03d",id);
        }
    }

    public UserIdEntity() {
    }

    public UserIdEntity(Long id, String userId, String userName, String userPass) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
