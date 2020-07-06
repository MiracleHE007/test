package com.wondersgroup.cmxm.service;

import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;

import java.util.List;

public interface QuestionService {

    Integer deleteForId(Integer questionId);

    Integer insertQuestion(Question question);
    Integer updateQuestionId(Integer questionId);

    Integer inserBz(Integer id,String question_bz);
}
