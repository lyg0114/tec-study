package com.study.springdatajpastudy.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author : iyeong-gyo
 * @package : com.study.springdatajpastudy.dto
 * @since : 17.10.23
 */
@Builder
@AllArgsConstructor
@Data
public class DataDto {
  List<String> modemIds;
  LocalDate fromDate;
  LocalDate toDate;
}
