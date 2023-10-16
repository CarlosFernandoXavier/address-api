package com.example.addressapi.service;


import com.example.addressapi.domain.Address;
import com.example.addressapi.port.AddressRepositoryPort;
import com.example.addressapi.stub.AddressStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;
    @Mock
    private AddressRepositoryPort addressRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressService = new AddressService(addressRepository);
    }

    @Test
    void should_return_address_successfully() {
        Address address = AddressStub.getAddress();
        String zipcode = "95603-620";
        when(addressRepository.getAddress(zipcode))
                .thenReturn(address);
        Address actual = addressService.getAddress(zipcode);
        Address expected = address;
        assertEquals(expected, actual);

        verify(addressRepository, times(1)).getAddress(zipcode);
    }
}