package com.shishunan.filmsservice.dao;

import com.shishunan.filmsservice.entity.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TypesDao extends JpaRepository<Types,Integer>, JpaSpecificationExecutor<Types> {
    List<Types> findBypid(Integer pid);
}
