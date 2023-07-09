package com.study.springdatajpastudy.domain.leak.repository;

import com.study.springdatajpastudy.domain.leak.entity.MtdMeterinfoLeak;
import com.study.springdatajpastudy.domain.leak.entity.id.MtdMeterinfoLeakId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.leak.repository
 * @since : 2023/07/08
 */
public interface MtdMeterinfoLeakRepository extends
    JpaRepository<MtdMeterinfoLeak, MtdMeterinfoLeakId> {

}
