package edu.java.deipss.spring.client.curator;

import edu.java.deipss.spring.client.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuratorRequest extends ClientRequest {

    private String path;

    private String namespaceAddress;
}
