package com.agoni.security.filter;

import com.agoni.security.constants.SecurityConstants;
import com.agoni.security.utils.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author gyd
 */
public class JWTBasicAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
        // 如果上下文中没有 放进去
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        if (header != null) {
            String userName = JwtTokenUtil.getUserName(header.replace(SecurityConstants.TOKEN_PREFIX, ""));
            if (userName != null) {
                ArrayList<String> list = new ArrayList<>();
                list.add("student");
                if ("root".equals(userName)){
                    list.add("teacher");
                }
                Iterator<String> iterator = list.iterator();
                List<SimpleGrantedAuthority> roles=new ArrayList<SimpleGrantedAuthority>();
                while (iterator.hasNext()){
                    roles.add(new SimpleGrantedAuthority(iterator.next()));
                }
                return new UsernamePasswordAuthenticationToken(userName, null, roles);
            }
        }
        return null;
    }

}
