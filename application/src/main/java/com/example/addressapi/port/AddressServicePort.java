package com.example.addressapi.port;

import com.example.addressapi.domain.Address;

public interface AddressServicePort {
    Address getAddress(String zipcode);
}
