package com.study.sampledatastudy.teamplay.serivce;

import com.study.sampledatastudy.teamplay.dto.MemberInfoDto;
import com.study.sampledatastudy.teamplay.dto.TeamInfoDto;
import com.study.sampledatastudy.teamplay.entity.Member;
import com.study.sampledatastudy.teamplay.entity.Team;
import com.study.sampledatastudy.teamplay.repository.MemberRepository;
import com.study.sampledatastudy.teamplay.repository.TeamRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
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
