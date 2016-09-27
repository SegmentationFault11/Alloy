package com.rest.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stevenma on 9/24/16.
 */
@Controller
@RequestMapping("/status")
public class StatusEndpoint
{

    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public ResponseEntity<String> getStatus() throws Exception
    {
        return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(new ServerStatus()), HttpStatus.OK);
    }

}
