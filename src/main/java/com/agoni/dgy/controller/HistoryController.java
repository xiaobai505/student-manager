package com.agoni.dgy.controller;


import com.agoni.dgy.model.po.History;
import com.agoni.dgy.service.HistoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@RestController
@RequestMapping("/dgy/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @ApiOperation("list")
    public ResponseEntity<List<History>> list() {
        List<History> list = historyService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
