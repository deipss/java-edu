package edu.java.deipss.sql.dal.mapper.classicmodel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.java.deipss.sql.dal.entity.classicmodel.Customers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomersMapper extends BaseMapper<Customers> {
    int updateBatch(List<Customers> list);

    int batchInsert(@Param("list") List<Customers> list);

    int insertOrUpdate(Customers record);

    int insertOrUpdateSelective(Customers record);

    List<Customers> listAll();




}