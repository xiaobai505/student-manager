package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Menutree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MenutreeVo extends Menutree {
    
    private List<MenutreeVo> children;
}
