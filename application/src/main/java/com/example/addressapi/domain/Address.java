package com.example.addressapi.domain;

import java.util.Objects;

public class Address {
    private String zipCode;
    private String streetAddress;
    private String complement;
    private String neighborhood;
    private String locality;
    private String fu;
    private String ibge;
    private String ddd;
    private String siafi;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFu() {
        return fu;
    }

    public void setFu(String fu) {
        this.fu = fu;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(zipCode, address.zipCode) && Objects.equals(streetAddress, address.streetAddress) && Objects.equals(complement,
                address.complement) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(locality,
                address.locality) && Objects.equals(fu, address.fu) && Objects.equals(ibge, address.ibge) &&
                Objects.equals(ddd, address.ddd) && Objects.equals(siafi, address.siafi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, streetAddress, complement, neighborhood, locality, fu, ibge, ddd, siafi);
    }
}