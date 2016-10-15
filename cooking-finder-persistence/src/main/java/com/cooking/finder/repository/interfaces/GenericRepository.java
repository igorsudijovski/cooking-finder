package com.cooking.finder.repository.interfaces;

import java.util.List;

/**
 * Created by Igor on 15.10.2016.
 */
public interface GenericRepository<T> {

    public Long insert(T model);

    public List<T> findAll();

    public T findOne(Long id);

    public boolean update(T model);
}
