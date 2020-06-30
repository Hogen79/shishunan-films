package com.shishunan.filmsservice.service;

import com.shishunan.filmsservice.entity.Films;
import com.shishunan.filmsservice.entity.FilmsQuery;
import org.springframework.data.domain.Page;

public interface FilmsService {
    boolean insertFilms(Films films);

    Page<Films> getPageInfo(Integer pageNum, Integer pageSize, FilmsQuery filmsQuery);

    boolean stick(Integer id);
}
