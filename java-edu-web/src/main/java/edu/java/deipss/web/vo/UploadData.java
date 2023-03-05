package edu.java.deipss.web.vo;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
// 使用EasyExcel时，数据接收类，必须有无参构造函数
@NoArgsConstructor
@Builder
public class UploadData {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("身份证")
    private String idCord;

    @ExcelProperty("生日")
    @DateTimeFormat("yyyyMMdd")
    private Date birth;

    @NumberFormat("#.##")
    @ExcelProperty("工资")
    private Double salary;
}
