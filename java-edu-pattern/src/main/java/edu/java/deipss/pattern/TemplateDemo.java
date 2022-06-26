package edu.java.deipss.pattern;

import java.util.List;

/**
 * @author deipss
 * @date 2021-11-12
 */

abstract class AbstractSubQuery {
    protected String tableName;

    protected List<Object> queryConditionList;

    public String buildSubQuerySql() {
        StringBuilder sql = new StringBuilder();
        sql.append(tableName);
        sql.append(buildColumn());
        sql.append(buildWhere());
        return sql.toString();
    }

    protected abstract String buildColumn();

    protected abstract String buildWhere();


}

class TradeSubQuery extends AbstractSubQuery {

    TradeSubQuery(List<Object> list, String name) {
        this.queryConditionList = list;
        this.tableName = name;
    }


    @Override
    protected String buildColumn() {
        return null;
    }

    @Override
    protected String buildWhere() {
        return null;
    }

}



/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
public class TemplateDemo {


}
