package edu.java.deipss.base.annotation;


import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;

/**
 * 框架  = 注解 + 反射 + 设计模式
 * 元注解：
 * @Target,
 * @Retention, RetentionPolicy.SOURCE CLASS RUNTIME
 * @Document
 * ,@Inherited 被其修饰过的类，其子类会具备同样的注解声明
 */


@Season(value = {"Summer"})
public class SeasonPrint {

    @PostConstruct
    public void init(){
        Season annotations = getClass().getAnnotation(Season.class);
    }

    public static void main(String[] args) {
        SeasonPrint seasonPrint = new SeasonPrint();
        for (Annotation annotation : seasonPrint.getClass().getAnnotations()) {
            System.out.println(annotation);
        }

    }
}
