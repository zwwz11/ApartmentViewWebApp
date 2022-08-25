package com.zwwz11.Apartment.service;

import com.zwwz11.Apartment.domain.Apartment;
import com.zwwz11.Apartment.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService{

    private final ApartmentRepository repository;

    @Override
    public List<Apartment> getApartmentList(String LAWD_CD) {
        return repository.getApartmentList(LAWD_CD);
    }
}
