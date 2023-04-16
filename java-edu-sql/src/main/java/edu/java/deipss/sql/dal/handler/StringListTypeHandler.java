package edu.java.deipss.sql.dal.handler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringListTypeHandler extends AbstractListTypeHandler{
    public StringListTypeHandler(Class clazz) {
        super(String.class);
    }
}
