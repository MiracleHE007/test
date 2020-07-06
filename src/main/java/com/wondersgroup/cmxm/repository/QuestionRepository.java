package com.wondersgroup.cmxm.repository;

import com.wondersgroup.cmxm.dataobject.Question;
import com.wondersgroup.cmxm.dataobject.TestA;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by Miracle_he
 * @Date 2020/4/21
 */
@Mapper
@Repository
public interface QuestionRepository {
    Integer deleteForId(Integer questionId);

    Integer insertQuestion(Question question);

    Integer updateQuestionId(Integer questionId);

    Integer inserBz(Integer id,String question_bz);

}
