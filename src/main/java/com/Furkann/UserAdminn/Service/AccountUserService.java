package com.Furkann.UserAdminn.Service;

import com.Furkann.UserAdminn.DTO.RegisterDto;
import com.Furkann.UserAdminn.Model.entity.AccountEntity;

import java.util.List;

public interface AccountUserService {
    AccountEntity save(RegisterDto registerDto);

    AccountEntity findByEmail(String email);
    List<AccountEntity> findAllUser();
}