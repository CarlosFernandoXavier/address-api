package com.example.addressapi.inbound.controller;

import com.example.addressapi.domain.Address;
import com.example.addressapi.inbound.exception.ErrorMessage;
import com.example.addressapi.inbound.response.CustomerResponse;
import com.example.addressapi.port.AddressServicePort;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.addressapi.utils.JsonUtils.convertToJson;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/v1")
public class AddressController {

    private ModelMapper modelMapper;
    private AddressServicePort addressServicePort;

    @GetMapping(value = "/get-address", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, response = CustomerResponse.class, message = "OK"),
            @ApiResponse(code = 412, response = ErrorMessage.class, message = "PRECONDITION_FAILED"),
            @ApiResponse(code = 500, response = ErrorMessage.class, message = "INTERNAL_SERVER_ERROR")
    })
    public ResponseEntity<CustomerResponse> getAddress(@RequestParam String zipcode) {
        log.info("Starting process to get the address...");
        Address address = addressServicePort.getAddress(zipcode);
        CustomerResponse customerResponse = modelMapper.map(address, CustomerResponse.class);
        log.info("Response returned to user: " + convertToJson(customerResponse));
        return ResponseEntity.ok(customerResponse);
    }
}
