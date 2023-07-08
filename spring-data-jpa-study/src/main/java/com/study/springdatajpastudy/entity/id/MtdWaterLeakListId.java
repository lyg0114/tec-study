package com.study.springdatajpastudy.entity.id;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MtdWaterLeakListId implements Serializable {

  @Column(nullable = false, name = "mngId")
  private String mngId;

  @Column(nullable = false, name = "wateruser_type")
  private String wateruserType;

}
