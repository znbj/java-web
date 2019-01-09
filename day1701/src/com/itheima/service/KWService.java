package com.itheima.service;

import com.itheima.domain.Usery;

import java.util.List;

public interface KWService {
    List<Usery> findByKW(String content);
}
