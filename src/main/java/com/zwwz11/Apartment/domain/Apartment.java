package com.zwwz11.Apartment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Apartment {
    /**
     * 아파트 명
     */
    String apartmentName;
    /**
     * 건축년도
     */
    String buildYear;
    /**
     * 층
     */
    String floor;
    /**
     * 전용면적
     */
    String areaForExclusiveUse;
    /**
     * 지번
     */
    String jibun;
    /**
     * 동
     */
    String dong;
    /**
     * 지역코드
     */
    String regionalCode;
    /**
     * 거래금액
     */
    int dealAmount;
    /**
     * 거래(년)
     */
    String dealYear;
    /**
     * 거래(월)
     */
    String dealMonth;
    /**
     * 거래(일)
     */
    String dealDay;
    /**
     * 해제여부
     */
    String cancelDealType;
    /**
     * 해제사유발생일
     */
    String cancelDealDay;
    /**
     * 거래날짜
     */
    String deal;

    public String getDeal() {
        return dealYear + "-" + String.format("%02d", Integer.parseInt(dealMonth)) + "-" + String.format("%02d", Integer.parseInt(dealDay));
    }
}
