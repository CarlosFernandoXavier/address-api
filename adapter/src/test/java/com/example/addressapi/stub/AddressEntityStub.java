package com.example.addressapi.stub;

import com.example.addressapi.outbound.entity.AddressEntity;

public class AddressEntityStub {

    public static AddressEntity getAddressEntity() {
        return AddressEntity.builder()
                .cep("95603-620")
                .logradouro("Rua Oswaldo Cruz")
                .complemento("até 799/800")
                .bairro("Empresa")
                .localidade("Taquara")
                .uf("RS")
                .ibge("4321204")
                .ddd("51")
                .siafi("8927")
                .build();
    }
}
