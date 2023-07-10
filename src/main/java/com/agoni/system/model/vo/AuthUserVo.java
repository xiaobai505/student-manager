package com.agoni.system.model.vo;

import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.User;
import com.diboot.core.binding.annotation.BindFieldList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserVo extends User implements UserDetails {

    @BindFieldList(entity = Role.class, field = "roleCode", condition = "this.id=sys_role_user.user_id AND sys_role_user.role_id=id")
    private List<String> roleCodes;

    @BindFieldList(entity = Role.class, field = "id", condition = "this.id=sys_role_user.user_id AND sys_role_user.role_id=id")
    private List<String> roleIds;
    
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
        //设置权限和角色
        // 1. commaSeparatedStringToAuthorityList放入角色时需要加前缀ROLE_，而在controller使用时不需要加ROLE_前缀
        // 2. 放入的是权限时，不能加ROLE_前缀，hasAuthority与放入的权限名称对应即可
        //AuthUserVo authUserVo = AuthUserVo.create(user, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"+",r,w"));
        return roleCodes.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
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
