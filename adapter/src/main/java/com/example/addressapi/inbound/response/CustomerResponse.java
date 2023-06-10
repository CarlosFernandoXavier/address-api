package com.example.addressapi.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponse {
    private String zipCode;
    private String streetAddress;
    private String complement;
    private String neighborhood;
    private String locality;
    private String fu;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
