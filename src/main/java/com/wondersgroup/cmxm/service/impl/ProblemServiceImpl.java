package com.wondersgroup.cmxm.service.impl;

import com.wondersgroup.cmxm.dataobject.ProblemType;
import com.wondersgroup.cmxm.repository.ProblemRepository;
import com.wondersgroup.cmxm.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/22
 */
@Service
public class ProblemServiceImpl implements ProblemService {


    @Autowired
    private ProblemRepository problemRepository;
    @Override
    public List<ProblemType> selProblem() {
        List<ProblemType> result=problemRepository.selProblem();
        return result;
    }
}
