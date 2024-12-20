package com.example.autoschool.controller;

import com.example.autoschool.model.Role;
import com.example.autoschool.model.User;
import com.example.autoschool.model.UserDto;
import com.example.autoschool.repository.UserRepository;
import com.example.autoschool.service.RoleService;
import com.example.autoschool.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

/**
 * Контроллер для регистрации и авторизации.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Регистрация нового пользователя.
     *
     * @param userDto данные пользователя
     * @return сообщение о результате регистрации
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {
        if (userDto.getRole() == null || userDto.getRole().isEmpty()) {
            return "Ошибка регистрации пользователя: роль не указана";
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleService.findByName(userDto.getRole());
        user.setRoles(Set.of(role));
        userService.saveUser(user);
        return "Пользователь успешно зарегистрировался!";
    }

    /**
     * Вход пользователя.
     *
     * @param user данные пользователя
     * @return JWT токен или сообщение об ошибке
     */
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        UserDetails existingUser = userService.loadUserByUsername(user.getUsername());
        if (existingUser != null) {
            boolean matches = passwordEncoder.matches(user.getPassword(), existingUser.getPassword());
            if (matches) {
                String token = generateToken(user.getUsername());
                return token;
            }
        }
        return "Неверное имя пользователя или пароль!";
    }

    /**
     * Получить роль пользователя.
     *
     * @param username имя пользователя
     * @return роль пользователя
     */
    @GetMapping("/userrole")
    public String getUserRole(@RequestParam String username) {
        User user = userRepository.findByUsername(username);
        if (user != null && !user.getRoles().isEmpty()) {
            String roleName = user.getRoles().iterator().next().getName();
            return roleName;
        }
        return null;
    }


    /**
     * Генерация JWT токена.
     *
     * @param username имя пользователя
     * @return JWT токен
     */
    private String generateToken(String username) {
        String secretKey = "603deb1015ca71be2b73aef0857d77811f352c073b6108d72d9810a30914dff4";
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + 1000 * 60 * 60 * 10;
        Date exp = new Date(expMillis);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(Keys.hmacShaKeyFor(keyBytes), io.jsonwebtoken.SignatureAlgorithm.HS256)
                .compact();
        return token;
    }
}
