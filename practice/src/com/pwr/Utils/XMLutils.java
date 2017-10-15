package com.pwr.Utils;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;

public class XMLutils {
    public static Document getDocument(String startFileName)throws Exception{
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read(startFileName);
        return document;
    }

    public static void Write(Document document,String endFileName)throws Exception{
        XMLWriter write =new XMLWriter(new FileWriter(endFileName));
        write.write(document);
        write.close();

    }


}
