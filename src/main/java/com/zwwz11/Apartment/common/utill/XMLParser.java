package com.zwwz11.Apartment.common.utill;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLParser {
    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        return nodeList.item(0).getTextContent();
    }
}
