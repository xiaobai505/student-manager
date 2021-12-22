package com.agoni.dgy;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAutoGenerate {
    static private List<String> tables = new ArrayList<>();

    static private String url="jdbc:mysql://rm-2ze7hrkqw885t3696mo.mysql.rds.aliyuncs.com/student_status_management";
    static private String user="root";
    static private String pwd="dongGY1234";


    public static void main(String[] args) {
        tables.add("tb_class");
        tables.add("tb_class_user");
        tables.add("tb_course");
        tables.add("tb_course_user");
        tables.add("tb_history");
        tables.add("tb_result");
        tables.add("tb_role");
        tables.add("tb_role_user");

        FastAutoGenerator.create(url, user, pwd)
            .globalConfig(builder -> {builder
                    .author("dgy")               //作者
                    .outputDir(System.getProperty("user.dir") + "\\src\\main\\java")    //输出路径(写到java目录)
                    .enableSwagger()           //开启swagger
                    .commentDate("yyyy-MM-dd").fileOverride();            //开启覆盖之前生成的文件
            }).packageConfig(builder -> {builder
                        .parent("com.agoni") //
                        .moduleName("dgy")   // 模块
                        .entity("model")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .mapper("mapper")
                        .xml("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper"));
            }).strategyConfig(builder -> {builder
                        .addInclude(tables) // 表名
                        .addTablePrefix("tb_") // 前缀
                        .serviceBuilder() // service 策略配置
                        .formatServiceFileName("%sService") // serveice 类名，根据表名适配
                        .formatServiceImplFileName("%sServiceImpl") // serveiceimpl 类名，根据表名适配
                        .entityBuilder() // 实体类配置策略
                        .enableLombok() // 开启Lombok
                        .logicDeleteColumnName("del_flag") // 删除逻辑的字段
                        .enableTableFieldAnnotation() // 属性上加注解
                        .controllerBuilder() // controller 策略配置
                        .formatFileName("%sController") // Controller 类名，根据表名适配
                        .enableRestStyle() // RestController
                        .mapperBuilder() // mapper 配置策略
                        .superClass(BaseMapper.class) // 继承 BaseMapper 父类
                        .formatMapperFileName("%sMapper") // Mapper 类名，根据表名适配
                        .enableMapperAnnotation() // @Mapper
                        .formatXmlFileName("%sMapper"); //xml 类名，根据表名适配
            }).templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

//        new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
//                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
//                })
//                .customFile(Collections.singletonMap("mapper.xml", "/templates/mapper.xml.ftl"))
//                .customFile(Collections.singletonMap("bean.java", "/templates/bean.java.ftl"))
//                .customFile(Collections.singletonMap("service.java", "/templates/service.java.ftl"))
//                .customFile(Collections.singletonMap("serviceImpl.java", "/templates/serviceImpl.java.ftl"))
//                .customFile(Collections.singletonMap("mapper.java", "/templates/mapper.java.ftl"))
//                .build();

    }
}

