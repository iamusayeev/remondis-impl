package com.example.remondisimpl.mapper;

import com.example.remondisimpl.dao.entity.AccountEntity;
import com.example.remondisimpl.dao.entity.UserEntity;
import com.example.remondisimpl.dto.AccountDto;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AccountMapper {


    @Bean
    public Mapper<AccountDto, AccountEntity> mapDtoToEntity(){
        return Mapping.from(AccountDto.class)
                .to(AccountEntity.class)
                .omitInDestination(AccountEntity::getId)
                .mapper();
    }

}
