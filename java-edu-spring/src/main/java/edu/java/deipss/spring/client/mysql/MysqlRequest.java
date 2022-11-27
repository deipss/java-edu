package edu.java.deipss.spring.client.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.java.deipss.spring.client.ClientRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MysqlRequest extends ClientRequest {
    private String driverClassName;
    private String password;
    private String username;
    private String url;
    private String sql;
}
