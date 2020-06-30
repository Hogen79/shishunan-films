package com.shishunan.filmsservice.service.impl;

import com.shishunan.filmsservice.dao.TypesDao;
import com.shishunan.filmsservice.entity.Types;
import com.shishunan.filmsservice.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesDao typesDao;

    @Override
    public boolean insertTypes(Types types) {
        return typesDao.save(types)!=null;
    }

    @Override
    public List<Types> selectTypes() {
        return typesDao.findAll();
    }

    @Override
    public List<Types> selectParentTypes() {
        return typesDao.findBypid(0);
    }
}
