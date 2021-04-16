package com.csw.service;

import com.csw.entity.Emp;

import java.util.List;

public interface EmpService {


    Emp findByCardId(Integer cardId);

    void deleteAccount(Integer cardId);

    void updateBy(Emp emp);

    void addEmp(Emp emp);

    Integer countPage(Integer pageSize);

    List<Emp> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage);
}
