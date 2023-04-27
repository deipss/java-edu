package edu.java.deipss.common.client;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class HttpResult {

    private int httpStatus;

    private boolean success;

    private String data;

}
