package by.pvt.project.service.imp;

import by.pvt.project.domain.Good;
import by.pvt.project.mapping.GoodMapping;
import by.pvt.project.repository.GoodRepository;
import by.pvt.project.service.GoodService;

import java.util.List;
import java.util.Optional;

public class GoodServiceImp implements GoodService {
    private GoodMapping goodMapping;
    private GoodRepository goodRepository;

    public GoodServiceImp(GoodMapping goodMapping, GoodRepository goodRepository) {
        this.goodMapping = goodMapping;
        this.goodRepository = goodRepository;
    }

    public GoodMapping getGoodMapping() {
        return goodMapping;
    }

    public void setGoodMapping(GoodMapping goodMapping) {
        this.goodMapping = goodMapping;
    }

    public GoodRepository getGoodRepository() {
        return goodRepository;
    }

    public void setGoodRepository(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public Good addGood(Good good) {
        return goodRepository.addGood(good);
    }



    @Override
    public Good changeType(Good good, String type) {
        good=findIDGood(good.getId());
        good.setType(type);
        goodRepository.saveGood();
        return good;
    }

    @Override
    public Good changePrice(Good good, double price) {
        good=findIDGood(good.getId());
        good.setPrice(price);
        goodRepository.saveGood();
        return good;
    }

    @Override
    public Good changeName(Good good, String name) {
        good=findIDGood(good.getId());
        good.setName(name);
        goodRepository.saveGood();
        return good;
    }

    @Override
    public Good changeCode(Good good, int code) {
        good=findIDGood(good.getId());
        good.setCode(code);
        goodRepository.saveGood();
        return good;
    }

    @Override
    public Good updateGood(int id,String name, String type, double price) {
        Good good=findIDGood(id);
        Good newGood=new Good(name,id,type,price,good.getCode());
        goodRepository.deleteGood(good);
        goodRepository.addGood(newGood);
        return newGood;
    }

    @Override
    public Good createGood(String name, int id, String type, double price, int code) {
        return new Good(name,id,type,price,code);
    }

    @Override
    public List<Good> goodList() {
        return goodRepository.showAllGood();
    }

    @Override
    public int SizeGood() {
        return goodRepository.update().size();
    }

    public Good findIDGood(int id) {
        List<Good> users = goodRepository.update();
        Optional<Good> good1 = users.stream().filter(good -> good.getId() == id).findFirst();
        try {
            if (good1.isEmpty()) {
                System.out.println("Такого id не существует");
            } else {
                System.out.println(good1.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return good1.get();
    }
    @Override
    public void deliteGood(int id) {
        Good good=findIDGood(id);
        goodRepository.deleteGood(good);

    }
}
