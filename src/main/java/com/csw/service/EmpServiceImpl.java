package com.csw.service;

import com.csw.dao.EmpDao;
import com.csw.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp findByCardId(Integer cardId) {
        return empDao.findByCardId(cardId);
    }

    @Override
    public void deleteAccount(Integer cardId) {
        empDao.deleteAccount(cardId);
    }

    @Override
    public void updateBy(Emp emp) {
        empDao.updateBy(emp);
    }

    @Override
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer countPage(Integer pageSize) {
        Integer countPage = 0;
        Integer count = empDao.queryCount();
        if (count % pageSize == 0) {
            countPage = count / pageSize;
        } else {
            countPage = count / pageSize + 1;
        }
        return countPage;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> queryAllAndByPage(Integer currPage, Integer pageSize, Integer countPage) {
        List<Emp> deptList = null;
        Integer firstIndex;
        Integer lastIndex;

        if (currPage != countPage) {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = currPage * pageSize;
        } else {
            firstIndex = (currPage - 1) * pageSize + 1;
            lastIndex = empDao.queryCount();
        }
        return empDao.queryAllAndByPage(firstIndex, lastIndex);
    }
}