package com.khubla.osgiexample.restlet.service.impl;

import java.util.Date;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.khubla.osgiexample.restlet.service.HelloService;

/**
 * @author tome
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
   public String sayHello() {
      return "Hello.  The date is: " + new Date().toString();
   }
}