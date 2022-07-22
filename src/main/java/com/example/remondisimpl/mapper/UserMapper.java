package com.example.remondisimpl.mapper;

import com.example.remondisimpl.dao.entity.AccountEntity;
import com.example.remondisimpl.dao.entity.UserEntity;
import com.example.remondisimpl.dto.AccountDto;
import com.example.remondisimpl.dto.UserDto;
import com.example.remondisimpl.model.Role;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import lombok.RequiredArgsConstructor;
import model.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserMapper {


    private final Mapper<AccountDto, AccountEntity> mapDtoToEntity;


    @Bean
    public Mapper<UserDto, UserEntity> mapDtoToEntityUser() {
        return Mapping.from(UserDto.class)
                .to(UserEntity.class)
//                .omitInDestination(UserEntity::getBirthday)
                .omitInDestination(UserEntity::getId)
                .omitInSource(UserDto::getSkip)
                .replace(UserDto::getRole, UserEntity::getRole)
                .withSkipWhenNull(Role::valueOf)
                .useMapper(mapDtoToEntity)
                .replace(UserDto::getGender, UserEntity::getGender)
                .withSkipWhenNull(Gender::valueOf)
                .reassign(UserDto::getChange)
                .to(UserEntity::getSmth)
                .mapper();
    }

//    @Bean
//    public Mapper<UserEntity, UserDto> mapEntityToDto() {
//        return Mapping.from(UserEntity.class)
//                .to(UserDto.class)
//                .mapper();
//    }


}
