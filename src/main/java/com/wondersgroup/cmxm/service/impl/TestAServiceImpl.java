package com.wondersgroup.cmxm.service.impl;

import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;
import com.wondersgroup.cmxm.repository.TestARepository;
import com.wondersgroup.cmxm.service.TestAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/20
 */
@Service
public class TestAServiceImpl implements TestAService {

    @Autowired
    private TestARepository testARepository;


    @Override
    public List<TestA> selAll(Integer loginId) {
        List<TestA> result=testARepository.selAll(loginId);
        return result;
    }

    @Override
    public List<TestA> selxiangxi(Integer questionId) {
        List<TestA> result=testARepository.selxiangxi(questionId);
        return result;
    }

    @Override
    public List<TestA> selForXX(Question question) {
        List<TestA> result=testARepository.selForXX(question);
        return result;
    }

    @Override
    public List<TestA> exportBfhtreswExcel(Question question) {
        return testARepository.exportBfhtreswExcel(question);
    }


}
