package com.shishunan.filmsservice.dao;

import com.shishunan.filmsservice.entity.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FilmsDao extends JpaRepository<Films,Integer>, JpaSpecificationExecutor<Films> {
}
