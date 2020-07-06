package com.wondersgroup.cmxm.service;

import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/20
 */
public interface TestAService {
    List<TestA> selAll(Integer loginId);

    List<TestA> selxiangxi(Integer questionId);

    List<TestA> selForXX(Question question);

    List<TestA> exportBfhtreswExcel(Question question);


}
