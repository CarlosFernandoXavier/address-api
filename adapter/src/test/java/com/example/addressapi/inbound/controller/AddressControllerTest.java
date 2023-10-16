package com.example.addressapi.inbound.controller;

import com.example.addressapi.domain.Address;
import com.example.addressapi.inbound.response.CustomerResponse;
import com.example.addressapi.outbound.exception.BadRequestException;
import com.example.addressapi.outbound.exception.BusinessException;
import com.example.addressapi.outbound.repository.AddressRepository;
import com.example.addressapi.port.AddressServicePort;
import com.example.addressapi.stub.AddressStub;
import com.example.addressapi.stub.CustomerResponseStub;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ModelMapper modelMapper;
    @MockBean
    private AddressServicePort addressServicePort;
    @MockBean
    private AddressRepository addressRepository;

    @Test
    void should_return_address_successfully() {

        try {
            String zipcode = "95603620";
            Address address = AddressStub.getAddress();
            given(addressServicePort.getAddress(zipcode))
                    .willReturn(address);

            given(modelMapper.map(address, CustomerResponse.class))
                    .willReturn(CustomerResponseStub.getCustomerResponse());

            String expected = "{\"zipCode\":\"95603-620\",\"streetAddress\":\"Rua Oswaldo Cruz\",\"complement\":\"até 799/800\",\"neighborhood\":\"Empresa\",\"locality\":\"Taquara\",\"fu\":\"RS\",\"ibge\":\"4321204\",\"gia\":null,\"ddd\":\"51\",\"siafi\":\"8927\"}\n";

            mvc.perform(get("/v1/get-address?zipcode=95603620"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(expected));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_error_message_preconditional_failed() {

        try {
            String zipcode = "95603620";
            Address address = AddressStub.getAddress();

            given(addressServicePort.getAddress(zipcode))
                    .willThrow(new BusinessException("Erro"));

            String expected = "{\"status\":\"PRECONDITION_FAILED\",\"message\":\"Erro\",\"url\":\"/v1/get-address\"}";

            mvc.perform(get("/v1/get-address?zipcode=95603620"))
                    .andDo(print())
                    .andExpect(status().isPreconditionFailed())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(expected));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_error_message_internal_server_error() {

        try {
            String zipcode = "95603620";
            Address address = AddressStub.getAddress();

            given(addressServicePort.getAddress(zipcode))
                    .willThrow(new IllegalArgumentException("Erro"));

            String expected = "{\"status\":\"INTERNAL_SERVER_ERROR\",\"message\":\"Erro\",\"url\":\"/v1/get-address\"}";

            mvc.perform(get("/v1/get-address?zipcode=95603620"))
                    .andDo(print())
                    .andExpect(status().isInternalServerError())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(expected));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void should_return_error_message_bad_request() {

        try {
            String zipcode = "95603620";
            Address address = AddressStub.getAddress();

            given(addressServicePort.getAddress(zipcode))
                    .willThrow(new BadRequestException());

            String expected = "{\"status\":\"BAD_REQUEST\",\"message\":\"incorrect zipcode\",\"url\":\"/v1/get-address\"}";

            mvc.perform(get("/v1/get-address?zipcode=95603620"))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content()
                            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(expected));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}