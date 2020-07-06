package com.wondersgroup.cmxm.service.impl;

import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.repository.QuestionRepository;
import com.wondersgroup.cmxm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/21
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Integer deleteForId(Integer questionId) {
            Integer result=questionRepository.deleteForId(questionId);
        return result;
    }

    @Override
    public Integer insertQuestion(Question question) {
        Integer result=questionRepository.insertQuestion(question);
        return result;
    }

    @Override
    public Integer updateQuestionId(Integer questionId) {
        Integer result=questionRepository.updateQuestionId(questionId);
        return result;
    }

    @Override
    public Integer inserBz(Integer id, String question_bz) {
        Integer result=questionRepository.inserBz(id,question_bz);
        return result;
    }

}
