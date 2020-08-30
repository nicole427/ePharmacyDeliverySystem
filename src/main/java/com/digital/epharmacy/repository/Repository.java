package com.digital.epharmacy.repository;
/*
* Author: Nicole Hawthorne
* Date: 28/08/2020
* Desc: Repository interface that allows for all the common methods all classes will be used,
*  in order to prevent from typing it all out.
* */
public interface Repository<T , ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
