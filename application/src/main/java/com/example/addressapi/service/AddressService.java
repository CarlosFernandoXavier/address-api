package com.example.addressapi.service;

import com.example.addressapi.domain.Address;
import com.example.addressapi.exception.BadRequestServiceException;
import com.example.addressapi.exception.BusinessException;
import com.example.addressapi.port.AddressRepositoryPort;
import com.example.addressapi.port.AddressServicePort;
import org.springframework.web.client.HttpClientErrorException;

public class AddressService implements AddressServicePort {

    private AddressRepositoryPort addressRepository;

    public AddressService(AddressRepositoryPort addressRepository) {
        this.addressRepository = addressRepository;
    }
    @Override
    public Address getAddress(String zipcode) {
      //try {
          //addressRepository.getAddress(customerDto.getZipCode());
          return addressRepository.getAddress(zipcode);
     /* } catch (Exception e) {
          throw new BusinessException(e.getMessage());
      }*/
        /*} catch(BadRequestServiceException e) {
            throw new BadRequestServiceException(e.getMessage());
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }*/
    }
}
