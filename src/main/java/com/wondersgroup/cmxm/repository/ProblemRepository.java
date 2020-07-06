package com.wondersgroup.cmxm.repository;

import com.wondersgroup.cmxm.dataobject.ProblemType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/22
 */
@Mapper
@Repository
public interface ProblemRepository {

    List<ProblemType> selProblem();


}
