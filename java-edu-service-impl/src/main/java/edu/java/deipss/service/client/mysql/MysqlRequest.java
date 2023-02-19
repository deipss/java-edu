package edu.java.deipss.service.client.mysql;

import edu.java.deipss.service.client.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
