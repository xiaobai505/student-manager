package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.MajorMapper;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.service.MajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <p>
 * 班级表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2022-01-04
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements MajorService {
    @Override
    public List<Major> getSchoolList() {
        List<Major> mjlist = this.list();
        mjlist = mjlist.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Major::getSchool))), ArrayList::new));

        List<String> schoolList = mjlist.stream().map(Major::getSchool).distinct().collect(Collectors.toList());
        return mjlist;
    }
}
