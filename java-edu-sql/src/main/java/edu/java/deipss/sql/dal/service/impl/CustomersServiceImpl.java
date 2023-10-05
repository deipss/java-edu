package edu.java.deipss.sql.dal.service.impl;

import edu.java.deipss.sql.dal.entity.classicmodel.Customers;
import edu.java.deipss.sql.dal.mapper.classicmodel.CustomersMapper;
import edu.java.deipss.sql.dal.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomersServiceImpl implements CustomersService{

    @Autowired
    private CustomersMapper customersMapper;


    @Override
    public int insert(Customers record) {
        return customersMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Customers record) {
        return customersMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Customers record) {
        return customersMapper.insertOrUpdateSelective(record);
    }


    @Override
    public int updateBatch(List<Customers> list) {
        return customersMapper.updateBatch(list);
    }


    @Override
    public int batchInsert(List<Customers> list) {
        return customersMapper.batchInsert(list);
    }

}
