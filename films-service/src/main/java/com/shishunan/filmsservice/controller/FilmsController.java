package com.shishunan.filmsservice.controller;

import com.shishunan.filmsservice.entity.Films;
import com.shishunan.filmsservice.entity.FilmsQuery;
import com.shishunan.filmsservice.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films/")
public class FilmsController {
    @Autowired
    private FilmsService filmsService;

    /**
     * 添加影片
     * @param films
     * @return
     */
    @RequestMapping("insertFilms")
    public boolean insertFilms(@RequestBody Films films){
        return filmsService.insertFilms(films);
    }

    /**
     * 列表查询
     * @param pageNum
     * @param pageSize
     * @param filmsQuery
     * @return
     */
    @RequestMapping("getPageInfo")
    public Page<Films> getPageInfo(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                                   @RequestParam(defaultValue = "4",value = "pageSize")Integer pageSize,
                                   FilmsQuery filmsQuery){
        System.err.println("filmsQusery:"+filmsQuery+"---"+"pageNum:"+pageNum+"---"+"pageSize"+pageSize);
        return filmsService.getPageInfo(pageNum,pageSize,filmsQuery);
    }

    /**
     * 置顶方法
     * @param id
     * @return
     */
    @RequestMapping("stick")
    public boolean stick(Integer id){
        return filmsService.stick(id);
    }

}
