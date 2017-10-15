package com.xzy.day03;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class XpathparserXml{
    public static void main(String [] args)throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("learn/books.xml");
        //Node node = document.selectSingleNode("/books/book[@id='0004']/author/text()");
       // Node node = document.selectSingleNode("/books//name");
//        List<Element> selectNodes = document.selectNodes("//name");
//        for(int i=0;i<selectNodes.size();i++){
//            System.out.println(selectNodes.get(i).getTextTrim());
//        }


        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for(int i=0;i<elements.size();i++){
            System.out.println(elements.get(i).getName());
        }


        //System.out.println(node.getStringValue());
//        List<Element> list   = document.selectNodes("/books/book/name");
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getTextTrim());
//        }
    }
}
