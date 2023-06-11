package com.example.addressapi.outbound.repository;

import com.example.addressapi.domain.Address;
import com.example.addressapi.outbound.entity.AddressEntity;
import com.example.addressapi.outbound.exception.BadRequestException;
import com.example.addressapi.outbound.exception.BusinessException;
import com.example.addressapi.outbound.properties.AddressPropertie;
import com.example.addressapi.port.AddressRepositoryPort;
import com.example.addressapi.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutionException;

import static com.example.addressapi.utils.JsonUtils.convertToJson;

@Repository
@Slf4j
public class AddressRepository implements AddressRepositoryPort {

    private static final String RETURN_MESSAGE = "Response returned from viacep service: %s";
    private static final String FAILED_MESSAGE = "Failed to call viacep service - captured message: %s";
    private AddressPropertie propertie;
     private ModelMapper modelMapper;

    private WebClient webClient;

    public AddressRepository(ModelMapper modelMapper, ModelMapperUtils modelMapperUtils, AddressPropertie propertie) {
        modelMapperUtils.createConfigurationAddressToAddressEntity(modelMapper);
        this.modelMapper = modelMapper;
        this.propertie = propertie;
        this.webClient = WebClient.create();
    }

    @Override
    public Address getAddress(String zipcode) {

        String url = propertie.getUrlAddress().replaceFirst("/cep/", "/" + zipcode + "/");
        log.info("Calling the viacep service: " + url);
        try {
            AddressEntity addressEntity = webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .toEntity(AddressEntity.class)
                    .toFuture()
                    .get()
                    .getBody();

            Address address = modelMapper.map(addressEntity, Address.class);
            String logMessage = String.format(RETURN_MESSAGE, convertToJson(address));
            log.info(logMessage);
            return address;

        } catch (ExecutionException e) {
            throw new BadRequestException();
        } catch (Exception e) {
            String message = String.format(FAILED_MESSAGE, e.getMessage());
            log.error(message, e);
            throw new BusinessException(message);
        }
    }
}
