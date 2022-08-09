package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MenuTreeVo extends Menu {
    
    private List<MenuTreeVo> children;
}
