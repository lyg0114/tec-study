package com.study.sampledatastudy.teamplay.serivce;

import com.study.sampledatastudy.teamplay.entity.Member;
import com.study.sampledatastudy.teamplay.entity.Team;
import com.study.sampledatastudy.teamplay.repository.MemberRepository;
import com.study.sampledatastudy.teamplay.repository.TeamRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : iyeong-gyo
 * @package : com.study.sampledatastudy.teamplay.serivce
 * @since : 2023/07/10
 */
@SpringBootTest
class UploadSampleDataTest {

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
  public void upload_sample_sql_data_test() {
    List<Team> all = teamRepository.findAll();
    Team team = all.get(0);
    List<Member> members = team.getMembers();
    for (Member member : members) {
      System.out.println("member.getId() = " + member.getId());
      System.out.println("member.getName() = " + member.getName());
    }
  }
}