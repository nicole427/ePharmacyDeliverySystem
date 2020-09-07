package com.digital.epharmacy.service;
/*
* Author: Nicole Hawthorne 217169104
* Data: 02/09/2020
* Desc: Service interface main service that exposes the repository ( includes all the most common methods used)
* */
public interface IService <T , ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
