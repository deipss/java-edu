package edu.java.deipss.web.controller;

import edu.java.deipss.service.service.MapperQueryService;
import edu.java.deipss.sql.dal.entity.classicmodel.Customers;
import edu.java.deipss.sql.dal.mapper.classicmodel.CustomersMapper;
import edu.java.deipss.web.response.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private MapperQueryService mapperQueryService;

    @Autowired
    private CustomersMapper customersMapper;

    @PostMapping("/all")
    public HttpResponse<List<Customers>> queryAll() {

        return HttpResponse.suucess(customersMapper.listAll());
    }





}
