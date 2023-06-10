package com.example.addressapi.port;

import com.example.addressapi.domain.Address;

public interface AddressRepositoryPort {

    Address getAddress(String cep);
}
