package com.study.sampledatastudy.teamplay.repository;

import com.study.sampledatastudy.teamplay.entity.Member;
import com.study.sampledatastudy.teamplay.entity.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.repository
 * @since : 2023/07/09
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

  List<Member> findMembersByTeam(Team team);
}
