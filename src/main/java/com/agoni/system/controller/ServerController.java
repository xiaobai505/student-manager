package com.agoni.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyd
 */
@RestController
@RequestMapping("/sys/server")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ServerController {
    
    @GetMapping
    //@PreAuthorize("hasAuthority('admin')")
    public Object getInfo() {
        return null;
    }
    
}
