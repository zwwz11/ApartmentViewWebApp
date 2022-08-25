package com.zwwz11.Apartment.common.page;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageParam {

    private int page = 1;
    private int amount = 20;

    private int start = 0;

    public void setPage(int page) {
        this.page = page;
        this.start = (page-1) * 20;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        this.start = (page-1) * 20;
    }
}
