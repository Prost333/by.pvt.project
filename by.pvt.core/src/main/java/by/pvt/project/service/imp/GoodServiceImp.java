package by.pvt.project.service.imp;

import by.pvt.project.mapping.GoodMapping;
import by.pvt.project.repository.GoodRepository;
import by.pvt.project.service.GoodService;

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
}
