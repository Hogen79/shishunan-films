package com.shishunan.filmsservice.service;

import com.shishunan.filmsservice.entity.Types;

import java.util.List;

public interface TypesService {
    boolean insertTypes(Types types);

    List<Types> selectTypes();

    List<Types> selectParentTypes();
}
