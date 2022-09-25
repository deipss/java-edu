package edu.java.deipss.base.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.ArrayLen;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private int pageNum;
    private int pageSize;
}
