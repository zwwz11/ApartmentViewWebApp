package com.zwwz11.Apartment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApartmentRequestParam {
    String PageNo;
    String NumofRows;
    String LAWD_CD;
    String DEAL_YMD;
}
