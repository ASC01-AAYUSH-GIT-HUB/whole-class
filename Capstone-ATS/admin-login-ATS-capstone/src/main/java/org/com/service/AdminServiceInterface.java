package org.com.service;

import org.com.dto.RegisterAdminDTO;
import org.com.dto.ResultDTO;
import org.com.entity.AdminEntity;

import java.util.List;

public interface AdminServiceInterface {
    String login(String email, String password);
    void resetFailedAttempts(String email);
    void increaseFailedAttempts(String email);
    boolean unlockWhenTimeExpired(AdminEntity admin);
    List<ResultDTO> getAllAdmin();
    String register(RegisterAdminDTO registerAdminDTO);
}
