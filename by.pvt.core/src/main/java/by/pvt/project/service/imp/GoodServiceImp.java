package by.pvt.project.service.imp;

import by.pvt.project.domain.Good;
import by.pvt.project.mapping.GoodMapping;
import by.pvt.project.repository.BD.GoodRepositoryBD;
import by.pvt.project.repository.file.GoodRepositoryFile;
import by.pvt.project.service.GoodService;

import java.util.List;
import java.util.Optional;

public class GoodServiceImp implements GoodService {
    private GoodMapping goodMapping;
    private GoodRepositoryBD goodRepositoryBD;

    public GoodServiceImp(GoodMapping goodMapping, GoodRepositoryBD goodRepositoryBD) {
        this.goodMapping = goodMapping;
        this.goodRepositoryBD = goodRepositoryBD;
    }

    @Override
    public void addGood(Good good) {
        goodRepositoryBD.addgood(good);
    }


    @Override
    public Good changeType(Good good, String type) {
        good = findIDGood(good.getId());
        good.setType(type);
        return good;
    }

    @Override
    public Good changePrice(Good good, double price) {
        good = findIDGood(good.getId());
        good.setPrice(price);
        return good;
    }

    @Override
    public Good changeName(Good good, String name) {
        good = findIDGood(good.getId());
        good.setName(name);
        return good;
    }

    @Override
    public Good changeCode(Good good, int code) {
        good = findIDGood(good.getId());
        good.setCode(code);
        return good;
    }

    @Override
    public void updateGood(int id, String name, String type, double price) {
        goodRepositoryBD.changeGoodName(id,name);
        goodRepositoryBD.changeGoodType(id,type);
        goodRepositoryBD.changeGoodprice(id,price);

    }

    @Override
    public Good createGood(String name, int id, String type, double price, int code) {
        return new Good(name, id, type, price, code);
    }

    @Override
    public List<Good> goodList() {
        return goodRepositoryBD.getAllGood();
    }

    @Override
    public int SizeGood() {
        return goodRepositoryBD.getAllGood().size();
    }

    @Override
    public Good findGood(int id) {
        List<Good> users = goodRepositoryBD.getAllGood();
        Optional<Good> users2 = users.stream().filter(good -> good.getId() == id).findFirst();
        return users2.get();
    }

    public Good findIDGood(int id) {
        List<Good> users = goodRepositoryBD.getAllGood();
        Optional<Good> good1 = users.stream().filter(good -> good.getId() == id).findFirst();

        return good1.get();
    }

    @Override
    public void deliteGood(int id) {
        Good good = findIDGood(id);
        goodRepositoryBD.deleteGood(good);

    }
}
