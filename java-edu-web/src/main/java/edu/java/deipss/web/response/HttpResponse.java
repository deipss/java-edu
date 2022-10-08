package edu.java.deipss.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  HttpResponse <T>{
    private T data;
    private String code;
    private String msg;

    public static<T> HttpResponse<T> suucess(T data){
        return new HttpResponse<T>(data,"success","响应成功");
    }

    public static<T> HttpResponse<T> failed(T data){
        return new HttpResponse<T>(data,"failed","响应失败");
    }
}
