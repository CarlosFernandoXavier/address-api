package com.example.addressapi.outbound.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddressPropertie {

    @Value("${url.address.api}")
    private String urlAddress;

    public String getUrlAddress() {
        return urlAddress;
    }
}
