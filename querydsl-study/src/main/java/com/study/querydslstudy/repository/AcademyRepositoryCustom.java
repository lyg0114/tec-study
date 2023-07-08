package com.study.querydslstudy.repository;

import com.study.querydslstudy.entity.Academy;
import java.util.List;

/**
 * @author : iyeong-gyo
 * @package : com.study.querydslstudy.repository
 * @since : 2023/07/08
 */
public interface AcademyRepositoryCustom {

  List<Academy> findByName(String name);
}
