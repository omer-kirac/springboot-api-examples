package com.app.omer.service;


import com.app.omer.entity.User;
import com.app.omer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User oldUser = findUser(id);
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        return userRepository.save(oldUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
