package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Admin
 */
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserVo extends User implements UserDetails {

    /**
     * 用户权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;


    public static AuthUserVo create(User user ,Collection<? extends GrantedAuthority> roles) {
        AuthUserVo authUserVo = AuthUserVo.builder().authorities(roles).build();
        BeanUtils.copyProperties(user,authUserVo);
        return authUserVo;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
