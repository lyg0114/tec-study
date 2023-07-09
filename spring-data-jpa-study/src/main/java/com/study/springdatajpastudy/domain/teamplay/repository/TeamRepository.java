package com.study.springdatajpastudy.domain.teamplay.repository;

import com.study.springdatajpastudy.domain.teamplay.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.repository
 * @since : 2023/07/09
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

}
