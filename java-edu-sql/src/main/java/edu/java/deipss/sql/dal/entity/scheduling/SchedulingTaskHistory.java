package edu.java.deipss.sql.dal.entity.scheduling;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author hxl
 * @since 2023-03-17
 */
@Getter
@Setter
@ToString
@TableName("scheduling_task_history")
public class SchedulingTaskHistory implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId("id")
    private Long id;

    @TableField("lock_name")
    private String lockName;

    @TableField("task_status")
    private String taskStatus;

    @TableField("start_time")
    private LocalTime startTime;

    @TableField("end_time")
    private LocalTime endTime;

    @TableField("next_start")
    private Date nextStart;

    @TableField("try_lock_cnt")
    private Integer tryLockCnt;

    @TableField("time_gap")
    private String timeGap;

    @TableField("owner_ip")
    private String ownerIp;

    @TableField("tm_create")
    private Date tmCreate;

    @TableField("tm_modify")
    private Date tmModify;
}
