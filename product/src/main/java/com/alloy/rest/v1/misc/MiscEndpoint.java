package com.alloy.rest.v1.misc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by stevenma on 9/27/16.
 */
@Controller
@RequestMapping("/misc")
public class MiscEndpoint
{

    @RequestMapping(value = {"/divthree/{i}", "/divthree/{i}/"}, method = RequestMethod.GET)
    public ResponseEntity<String> testEven(@PathVariable("i") Integer i)
    {
        String rst = i.toString() + " is ";
        if (i % 3 != 0)
        {
            rst += "NOT ";
        }

        rst += "divisible by 3";
        return new ResponseEntity<String>(rst, HttpStatus.OK);
    }

}
