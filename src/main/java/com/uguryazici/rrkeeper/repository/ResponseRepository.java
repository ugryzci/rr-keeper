package com.uguryazici.rrkeeper.repository;

import com.uguryazici.rrkeeper.entity.Request;
import com.uguryazici.rrkeeper.entity.Response;
import org.springframework.data.repository.CrudRepository;

public interface ResponseRepository extends CrudRepository<Response, Long> {

}
