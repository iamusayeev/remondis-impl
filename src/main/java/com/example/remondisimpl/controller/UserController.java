package com.example.remondisimpl.controller;

import com.example.remondisimpl.dto.UserDto;
import com.example.remondisimpl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Integer id){
        return userService.findById(id);
    }

}
