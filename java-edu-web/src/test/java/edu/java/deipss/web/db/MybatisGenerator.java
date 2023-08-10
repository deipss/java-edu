package edu.java.deipss.web.db;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
public class MybatisGenerator {


    /**
     * scheduling.mysql.enabled=true
     * scheduling.mysql.url=jdbc:mysql://${ip.host}:3306/testdb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false
     * scheduling.mysql.username=root
     * scheduling.mysql.password=deipss
     * <p>
     * <a href="https://baomidou.com/pages/981406/#%E5%85%A8%E5%B1%80%E9%85%8D%E7%BD%AE-globalconfig">...</a>
     */
    @Test
    public void generateTest() {
        String ip = "127.0.0.1";
        String dbName = "testdb";
        String uname = "root";
        String pwd = "deipss";
        String pathSave = "C:\\Users\\deips\\desktop";

        ArrayList<String> strings = Lists.newArrayList(
                "scheduling_task", "scheduling_task_history"
        );
        List<String> collect = strings.stream().map(i -> i + "").collect(Collectors.toList());
        // 全局配置
        FastAutoGenerator.create("jdbc:mysql://" + ip + ":3306/" + dbName + "?useSSL=false", uname, pwd)
                .globalConfig(builder -> {
                    builder.author("hxl") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(pathSave); // 指定输出目录，到父包名为止
                })
                .packageConfig(builder -> {
                    builder.parent("edu.java.deipss.sql.dal"); // 设置父包名
                })
                .strategyConfig(builder -> {
                    builder
                            .addInclude(collect) // 设置需要生成的表名
                            .addTablePrefix("t_") // 设置过滤表前缀
                            .addTableSuffix("_0", "_202201")
                            .entityBuilder() // 实体配置
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .serviceBuilder()// 服务配置
                            .formatServiceFileName("%sRepository")
                            .formatServiceImplFileName("%sRepositoryImpl")
                            .mapperBuilder() // mapper xml 配置
                            .enableBaseResultMap()// 设置xml中的结果集
                            .enableBaseColumnList() //设置xml的列映射
                    ;

                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}