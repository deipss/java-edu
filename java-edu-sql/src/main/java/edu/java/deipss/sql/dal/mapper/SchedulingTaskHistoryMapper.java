package edu.java.deipss.sql.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

import edu.java.deipss.sql.dal.entity.SchedulingTaskHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hxl
 * @since 2023-03-17
 */
public interface SchedulingTaskHistoryMapper extends BaseMapper<SchedulingTaskHistory> {

    List<SchedulingTaskHistory> query(@Param("idList") List<Long> idList
            , @Param("taskStatus") String taskStatus,
                                      @Param("ownerIp") String ownerIp,
                                      @Param("endTime") Date endTime,
                                      @Param("startTime") Date startTime);
}
