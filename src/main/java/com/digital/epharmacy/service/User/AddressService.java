package com.digital.epharmacy.service.User;

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface AddressService extends IService <Address, String> {
    Set<Address> getAll();
}
