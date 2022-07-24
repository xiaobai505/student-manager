package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.Dict;
import com.agoni.dgy.service.DictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DictControllerTest {
    
    @Autowired
    private DictService dictService;
    
    @Test
    void list() {
    }
    
    @Test
    void save() {
        Dict build = Dict.builder().id(55l).name("1").parentId(0).model("1").remark("22").createBy("aa")
                         .createByName("aa").createTime(LocalDateTime.now()).build();
        boolean save = dictService.save(build);
        System.out.printf("save");
    
    }
    
    @Test
    void update() {
    }
    
    @Test
    void del() {
    }
}