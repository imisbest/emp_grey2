package com.csw.dao;

import com.csw.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {

    Emp findByCardId(@Param("cardId") Integer cardId);

    void deleteAccount(@Param("cardId") Integer cardId);

    void updateBy(@Param("emp") Emp emp);

    Integer addEmp(@Param("emp") Emp emp);


    Integer queryCount();

    List<Emp> queryAllAndByPage(@Param("firstIndex") Integer firstIndex, @Param("lastIndex") Integer lastIndex);
}
