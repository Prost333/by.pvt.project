package by.pvt.project.repository.serviceRep;

import by.pvt.project.domain.Good;

import java.util.List;

public interface GoodRepository {

    void addgood(Good good);
    void deleteGood(Good good);
    List<Good> getAllGood();
    Good findGoodById(int id);
    void changeGoodprice(int goodId, double price);
    void changeGoodType(int goodId, String type);
    void changeGoodName(int goodId, String name);

}
