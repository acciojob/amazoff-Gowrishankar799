package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repo {
    HashMap<String ,Order> orderHashMap = new HashMap<>();
    HashMap<String , DeliveryPartner> deliveryPartnerHashMap = new HashMap<>();
    HashMap<String , List<Order>> orderpartner = new HashMap<>();
    public void addOrder(Order order){
        String s = order.getId();
        orderHashMap.put(s,order);

    }
    public void addPartner(String id){

        DeliveryPartner d = new DeliveryPartner(id);

        deliveryPartnerHashMap.put(id,d);
    }
    public void addOrderPartnerPair(String s, String p){
        List<Order>list  = orderpartner.getOrDefault(s,new ArrayList<>());
        Order order = orderHashMap.get(s);
        list.add(order);
        orderpartner.put(p,list);
    }
    public DeliveryPartner addOrderPartnerPair(String s){
        if(!deliveryPartnerHashMap.containsKey(s)){
            return null;
        }
        return deliveryPartnerHashMap.get(s);

    }
    public Order getOrderById(String msg){
        if(!orderHashMap.containsKey(msg)){
            return null;
        }
        return orderHashMap.get(msg);
    }
    public Integer getOrderCountByPartnerId(String msg){
        if(!orderpartner.containsKey(msg)){
            return 0;
        }
        List<Order> list = orderpartner.get(msg);
        return list.size();
    }
    public List<String> getOrdersByPartnerId(String msg) {
        if (!orderpartner.containsKey(msg)) {
            return null;
        }
        List<Order> list = orderpartner.get(msg);
        List<String> al = new ArrayList<>();
        for(Order o : list){
            al.add(o.getId());
        }
        return al;
    }
    public List<String> getAllOrders(){
        List<String>al = new ArrayList<>();
        for(String s : orderHashMap.keySet()){
            al.add(s);
        }
        return al;
    }
    public int getCountOfUnassignedOrders(){
        int count = 0;
        for(List<Order> list : orderpartner.values()){
            count+=list.size();
        }
        int countt = 0;
        for(String s : orderHashMap.keySet()){
            countt++;
        }
        return countt-count;
    }

}
