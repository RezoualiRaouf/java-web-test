package org.soa.ws.tp;

import javax.xml.ws.Endpoint;

public class HelloWorldPublisher {
  
  public static void main(String[] args) {
    Endpoint.publish("http://localhost:4848/helloworldws", new HelloWorldImpl());
  }

}