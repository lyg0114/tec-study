package com.study.springdatajpastudy.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "mtd_water_leak_exam_group")
@NoArgsConstructor
@AllArgsConstructor
public class MtdWaterLeakExamGroup implements Serializable {
    @Id
    @Column(name = "exam_group_idx")
    private Long examGroupIdx;

    @Column(name = "area_id")
    private String area_id;

    @Column(name = "created_date")
    private LocalDate created_date;

    @Column(name = "created_dept")
    private String created_dept;

    @Column(name = "created_user")
    private String created_user;

    @Column(name = "exam_estimated_date")
    private LocalDate examEstimatedDate;

    @Column(name = "exam_finished_dt")
    private LocalDate examFinishedDt;

    @Column(name = "exam_nm")
    private String examNm;

    @Column(name = "exam_plan_start_dt")
    private LocalDate examPlanStartDt;

    @Column(name = "exam_started_dt")
    private LocalDate examStartedDt;

    @Column(name = "exam_status")
    private String examStatus;

    @Column(name = "group_sid")
    private Long groupSid;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;

    @Column(name = "last_modified_dept")
    private String lastModifiedDept;

    @Column(name = "last_modified_user")
    private String lastModifiedUser;

    @Column(name = "target_cnt")
    private Integer targetCnt;

    private String city;


}
