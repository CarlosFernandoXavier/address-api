package com.example.addressapi.outbound.repository;

import com.example.addressapi.domain.Address;
import com.example.addressapi.outbound.entity.AddressEntity;
import com.example.addressapi.outbound.exception.BusinessException;
import com.example.addressapi.outbound.properties.AddressProperty;
import com.example.addressapi.stub.AddressEntityStub;
import com.example.addressapi.stub.AddressStub;
import com.example.addressapi.utils.ModelMapperUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AddressRepositoryTest {

    @InjectMocks
    private AddressRepository addressRepository;
    @Mock
    private AddressProperty property;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private ModelMapperUtils modelMapperUtils;
    @Mock
    private WebClient webClient;
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpecMock;
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;
    @Mock
    private WebClient.ResponseSpec responseSpecMock;
    @Mock
    private CompletableFuture<ResponseEntity<AddressEntity>> responseFuture;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressRepository = new AddressRepository(modelMapper, modelMapperUtils, property, webClient);
    }

    @Test
    void should_return_address_successfully() {
        String zipcode = "95603-620";
        when(property.getUrlAddress())
                .thenReturn("https://viacep.com.br/ws/cep/json/");

        when(webClient.get())
                .thenReturn(requestHeadersUriSpecMock);

        when(requestHeadersUriSpecMock.uri("https://viacep.com.br/ws/95603-620/json/"))
                .thenReturn(requestHeadersSpecMock);

        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);

        AddressEntity addressEntity = AddressEntityStub.getAddressEntity();
        when(responseSpecMock.toEntity(
                ArgumentMatchers.<Class<AddressEntity>>notNull()))
                .thenReturn(Mono.just(new ResponseEntity<>(addressEntity, HttpStatus.OK)));

        when(responseFuture.toCompletableFuture())
                .thenReturn(CompletableFuture.completedFuture(new ResponseEntity<>(addressEntity, HttpStatus.OK)));

        when(modelMapper.map(addressEntity, Address.class))
                .thenReturn(AddressStub.getAddress());

        Address actual = addressRepository.getAddress(zipcode);
        Address expected = AddressStub.getAddress();
        assertEquals(expected, actual);

        verify(property, times(1)).getUrlAddress();
        verify(webClient, times(1)).get();
        verify(modelMapper, times(1)).map(addressEntity, Address.class);
    }

    @Test
    void should_throw_business_exception() {
        String zipcode = "95603-620";
        when(property.getUrlAddress())
                .thenReturn("https://viacep.com.br/ws/cep/json/");

        when(webClient.get())
                .thenReturn(requestHeadersUriSpecMock);

        when(requestHeadersUriSpecMock.uri("https://viacep.com.br/ws/95603-620/json/"))
                .thenReturn(requestHeadersSpecMock);

        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.toEntity(
                ArgumentMatchers.<Class<AddressEntity>>notNull()))
                .thenThrow(new IllegalArgumentException("erro"));

        assertThrows(BusinessException.class, () -> addressRepository.getAddress(zipcode));
        verify(property, times(1)).getUrlAddress();
        verify(webClient, times(1)).get();
    }
}