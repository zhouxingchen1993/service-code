package com.htsat.cart.serviceimpl;

import com.htsat.cart.dao.master.REcUserinfoMapper;
import com.htsat.cart.dao.slave.REcUserinfoReadMapper;
import com.htsat.cart.model.REcUserinfo;
import com.htsat.cart.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    REcUserinfoReadMapper userinfoReadMapper;

    @Override
    public boolean checkUserAvailable(Long userId) {
        /**
         *
         */
        REcUserinfo user =  userinfoReadMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return true;
        }
        return false;
    }
}
