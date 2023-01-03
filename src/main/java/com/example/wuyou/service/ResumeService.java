package com.example.wuyou.service;

import com.example.wuyou.model.entity.Resume;

/**
 * 个人简历信息;(person_resume)表服务接口
 * @author : One Direction
 * @date : 2022-12-13
 */
public interface ResumeService{

    Resume getResumeInfo(String token);

    Boolean updateResume(Resume params);
}
