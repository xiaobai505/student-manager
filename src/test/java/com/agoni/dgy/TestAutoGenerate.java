package com.agoni.dgy;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestAutoGenerate {
    static private List<String> tables = new ArrayList<>();
    static private List<IFill> colList =new ArrayList<>();

    static private String url="jdbc:mysql://rm-2ze7hrkqw885t3696mo.mysql.rds.aliyuncs.com/student_status_management";
    static private String user="root";
    static private String pwd="dongGY1234";


    private static void extracted() {
        tables.add("tb_major");
        tables.add("tb_major_user");


        colList.add(new Column("create_time", FieldFill.INSERT));
        colList.add(new Column("create_by", FieldFill.INSERT));
        colList.add(new Column("create_by_name", FieldFill.INSERT));

        colList.add(new Column("update_time", FieldFill.UPDATE));
        colList.add(new Column("update_by", FieldFill.UPDATE));
        colList.add(new Column("update_by_name", FieldFill.UPDATE));
    }

    public static void main(String[] args) {
        extracted();

        FastAutoGenerator.create(url, user, pwd)
            .globalConfig(builder -> {builder
                    .author("dgy")               //作者
                    .outputDir(System.getProperty("user.dir") + "\\src\\main\\java")    //输出路径(写到java目录)
                    .enableSwagger()           //开启swagger
                    .commentDate("yyyy-MM-dd")
                    .fileOverride();            //开启覆盖之前生成的文件
            }).packageConfig(builder -> {builder
                        .parent("com.agoni") //
                        .moduleName("dgy")   // 模块
                        .entity("model")
                        .controller("controller")
                        .service("service")
                        .serviceImpl("service.impl")
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
                        .entityBuilder() //
                        .addTableFills(colList)
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
        new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        }).customFile(Collections.singletonMap("bean.java", "/templates/bean.java.ftl")).build();

    }



}

