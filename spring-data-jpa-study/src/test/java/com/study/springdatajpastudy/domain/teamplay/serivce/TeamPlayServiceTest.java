package com.study.springdatajpastudy.domain.teamplay.serivce;

import com.study.springdatajpastudy.domain.teamplay.dto.MemberInfoDto;
import com.study.springdatajpastudy.domain.teamplay.dto.TeamInfoDto;
import com.study.springdatajpastudy.domain.teamplay.entity.Member;
import com.study.springdatajpastudy.domain.teamplay.entity.Team;
import com.study.springdatajpastudy.domain.teamplay.repository.MemberRepository;
import com.study.springdatajpastudy.domain.teamplay.repository.TeamRepository;
import java.util.List;
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

  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private TeamRepository teamRepository;
  @Autowired
  private TeamPlayService teamPlayService;

  @Test
  @Transactional
  @Rollback(false)
  public void add_new_team_test_1() {
    TeamInfoDto nTeam = new TeamInfoDto();
    nTeam.setTeamName("team-1");
    nTeam.addNewMember(new MemberInfoDto("Kyle", 31));
    nTeam.addNewMember(new MemberInfoDto("Lizzy", 29));
    teamPlayService.addNewTeamV1(nTeam);

    List<Team> all = teamRepository.findAll();
    Team team = all.get(0);
    System.out.println("team.getId() = " + team.getId());
    System.out.println("team.getName() = " + team.getName());

    List<Member> members = team.getMembers();
    for (Member member : members) {
      System.out.println("member.getId() = " + member.getId());
      System.out.println("member.getName() = " + member.getName());
      System.out.println("member.getAge() = " + member.getAge());
      System.out.println("member.getTeam().getId() = " + member.getTeam().getId());
      System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
    }
  }

  @Test
  @Transactional
  @Rollback(false)
  public void add_new_team_test_2() {
    TeamInfoDto nTeam = new TeamInfoDto();
    nTeam.setTeamName("team-1");
    nTeam.addNewMember(new MemberInfoDto("Kyle", 31));
    nTeam.addNewMember(new MemberInfoDto("Lizzy", 29));
    teamPlayService.addNewTeamV1(nTeam);

    List<Team> all = teamRepository.findAll();
    Team team = all.get(0);
    System.out.println("team.getId() = " + team.getId());
    System.out.println("team.getName() = " + team.getName());

    List<Member> members = memberRepository.findMembersByTeam(team);
    for (Member member : members) {
      System.out.println("member.getId() = " + member.getId());
      System.out.println("member.getName() = " + member.getName());
      System.out.println("member.getAge() = " + member.getAge());
      System.out.println("member.getTeam().getId() = " + member.getTeam().getId());
      System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
    }
  }
}