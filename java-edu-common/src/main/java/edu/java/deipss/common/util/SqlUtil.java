package edu.java.deipss.common.util;

import com.alibaba.fastjson2.JSONObject;
import edu.java.deipss.service.test.exception.AppInnerException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlUtil {
    public  static  String INSERT_SQL  = "insert into #table#  (#columns#) values (#values#) ";

    public static Pair<String, List<Object>> insert(String  tableName, JSONObject obj) throws AppInnerException {
        String sql = INSERT_SQL.replace("#table#",tableName);
        List<String> columns =new ArrayList<>();
        List<String> placeholders =new ArrayList<>();
        List<Object> values =new ArrayList<>();
        for (Map.Entry<String, Object> entry : obj.entrySet()) {
            columns.add("`"+entry.getKey()+"`");
            placeholders.add("?");
            values.add(entry.getValue());
        }
        String join = StringUtils.join(columns, ",");
        sql = sql.replace("#columns#",join);

        join = StringUtils.join(placeholders, ",");
        sql = sql.replace("#values#",join);
        return new MutablePair<>(sql,values);
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("orderID","XS2222323232");
        jsonObject.put("userName","Test_001");

        Pair<String, List<Object>> tUserOrder = insert("t_user_order", jsonObject);
        System.out.println(tUserOrder.getKey());
        // insert into t_user_order  (`orderID`,`userName`) values (?,?)
    }
}
