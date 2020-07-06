package com.wondersgroup.cmxm.service.impl;

import com.wondersgroup.cmxm.dataobject.Solve;
import com.wondersgroup.cmxm.repository.SolveRepository;
import com.wondersgroup.cmxm.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/22
 */
@Service
public class SolveServiceImpl implements SolveService {


    @Autowired
    private SolveRepository solveRepository;


    @Override
    public List<Solve> selSolve() {
        List<Solve> result=solveRepository.selSolve();
        return result;
    }
}
