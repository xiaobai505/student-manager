package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.NoticeMapper;
import com.agoni.dgy.model.po.Notice;
import com.agoni.dgy.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_notice(通知公告表)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:37
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




