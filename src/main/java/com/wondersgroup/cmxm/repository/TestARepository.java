package com.wondersgroup.cmxm.repository;

import com.wondersgroup.cmxm.dataobject.Login;
import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestARepository {


   List<TestA> selAll(Integer loginId);

   List<TestA> selxiangxi(Integer questionId);

   List<TestA> selForXX(Question question);

   List<TestA> exportBfhtreswExcel(Question question);

}
