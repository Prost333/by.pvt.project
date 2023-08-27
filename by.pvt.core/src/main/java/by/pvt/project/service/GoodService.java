package by.pvt.project.service;

import by.pvt.project.domain.Good;

import java.util.List;

public interface GoodService {
    Good addGood (Good good);
    void deliteGood (int id);
    Good changeType (Good good,String type);
    Good changePrice(Good good, double price);
    Good changeName (Good good, String name);
    Good changeCode (Good good, int code);
    Good updateGood( int id,String name, String type,double price);
    Good createGood(String name, int id,String type,double price,int code);
    List<Good>goodList();
    int SizeGood();
    Good findGood (int id);
}
