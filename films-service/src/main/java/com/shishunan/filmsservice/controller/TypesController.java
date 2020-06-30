package com.shishunan.filmsservice.controller;

import com.shishunan.filmsservice.entity.Types;
import com.shishunan.filmsservice.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types/")
public class TypesController {
    @Autowired
    private TypesService typesService;

    /**
     * 添加影视分类
     * @param types
     * @return
     */
    @RequestMapping("insertTypes")
    public boolean insertTypes(@RequestBody Types types){
        return typesService.insertTypes(types);
    }

    /**
     * 查询所有分类
     * @return
     */
    @RequestMapping("selectTypes")
    public List<Types> selectTypes(){
        return typesService.selectTypes();
    }

    /**
     * 查询所有父级分类
     * @return
     */
    @RequestMapping("selectParentTypes")
    public List<Types> selectParentTypes(){
        return typesService.selectParentTypes();
    }
}
