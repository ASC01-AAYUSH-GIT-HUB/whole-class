package org.com.service;

import org.com.entity.AdminEntity;
import org.com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminServiceInterface{
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final long LOCK_TIME_DURATION = 30; // minutes

    @Override
    public String login(String email, String password) {
        AdminEntity admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (admin.isAccountLocked()) {
            if (unlockWhenTimeExpired(admin)) {
                return "Account unlocked. Try again.";
            }
            return "Your account is locked! Try again later.";
        }

        if (admin.getPassword().equals(password)) {
            resetFailedAttempts(email);
            return "Login successful! Welcome " + email;
        } else {
            increaseFailedAttempts(email);
            return "Invalid credentials!";
        }
    }

    @Override
    public void resetFailedAttempts(String email) {
        adminRepository.findByEmail(email).ifPresent(admin -> {
            admin.setFailedAttempts(0);
            admin.setAccountLocked(false);
            admin.setLockTime(null);
            adminRepository.save(admin);
        });
    }

    @Override
    public void increaseFailedAttempts(String email) {
        adminRepository.findByEmail(email).ifPresent(admin -> {
            int newAttempts = admin.getFailedAttempts() + 1;
            admin.setFailedAttempts(newAttempts);

            if (newAttempts >= MAX_FAILED_ATTEMPTS) {
                admin.setAccountLocked(true);
                admin.setLockTime(LocalDateTime.now());
            }
            adminRepository.save(admin);
        });
    }

    @Override
    public boolean unlockWhenTimeExpired(AdminEntity admin) {
        if (admin.getLockTime() == null) return false;

        LocalDateTime unlockTime = admin.getLockTime().plusMinutes(LOCK_TIME_DURATION);
        if (LocalDateTime.now().isAfter(unlockTime)) {
            admin.setAccountLocked(false);
            admin.setFailedAttempts(0);
            admin.setLockTime(null);
            adminRepository.save(admin);
            return true;
        }
        return false;
    }
}
