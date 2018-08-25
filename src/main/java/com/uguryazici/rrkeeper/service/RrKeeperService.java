package com.uguryazici.rrkeeper.service;

import com.uguryazici.rrkeeper.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RrKeeperService {

    @Autowired
    RequestRepository requestRepository;
}
