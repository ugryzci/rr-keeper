package com.uguryazici.rrkeeper.controller;

import com.uguryazici.rrkeeper.entity.Request;
import com.uguryazici.rrkeeper.entity.Response;
import com.uguryazici.rrkeeper.repository.RequestRepository;
import com.uguryazici.rrkeeper.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/rrKeeper")
public class RrKeeperController {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ResponseRepository responseRepository;

    @GetMapping(path = "/getServiceString")
    public String getServiceString(){
        return "Ok";
    }

    @GetMapping(path = "/getServiceString2")
    public String getServiceString2(){
        return "Not Ok";
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Request> addRequest(@RequestBody Request request){

        Request saved = requestRepository.save(request);

        for (Response respons : request.getResponses()) {
            respons.setRequest(request);
        }

        responseRepository.saveAll(request.getResponses());

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<Iterable<Request>> listRequest(){

        Iterable<Request> all = requestRepository.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
