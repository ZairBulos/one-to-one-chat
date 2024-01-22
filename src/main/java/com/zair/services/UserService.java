package com.zair.services;

import com.zair.entities.User;
import com.zair.enums.UserStatus;
import com.zair.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllConnected() {
        return userRepository.findAllByStatus(UserStatus.ONLINE);
    }

    public void save(User user) {
        user.setStatus(UserStatus.ONLINE);
        userRepository.save(user);
    }

    public void disconnect(User user) {
        User userDB = userRepository.findById(user.getNickName()).orElse(null);

        if (userDB != null) {
            userDB.setStatus(UserStatus.OFFLINE);
            userRepository.save(user);
        }
    }
}
