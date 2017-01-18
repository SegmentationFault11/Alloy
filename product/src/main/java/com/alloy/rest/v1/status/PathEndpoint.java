package com.alloy.rest.v1.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.alloy.service.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by stevenma on 10/4/16.
 */
@Controller
@RequestMapping("/status/path")
public class PathEndpoint
{

    @RequestMapping(value = {"/user","/user/"}, method = RequestMethod.GET)
    public ResponseEntity<String> getUserPath() throws Exception
    {
        return new ResponseEntity<>(System.getProperty("user.dir"), HttpStatus.OK);
    }

    @RequestMapping(value = {"/catalinabase","/catalinabase/"}, method = RequestMethod.GET)
    public ResponseEntity<String> getCatalinaBase() throws Exception
    {
        return new ResponseEntity<>(System.getProperty("CATALINA_BASE"), HttpStatus.OK);
    }

    @RequestMapping(value = {"/aux","/aux/"}, method = RequestMethod.GET)
    public ResponseEntity<String> getAuxPath() throws Exception
    {
        return new ResponseEntity<>(System.getenv("AUX"), HttpStatus.OK);
    }

}
