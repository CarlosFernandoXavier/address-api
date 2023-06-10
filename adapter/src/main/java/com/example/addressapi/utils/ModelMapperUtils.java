package com.example.addressapi.utils;

import com.example.addressapi.domain.Address;
import com.example.addressapi.outbound.entity.AddressEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class ModelMapperUtils {

    public void createConfigurationAddressToAddressEntity(ModelMapper modelMapper) {
        TypeMap<AddressEntity, Address> propertyMapper = modelMapper.createTypeMap(AddressEntity.class, Address.class);
        propertyMapper.addMappings(
                mapper -> {
                    mapper.map(src -> src.getCep(), Address::setZipCode);
                    mapper.map(src -> src.getBairro(), Address::setNeighborhood);
                    mapper.map(src -> src.getComplemento(), Address::setComplement);
                    mapper.map(src -> src.getLocalidade(), Address::setLocality);
                    mapper.map(src -> src.getLogradouro(), Address::setStreetAddress);
                    mapper.map(src -> src.getUf(), Address::setFu);
                });
    }
}
