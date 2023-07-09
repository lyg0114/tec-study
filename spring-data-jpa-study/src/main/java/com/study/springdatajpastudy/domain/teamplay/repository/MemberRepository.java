package com.study.springdatajpastudy.domain.teamplay.repository;

import com.study.springdatajpastudy.domain.teamplay.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.repository
 * @since : 2023/07/09
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

}
