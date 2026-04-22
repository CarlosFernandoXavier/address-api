package com.example.addressapi.inbound.controller;

import com.example.addressapi.controller.api.V1Api;
import com.example.addressapi.domain.Address;
import com.example.addressapi.model.CustomerResponse;
import com.example.addressapi.port.AddressServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.example.addressapi.utils.JsonUtils.convertToJson;

@RestController
@AllArgsConstructor
@Slf4j
public class AddressController implements V1Api {

    private ModelMapper modelMapper;
    private AddressServicePort addressServicePort;

   @Override
    public ResponseEntity<CustomerResponse> getAddress(String zipcode) {
        log.info("Starting process to get the address...");
        Address address = addressServicePort.getAddress(zipcode);
        CustomerResponse customerResponse = modelMapper.map(address, CustomerResponse.class);
        log.info("Response returned to user: " + convertToJson(customerResponse));
        return ResponseEntity.ok(customerResponse);
    }



}
