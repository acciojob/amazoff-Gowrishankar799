package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serviceclass {

    Repo repo = new Repo();
    public void addOrder(Order order){
        repo.addOrder(order);
    }
    public void addPartner(String id){
        repo.addPartner(id);
    }
    public  void addOrderPartnerPair(String o,String p){
        repo.addOrderPartnerPair(o,p);
    }
    public DeliveryPartner addOrderPartnerPair(String str){
        return repo.addOrderPartnerPair(str);
    }
    public Order getOrderById(String msg){
        return repo.getOrderById(msg);
    }
    public Integer getOrderCountByPartnerId(String msg){
        return repo.getOrderCountByPartnerId(msg);
    }
    public List<String> getOrdersByPartnerId(String msg){
        return repo.getOrdersByPartnerId(msg);
    }
    public List<String> getAllOrders(){
        return repo.getAllOrders();
    }
    public int getCountOfUnassignedOrders(){
        return repo.getCountOfUnassignedOrders();
    }
}
