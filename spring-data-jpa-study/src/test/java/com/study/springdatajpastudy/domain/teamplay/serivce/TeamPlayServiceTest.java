package com.study.springdatajpastudy.domain.teamplay.serivce;

import com.study.springdatajpastudy.domain.teamplay.dto.MemberInfoDto;
import com.study.springdatajpastudy.domain.teamplay.dto.TeamInfoDto;
import com.study.springdatajpastudy.domain.teamplay.entity.Member;
import com.study.springdatajpastudy.domain.teamplay.entity.Team;
import com.study.springdatajpastudy.domain.teamplay.repository.MemberRepository;
import com.study.springdatajpastudy.domain.teamplay.repository.TeamRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.serivce
 * @since : 2023/07/09
 */
@SpringBootTest
class TeamPlayServiceTest {

  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private TeamRepository teamRepository;
  @Autowired
  private TeamPlayService teamPlayService;
  @Autowired
  private EntityManager em;

  @Test
  @Transactional
  @Rollback(false)
  public void add_new_team_test_1() {
    TeamInfoDto nTeam = new TeamInfoDto();
    nTeam.setTeamName("team-1");
    nTeam.addNewMember(new MemberInfoDto("Kyle", 31));
    nTeam.addNewMember(new MemberInfoDto("Lizzy", 29));
    teamPlayService.addNewTeamV1(nTeam);

    em.flush();
    em.clear();

    List<Team> all = teamRepository.findAll();
    Team team = all.get(0);
    Assert.assertNotNull(team);
    List<Member> members = team.getMembers();
    Assert.assertNotEquals(members.size(), 0);
  }
}