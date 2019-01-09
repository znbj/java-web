package com.itheima.dao;

import com.itheima.domain.Usery;

import java.util.List;

public interface KWDao {
    List<Usery> findKW(String content);
}
