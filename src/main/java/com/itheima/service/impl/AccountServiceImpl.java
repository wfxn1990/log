package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  {

    @Autowired
    AccountDao accountDao;

    public void save(){
        accountDao.save();
    }


    public void update() {
        System.out.println(1/0);
        System.out.println("更新操作");
    }
}
