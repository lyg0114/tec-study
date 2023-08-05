package com.study.springdatajpastudy.domain.teamplay.serivce;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.study.springdatajpastudy.domain.teamplay.dto.MemberInfoDto;
import com.study.springdatajpastudy.domain.teamplay.dto.TeamInfoDto;
import com.study.springdatajpastudy.domain.teamplay.entity.Member;
import com.study.springdatajpastudy.domain.teamplay.entity.Team;
import com.study.springdatajpastudy.domain.teamplay.repository.CodeRepository;
import com.study.springdatajpastudy.domain.teamplay.repository.MemberRepository;
import com.study.springdatajpastudy.domain.teamplay.repository.TeamRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.serivce
 * @since : 2023/07/20
 */
@SpringBootTest
class TeamMemberServiceTest {

  @Autowired private TeamRepository teamRepository;
  @Autowired private CodeRepository codeRepository;
  @Autowired private MemberRepository memberRepository;
  @Autowired private EntityManager em;

  @BeforeEach
  public void before(){
    initData();
    em.flush();
    em.clear();
  }

  private void initData() {
    teamRepository.save(Team.
        builder()
        .name("team-1")
        .build());
  }

  @Test
  @Transactional
  @Rollback(false)
  public void add_new_team_test_1() {
    List<Team> all = teamRepository.findAll();
    Team team = all.get(0);
    assertNotNull(team);
    List<Member> members = team.getMembers();
    assertNotEquals(members.size(), 0);
  }
}