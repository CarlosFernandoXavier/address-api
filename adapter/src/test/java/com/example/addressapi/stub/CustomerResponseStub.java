package com.example.addressapi.stub;

import com.example.addressapi.inbound.response.CustomerResponse;

public class CustomerResponseStub {

    public static CustomerResponse getCustomerResponse() {
        return CustomerResponse.builder()
                .zipCode("95603-620")
                .streetAddress("Rua Oswaldo Cruz")
                .complement("até 799/800")
                .neighborhood("Empresa")
                .locality("Taquara")
                .fu("RS")
                .ibge("4321204")
                .ddd("51")
                .siafi("8927")
                .build();
    }
}
