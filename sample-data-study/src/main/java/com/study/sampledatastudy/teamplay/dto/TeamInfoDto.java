package com.study.sampledatastudy.teamplay.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.domain.teamplay
 * @since : 2023/07/09
 */
@Data
public class TeamInfoDto {

  private String teamName;
  List<MemberInfoDto> members = new ArrayList<>();

  public void addNewMember(MemberInfoDto memberInfoDto) {
    this.members.add(memberInfoDto);
  }
}
