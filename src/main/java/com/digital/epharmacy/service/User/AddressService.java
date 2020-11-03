package com.digital.epharmacy.service.User;

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.service.IService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface AddressService extends IService <Address, String> {
    Set<Address> getAll();
    Address findAddressByStreetName(String streetName);
}
