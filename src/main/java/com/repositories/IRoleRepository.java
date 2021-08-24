package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{

}
