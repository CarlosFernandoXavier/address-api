package com.example.addressapi.stub;

import com.example.addressapi.model.CustomerResponse;

public class CustomerResponseStub {

    public static CustomerResponse getCustomerResponse() {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setZipCode("95603-620");
        customerResponse.setStreetAddress("Rua Oswaldo Cruz");
        customerResponse.setComplement("até 799/800");
        customerResponse.setNeighborhood("Empresa");
        customerResponse.setLocality("Taquara");
        customerResponse.setFu("RS");
        customerResponse.setIbge("4321204");
        customerResponse.setDdd("51");
        customerResponse.setSiafi("8927");
        return customerResponse;
    }
}
