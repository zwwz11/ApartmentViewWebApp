package com.zwwz11.Apartment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class ApartmentRequestParam {

    private String targetURL;
    private String serviceKey;
    private String pageNo = "1";
    private String numOfRows = "10000";
    private String LAWD_CD;
    private String DEAL_YMD;

    public ApartmentRequestParam(String targetURL, String serviceKey, String LAWD_CD, String DEAL_YMD) {
        this.targetURL = targetURL;
        this.serviceKey = serviceKey;
        this.LAWD_CD = LAWD_CD;
        this.DEAL_YMD = DEAL_YMD;
    }

    public String getURL() {
        return targetURL
                + "?serviceKey=" + serviceKey
                + "&pageNo=" + pageNo
                + "&numOfRows=" + numOfRows
                + "&LAWD_CD=" + LAWD_CD
                + "&DEAL_YMD=" + DEAL_YMD;
    }
}
