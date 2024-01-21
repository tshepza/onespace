package com.onespace.controller;


import com.onespace.MessageServiceProcessor;
import com.onespace.dto.InputData;
import com.onespace.dto.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/conversion")
public class ConversionController {

    MessageServiceProcessor serviceProcessor;

    @Autowired
    public ConversionController(MessageServiceProcessor serviceProcessor) {
        this.serviceProcessor = serviceProcessor;
    }

    @GetMapping(value = "/ping", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity ping() {
        return new ResponseEntity<>("This is the resource: /v1/conversion", HttpStatus.OK);
    }

    @PostMapping(value= "/convert", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Output> convert(@RequestBody InputData inputData){


        String response = null;
        try {
            response = serviceProcessor.process(inputData.getInput());
        } catch (Exception e) {
            return new ResponseEntity(new Output("Couldn't process the given input " + inputData.getInput() ),HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity(new Output(response),HttpStatus.OK);
    }

}
