package com.shishunan.filmsservice.service.impl;

import com.shishunan.filmsservice.dao.FilmsDao;
import com.shishunan.filmsservice.entity.Films;
import com.shishunan.filmsservice.entity.FilmsQuery;
import com.shishunan.filmsservice.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {
    @Autowired
    private FilmsDao filmsDao;

    @Override
    public boolean insertFilms(Films films) {
        return filmsDao.save(films)!=null;
    }

    @Override
    public Page<Films> getPageInfo(Integer pageNum, Integer pageSize, FilmsQuery filmsQuery) {
        //动态条件查询
        Specification specification=new Specification() {
            //存储查询条件
            List<Predicate> list=new ArrayList<>();
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //动态查询
                if (filmsQuery.getTid()!=0){
                    Predicate predicate=criteriaBuilder.equal(root.get("tid"),filmsQuery.getTid());
                    list.add(predicate);
                }
                //导演模糊查询
                if (filmsQuery.getDirector()!="" && filmsQuery.getDirector()!=null){
                    Predicate predicate=criteriaBuilder.like(root.get("director"),"%".concat(filmsQuery.getDirector()).concat("%"));
                    list.add(predicate);
                }
                //主演模糊查询
                if (filmsQuery.getProtagonist()!="" && filmsQuery.getProtagonist()!=null){
                    Predicate predicate=criteriaBuilder.like(root.get("protagonist"),"%".concat(filmsQuery.getProtagonist()).concat("%"));
                    list.add(predicate);
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        //分页
        Pageable pageable= PageRequest.of(pageNum-1,pageSize, Sort.Direction.DESC,"orders");
        return filmsDao.findAll(specification,pageable);
    }

    @Override
    public boolean stick(Integer id) {
        //根据id查询一个对象
        Films films = filmsDao.getOne(id);
        //置顶
        films.setOrders(films.getOrders()+1);
        return filmsDao.save(films)!=null;
    }
}
