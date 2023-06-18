package com.Furkann.UserAdminn.Model.repository;

import com.Furkann.UserAdminn.Model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
    Roles findByRolesName(String name);
}