package edu.java.deipss.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryRequest {


    @Size(max = 8,message = "长度不对")
    private String name;

    private String phone;

    private String password;

    private Integer age;
}
