package com.Furkann.UserAdminn.Model.repository;

import com.Furkann.UserAdminn.Model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity,Long> {
    AccountEntity findByEmail(String email);
}