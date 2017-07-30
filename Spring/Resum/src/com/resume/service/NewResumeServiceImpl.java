package com.resume.service;

import com.resume.mapper.NewresumMapper;
import com.resume.mapper.UserMapper;
import com.resume.model.Basic;
import com.resume.model.Educational;
import com.resume.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 王宁 on 2017/7/29.
 */
@Service
@Transactional
public class NewResumeServiceImpl implements NewResumeService {
    @Autowired
    public NewresumMapper newresumMapper;
    @Override
    public void insertbasic(Basic basic) {
        newresumMapper.insertbasic(basic);
    }

    @Override
    public void addEducational(Educational educational) {
        newresumMapper.addEducation(educational);
    }

    @Override
    public void addWork(Work work) {
        newresumMapper.addWork(work);
    }

    @Override
    public void addIntroduce(Basic basic) {
        newresumMapper.addIntroduce(basic);
    }

    @Override
    public List<Basic> selectBasic(int userid) {
        return newresumMapper.selectBasic(userid);
    }

    @Override
    public List<Educational> selectEducation(int userid) {
        return newresumMapper.selectEducation(userid);
    }

    @Override
    public List<Work> selectWork(int userid) {
        return newresumMapper.selectWork(userid);
    }
}
