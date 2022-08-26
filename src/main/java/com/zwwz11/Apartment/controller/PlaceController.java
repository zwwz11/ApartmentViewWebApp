package com.zwwz11.Apartment.controller;

import com.zwwz11.Apartment.common.page.PageDTO;
import com.zwwz11.Apartment.common.page.PageParam;
import com.zwwz11.Apartment.domain.Apartment;
import com.zwwz11.Apartment.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final ApartmentService service;
    private List<Apartment> apartmentList;
    private String LAWD_CD = "";

    @GetMapping("/busan")
    public String busan() {
        return "place/busan";
    }

    @GetMapping("/seoul")
    public String seoul() {
        return "place/seoul";
    }

    @GetMapping("/incheon")
    public String incheon() {
        return "place/incheon";
    }

    @GetMapping("/daegu")
    public String daegu() {
        return "place/daegu";
    }

    @GetMapping("/daejeoun")
    public String daejeoun() {
        return "place/daejeoun";
    }

    @GetMapping("/kwangju")
    public String kwangju() {
        return "place/kwangju";
    }

    @GetMapping("/{area}/{LAWD_CD}")
    public String busanDistricts(Model model
            , @PathVariable String area
            , @PathVariable String LAWD_CD
            , @RequestParam(required = true) String placeName
            , @RequestParam(defaultValue = "1") int currentPage
            , @RequestParam(defaultValue = "", name = "name") String name) {

        if(!this.LAWD_CD.equals(LAWD_CD)) {
            apartmentList = service.getApartmentList(LAWD_CD);
            this.LAWD_CD = LAWD_CD;
        }


        List<Apartment> filterApartmentList;
        if(!name.equals("")) {
            filterApartmentList = apartmentList.stream().filter(x -> x.getApartmentName().contains(name)).toList();
        } else {
            filterApartmentList = apartmentList.stream().toList();
        }

        PageParam pageParam = new PageParam();
        pageParam.setPage(currentPage);

        int listSize = filterApartmentList.size();
        int totalCount = listSize <= 0 ? 1 : listSize;
        PageDTO pageDTO = new PageDTO(pageParam, totalCount);
        int fromIndex = (currentPage - 1) * pageParam.getAmount();
        int toIndex = fromIndex + pageParam.getAmount() - 1;
        if(toIndex > totalCount - 1) {
            toIndex = Math.max(totalCount - 1, 0);
        }
        List<Apartment> subApartmentList = filterApartmentList.subList(fromIndex, toIndex);
        model.addAttribute("apartmentList", subApartmentList);
        model.addAttribute("placeName", placeName);
        model.addAttribute("page", pageDTO);
        model.addAttribute("name", name);
        return "place/list";
    }

}
