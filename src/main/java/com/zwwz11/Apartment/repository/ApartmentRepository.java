package com.zwwz11.Apartment.repository;

import com.zwwz11.Apartment.domain.Apartment;

import java.util.List;

public interface ApartmentRepository {
    List<Apartment> getApartmentList(String LAWD_CD);
}
