package com.study.springdatajpastudy.domain.teamplay.serivce;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.study.springdatajpastudy.domain.teamplay.dto.MemberInfoDto;
import com.study.springdatajpastudy.domain.teamplay.dto.TeamInfoDto;
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
 * @since : 2023/07/09
 */
@SpringBootTest
class TeamPlayServiceTest {

  @Autowired private TeamRepository teamRepository;
  @Autowired private TeamPlayService teamPlayService;
  @Autowired private EntityManager em;

  @BeforeEach
  public void before(){
    initData();
    em.flush();
    em.clear();
  }

  private void initData() {
    TeamInfoDto nTeam = new TeamInfoDto();
    nTeam.setTeamName("team-1");
    nTeam.addNewMember(new MemberInfoDto("Kyle", 31));
    nTeam.addNewMember(new MemberInfoDto("Lizzy", 29));
    teamPlayService.addNewTeamV1(nTeam);
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