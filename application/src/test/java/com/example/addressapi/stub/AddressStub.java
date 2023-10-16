package com.example.addressapi.stub;

import com.example.addressapi.domain.Address;

public class AddressStub {

    public static Address getAddress() {
        Address address = new Address();
        address.setZipCode("95603-620");
        address.setStreetAddress("Rua Oswaldo Cruz");
        address.setComplement("até 799/800");
        address.setNeighborhood("Empresa");
        address.setLocality("Taquara");
        address.setFu("RS");
        address.setIbge("4321204");
        address.setDdd("51");
        address.setSiafi("8927");
        return address;
    }
}
