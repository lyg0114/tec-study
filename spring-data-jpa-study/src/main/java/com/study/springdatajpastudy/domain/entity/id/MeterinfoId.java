package com.study.springdatajpastudy.domain.entity.id;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MeterinfoId implements Serializable {

  @Column(nullable = false, name = "modem_id")
  private String modemId;

  @Column(nullable = false, name = "metering_date")
  private LocalDateTime meteringDate;
}
