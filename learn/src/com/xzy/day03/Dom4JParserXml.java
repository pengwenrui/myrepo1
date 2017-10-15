package com.xzy.day03;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4JParserXml {
    public static void main(String [] args)throws Exception{
        SAXReader saxReader =new SAXReader();
        Document document = saxReader.read("learn/books.xml");
        Element element = document.addElement("id");
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.elements("book");
        for(Element bookElement : list){
            System.out.println(bookElement.attributeValue("id"));
            List<Element> names = bookElement.elements("name");
            for(Element nameElement : names){
                System.out.println(nameElement.getTextTrim());
            }
        }


    }
}
