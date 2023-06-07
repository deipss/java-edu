package edu.java.deipss.common.spring;
import com.google.common.collect.Lists;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Outer{
    private String name;
    private List<Inner> innerList;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Inner{
    private String description;
    private List<Date> dateList;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class OuterVO{
    private String name;
    private List<InnerVO> innerList;
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class InnerVO{
    private String description;
    private List<Date> dateList;
}
public class BeanTest {
    public static void main(String[] args) {
        InnerVO innerVO = new InnerVO();
        innerVO.setDescription("2");
        innerVO.setDateList(Lists.newArrayList(new Date(),new Date()));

        InnerVO innerVO2 = new InnerVO();
        innerVO2.setDescription("3");
        innerVO2.setDateList(Lists.newArrayList(new Date(),new Date()));

        OuterVO outerVO = new OuterVO();
        outerVO.setName("outerVO");
        outerVO.setInnerList(Lists.newArrayList(innerVO,innerVO2));
        Outer outer = new Outer();
        BeanUtils.copyProperties(outerVO,outer);

        System.out.println(outer);
        System.out.println("---------");
        System.out.println(outerVO);





    }
}
