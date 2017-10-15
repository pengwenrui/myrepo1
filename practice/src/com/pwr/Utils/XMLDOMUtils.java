package com.pwr.Utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class XMLDOMUtils {

    public static Document getDocument(String startFileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(startFileName);
        return document;
    }

    public static void write2Xml(Document document,String endFileName) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer tf = factory.newTransformer();
        tf.transform(new DOMSource(document), new StreamResult(
                new FileOutputStream(endFileName)));

    }
}
