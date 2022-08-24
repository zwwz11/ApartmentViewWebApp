package com.zwwz11.Apartment.service;

import com.zwwz11.Apartment.domain.Apartment;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getApartmentList(String LAWD_CD);
}
