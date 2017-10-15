package com.xzy.day03;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class test {
    public static void main(String [] args) throws  Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("learn/books.xml");
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.elements("book");
        for (Element bookElement : list){
            if(bookElement.attributeValue("id").equals("0004")){
                System.out.println(bookElement.element("author").getTextTrim());
            }
        }
    }
}
