package com.example.addressapi.service;

import com.example.addressapi.domain.Address;
import com.example.addressapi.port.AddressRepositoryPort;
import com.example.addressapi.port.AddressServicePort;

public class AddressService implements AddressServicePort {

    private AddressRepositoryPort addressRepository;

    public AddressService(AddressRepositoryPort addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public Address getAddress(String zipcode) {
          return addressRepository.getAddress(zipcode);
    }
}
