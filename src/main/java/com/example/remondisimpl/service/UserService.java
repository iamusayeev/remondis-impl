package com.example.remondisimpl.service;

import com.example.remondisimpl.dao.entity.UserEntity;
import com.example.remondisimpl.dao.repository.UserRepository;
import com.example.remondisimpl.dto.UserDto;
//import com.example.remondisimpl.mapper.UserMapper;
import com.remondis.remap.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Mapper<UserDto,UserEntity> mapDtoToEntity;


    public void save(UserDto userDto) {
        UserEntity userEntity = mapDtoToEntity.map(userDto);
        userRepository.save(userEntity);
    }


//    public UserDto findById(Integer id) {
//        UserEntity userEntity = fetchUserIfExist(id);
//
//
//        return userDto;
//    }

    private UserEntity fetchUserIfExist(Integer id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

}
