package edu.java.deipss.web.db;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
public class MybatisGenerator {


    /**
     scheduling.mysql.enabled=true
     scheduling.mysql.url=jdbc:mysql://${ip.host}:3306/testdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false
     scheduling.mysql.username=root
     scheduling.mysql.password=deipss
     */
    @Test
    public void generateTest() {
        HashMap<OutputFile, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put(OutputFile.controller, "");
        objectObjectHashMap.put(OutputFile.service, "");
        objectObjectHashMap.put(OutputFile.serviceImpl, "");
        String ip = "192.168.0.1";
        String dbName = "testdb";
        String uname = "root";
        String pwd = "deipss";

        ArrayList<String> strings = Lists.newArrayList(
                "t_activity_preproduct"
        );
        List<String> collect = strings.stream().map(i -> i + "").collect(Collectors.toList());
        FastAutoGenerator.create("jdbc:mysql://" + ip + ":3306/" + dbName, uname, pwd)
                .globalConfig(builder -> {
                    builder.author("hxl") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\workspace\\test\\xsyx-auto-test-payment\\xsyx-auto-test-payment-service-dal\\src\\main\\java\\xsyx\\auto\\test\\payment\\dal\\entity"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("xsyx.auto.test.payment.dal.entity")
                            .pathInfo(objectObjectHashMap); // 设置父包名
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude(collect) // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
                            .addTableSuffix("_0", "_202201")
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                    ;

                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}