package com.lzy.repository;

import com.lzy.entity.Type;

import java.util.List;

public interface TypeRepository {
    public List<Type> findAll();
    public Type findById(long id);
}
