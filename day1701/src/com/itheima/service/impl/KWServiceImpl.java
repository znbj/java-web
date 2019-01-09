package com.itheima.service.impl;

import com.itheima.dao.KWDao;
import com.itheima.domain.Usery;
import com.itheima.service.KWService;
import com.itheima.utils.BeanFactory;

import java.util.List;

public class KWServiceImpl implements KWService {

    private KWDao kwDao = BeanFactory.newInstance(KWDao.class);
    @Override
    public List<Usery> findByKW(String content) {
        return kwDao.findKW(content);




    }
}
