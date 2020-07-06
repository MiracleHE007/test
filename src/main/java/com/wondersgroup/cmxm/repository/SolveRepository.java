package com.wondersgroup.cmxm.repository;

import com.wondersgroup.cmxm.dataobject.Solve;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SolveRepository {

    List<Solve> selSolve();

}
