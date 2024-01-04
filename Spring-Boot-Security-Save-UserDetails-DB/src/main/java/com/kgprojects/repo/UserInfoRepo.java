package com.kgprojects.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgprojects.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, String>
{
}