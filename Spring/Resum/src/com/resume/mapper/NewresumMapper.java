package com.resume.mapper;

import com.resume.model.Basic;
import com.resume.model.Educational;
import com.resume.model.Work;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/29.
 */
@MapperScan
public interface NewresumMapper {
    public void insertbasic(Basic basic);

    public void addEducation(Educational educational);

    public void addWork(Work work);

    public void addIntroduce(Basic basic);

    public List<Basic> selectBasic(int userid);

    public List<Educational> selectEducation(int userid);

    public List<Work> selectWork(int userid);
}
