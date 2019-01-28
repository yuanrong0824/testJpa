package com.zhangbin.jpa.jpa;

import com.zhangbin.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * Project: jpa_springboot
 * Author： zhangbin
 * Date： 2018-12-28
 * Time： 11:05
 * Mark:
 * ========================
 */
public interface UserJpa extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity>, Serializable {

}
