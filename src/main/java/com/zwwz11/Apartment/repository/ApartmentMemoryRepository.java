package com.zwwz11.Apartment.repository;

import com.zwwz11.Apartment.common.utill.XMLParser;
import com.zwwz11.Apartment.domain.Apartment;
import com.zwwz11.Apartment.domain.ApartmentRequestParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@PropertySource("classpath:/common.properties")
public class ApartmentMemoryRepository implements ApartmentRepository{

    @Value("${apartment.targetURL}")
    private String targetURL;

    @Value("${apartment.serviceKey}")
    private String serviceKey;

    @Override
    public List<Apartment> getApartmentList(String LAWD_CD) {
        List<Apartment> apartmentList = new ArrayList<>();
        try {

            for(int mon = 1; mon <= 12; mon++) {
                ApartmentRequestParam param = new ApartmentRequestParam(targetURL, serviceKey, LAWD_CD, "2022" + String.format("%02d", mon));
                String url = param.getURL();

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc =dBuilder.parse(url);
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("item");

                for(int idx = 0; idx < nodeList.getLength(); idx++) {
                    Node node = nodeList.item(idx);
                    Element element = (Element) node;
                    Apartment apartment = new Apartment();
                    apartment.setApartmentName(XMLParser.getTagValue("아파트", element));
                    apartment.setBuildYear(XMLParser.getTagValue("건축년도", element));
                    apartment.setAreaForExclusiveUse(XMLParser.getTagValue("전용면적", element));
                    apartment.setFloor(XMLParser.getTagValue("층", element));
                    apartment.setDealYear(XMLParser.getTagValue("년", element));
                    apartment.setDealMonth(XMLParser.getTagValue("월", element));
                    apartment.setDealDay(XMLParser.getTagValue("일", element));
                    apartment.setDong(XMLParser.getTagValue("법정동", element));
                    apartment.setDealAmount(XMLParser.getTagValue("거래금액", element).trim());
                    apartment.setJibun(XMLParser.getTagValue("지번", element));
                    apartment.setRegionalCode(XMLParser.getTagValue("지역코드", element));
                    apartment.setCancelDealDay(XMLParser.getTagValue("해제사유발생일", element));
                    apartment.setCancelDealType(XMLParser.getTagValue("해제여부", element));
                    apartmentList.add(apartment);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return apartmentList;
    }
}
