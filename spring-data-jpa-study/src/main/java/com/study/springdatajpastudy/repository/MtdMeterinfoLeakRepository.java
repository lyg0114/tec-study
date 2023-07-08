package com.study.springdatajpastudy.repository;

import com.study.springdatajpastudy.entity.MtdMeterinfoLeak;
import com.study.springdatajpastudy.entity.MtdWaterLeakExamWateruser;
import com.study.springdatajpastudy.entity.id.MtdMeterinfoLeakId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.repository
 * @since : 2023/07/08
 */
public interface MtdMeterinfoLeakRepository extends
    JpaRepository<MtdMeterinfoLeak, MtdMeterinfoLeakId> {

}
