package com.agoni.dgy.controller;

import com.agoni.dgy.model.po.History;
import com.agoni.dgy.service.HistoryService;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HistoryControllerTest {

    @Autowired
    private HistoryService historyService;
    @Test
    void page() {
        History history = historyService.getById(86);
        JSONObject json = history.getLogData();
        String user = json.getString("user");
        String pwd = json.getString("pwd");
        json.put("user","root");
        History build = History.builder().logId(history.getLogId()).logData(json).build();

        boolean b = historyService.updateById(build);
        System.out.printf("bbb"+b);
    }
}