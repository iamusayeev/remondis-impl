package com.example.remondisimpl.mapper;

import com.example.remondisimpl.dao.entity.UserEntity;
import com.example.remondisimpl.dto.UserDto;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {

@Bean
public Mapper<UserDto, UserEntity> mapDtoToEntity(){
return Mapping.from(UserDto.class)
        .to(UserEntity.class)
        .omitInDestination(UserEntity::getBirthday)
        .omitInDestination(UserEntity::getGender)
        .omitInDestination(UserEntity::getRole)
        .omitInDestination(UserEntity::getId)
        .omitInDestination(UserEntity::getPassword)
        .mapper();
}

public Mapper<UserEntity, UserDto> mapEntityToDto(){
    return Mapping.from(UserEntity.class)
            .to(UserDto.class)
            .mapper();
}


}
