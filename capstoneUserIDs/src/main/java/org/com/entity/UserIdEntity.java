package org.com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class UserIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(unique = true,name = "UserId")
    private String userId;
    private String userName;
    private String userPass;

}
