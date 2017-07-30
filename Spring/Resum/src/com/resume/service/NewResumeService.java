package com.resume.service;

import com.resume.model.Basic;
import com.resume.model.Educational;
import com.resume.model.Work;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/26.
 */
public interface NewResumeService {
    public void insertbasic(Basic basic);

    public void addEducational(Educational educational);

    public void addWork(Work work);

    public void addIntroduce(Basic basic);

    public List<Basic> selectBasic(int userid);

    public List<Educational> selectEducation(int userid);

    public List<Work> selectWork(int userid);
}
