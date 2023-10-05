package edu.java.deipss.sql.dal.mapper.scheduling;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.java.deipss.sql.dal.entity.scheduling.SchedulingTask;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hxl
 * @since 2023-03-17
 */
public interface SchedulingTaskMapper extends BaseMapper<SchedulingTask> {
    List<SchedulingTask> listAllByIdIn(@Param("idCollection")Collection<Long> idCollection);



    List<SchedulingTask> getAllWithPage();






}
