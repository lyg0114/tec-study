package com.study.springdatajpastudy.domain.teamplay.repository;

import com.study.springdatajpastudy.domain.teamplay.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.repository
 * @since : 2023/07/20
 */
public interface CodeRepository extends JpaRepository<Code, String> {

}
