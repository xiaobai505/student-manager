package com.agoni.system.controller;

import com.agoni.system.model.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/server")
public class ServerController {
    
    @GetMapping
    public Object getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return server;
    }
    
}
