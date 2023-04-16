package edu.java.deipss.sql.dal.handler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class MapObjectTypeHandler extends AbstractObjectTypeHandler {
    public MapObjectTypeHandler(Class clazz) {
        super(Map.class);
    }
}
