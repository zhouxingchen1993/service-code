//package com.htsat.order.serviceimpl;
//
//import com.htsat.order.service.ILoadBalanceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class LoadBalanceServiceImpl implements ILoadBalanceService {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public String loadbalanceService(String name) {
//        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
//    }
//}