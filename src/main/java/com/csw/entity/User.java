package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/10/24.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String name;//varchar2(20) primary key not null,
    private String password;//varchar2(10),
    private String truename;//varchar(30),
    private String sex;// varchar2(10)

}
