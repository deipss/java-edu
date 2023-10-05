package edu.java.deipss.sql.dal.service;

import edu.java.deipss.sql.dal.entity.classicmodel.Customers;
import java.util.List;
public interface CustomersService{



    int insert(Customers record);

    int insertOrUpdate(Customers record);

    int insertOrUpdateSelective(Customers record);

    int updateBatch(List<Customers> list);


    int batchInsert(List<Customers> list);

}
