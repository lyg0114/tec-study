package com.study.springdatajpastudy.domain.teamplay.serivce;

import com.study.springdatajpastudy.domain.teamplay.dto.MemberInfoDto;
import com.study.springdatajpastudy.domain.teamplay.dto.TeamInfoDto;
import com.study.springdatajpastudy.domain.teamplay.entity.Member;
import com.study.springdatajpastudy.domain.teamplay.entity.Team;
import com.study.springdatajpastudy.domain.teamplay.repository.MemberRepository;
import com.study.springdatajpastudy.domain.teamplay.repository.TeamRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay.serivce
 * @since : 2023/07/09
 */
@Service
@RequiredArgsConstructor
public class TeamPlayService {

  private final MemberRepository memberRepository;
  private final TeamRepository teamRepository;

  public void addNewTeamV1(TeamInfoDto teamInfoDto) {
    Team team = new Team();
    team.setName(teamInfoDto.getTeamName());
    Team savedTeam = teamRepository.save(team);

    List<MemberInfoDto> members = teamInfoDto.getMembers();
    for (MemberInfoDto member : members) {
      Member newMember = member.converToEntity();
      newMember.setTeam(savedTeam);
      memberRepository.save(newMember);
    }
  }
}
