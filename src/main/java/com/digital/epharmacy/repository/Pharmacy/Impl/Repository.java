package com.digital.epharmacy.repository.Pharmacy.Impl;

public interface Repository<T , ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
