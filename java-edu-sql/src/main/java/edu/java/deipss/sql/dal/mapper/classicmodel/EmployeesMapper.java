package edu.java.deipss.sql.dal.mapper.classicmodel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.java.deipss.sql.dal.entity.classicmodel.Employees;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeesMapper extends BaseMapper<Employees> {
    int updateBatch(List<Employees> list);

    int batchInsert(@Param("list") List<Employees> list);

    int insertOrUpdate(Employees record);

    int insertOrUpdateSelective(Employees record);
}