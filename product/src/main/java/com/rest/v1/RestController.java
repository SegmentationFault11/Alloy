package com.rest.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stevenma on 9/24/16.
 */
@Controller
public class RestController {

    @RequestMapping({"/status", "/status/"})
    public ResponseEntity<String> getStatus() throws Exception {
        return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(new ServerStatus()), HttpStatus.OK);
    }
}
