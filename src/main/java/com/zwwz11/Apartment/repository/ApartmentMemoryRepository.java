package com.zwwz11.Apartment.repository;

import com.zwwz11.Apartment.domain.Apartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ApartmentMemoryRepository implements ApartmentRepository{

    @Override
    public List<Apartment> getApartmentList(String LAWD_CD) {
        return null;
    }
}
