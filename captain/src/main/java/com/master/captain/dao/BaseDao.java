package com.master.captain.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    List<T> load();
    Serializable save(T t);
    void delete(T t);
    void update(T t);

}