package com.study.springdatajpastudy.entity.id;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MtdMeterinfoLeakId implements Serializable {

  @Column(nullable = false, name = "exam_wateruser_idx")
  private Long examWateruserIdx;

  @Column(nullable = false, name = "metering_date")
  private LocalDate meteringDate;

  @Column(nullable = false, name = "modem_id")
  private String modemId;

  @Column(nullable = false, name = "receiving_date")
  private LocalDate receivingDate;

}
