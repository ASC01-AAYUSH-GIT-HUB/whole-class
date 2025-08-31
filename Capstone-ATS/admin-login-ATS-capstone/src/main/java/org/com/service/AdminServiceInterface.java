package org.com.service;

import org.com.entity.AdminEntity;

public interface AdminServiceInterface {
    String login(String email, String password);
    void resetFailedAttempts(String email);
    void increaseFailedAttempts(String email);
    boolean unlockWhenTimeExpired(AdminEntity admin);
}
