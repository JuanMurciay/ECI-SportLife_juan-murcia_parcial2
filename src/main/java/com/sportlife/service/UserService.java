package com.sportlife.service;

import com.sportlife.dto.UserRegisterRequest;
import com.sportlife.dto.UserResponse;
import com.sportlife.exception.BusinessException;
import com.sportlife.model.User;
import com.sportlife.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(UserRegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BusinessException("El correo ya se encuentra registrado");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                "Usuario registrado exitosamente"
        );
    }
}