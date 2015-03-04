/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvalle.ids.analyser;

/**
 *
 * @author mvalle
 */
import br.com.mvalle.ids.sniffer.Sniffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

       private String temp;
       private ArrayList<Sniffer> sniffer = new ArrayList<Sniffer>();

       /** The main method sets things up for parsing */
       public static void main(String[] args) throws IOException, SAXException,
                     ParserConfigurationException {
             
              //Create a "parser factory" for creating SAX parsers
              SAXParserFactory spfac = SAXParserFactory.newInstance();

              //Now use the parser factory to create a SAXParser object
              SAXParser sp = spfac.newSAXParser();

              //Create an instance of this class; it defines all the handler methods
              XMLHandler handler = new XMLHandler();

              //Finally, tell the parser to parse the input and notify the handler
              sp.parse("bank.xml", handler);
             
              handler.readList();

       }


       /*
        * When the parser encounters plain text (not XML elements),
        * it calls(this method, which accumulates them in a string buffer
        */
       public void characters(char[] buffer, int start, int length) {
              temp = new String(buffer, start, length);
       }
      

       /*
        * Every time the parser encounters the beginning of a new element,
        * it calls this method, which resets the string buffer
        */ 
       public void startElement(String uri, String localName,
                     String qName, Attributes attributes) throws SAXException {
              temp = "";
              if (qName.equalsIgnoreCase("Account")) {
                  //insert code to get http fields
                     /*acct = new Account();
                     acct.setType(attributes.getValue("type"));
                  */

              }
       }

       /*
        * When the parser encounters the end of an element, it calls this method
        */
       public void endElement(String uri, String localName, String qName)
                     throws SAXException {

              if (qName.equalsIgnoreCase("Account")) {
                     // add it to the list
                     //accList.add(acct);

              }

       }

       private void readList() {
              System.out.println("No of  the accounts in bank '" + sniffer.size()  + "'.");
              Iterator<Sniffer> it = sniffer.iterator();
              while (it.hasNext()) {
                     System.out.println(it.next().toString());
              }
       }
      
}