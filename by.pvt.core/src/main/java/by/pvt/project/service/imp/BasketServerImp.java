package by.pvt.project.service.imp;

import by.pvt.project.mapping.BasketMapping;
import by.pvt.project.repository.BasketRepository;
import by.pvt.project.service.BasketService;

public class BasketServerImp implements BasketService {
    private BasketRepository basketRepository;
    private BasketMapping basketMapping;

    public BasketServerImp(BasketRepository basketRepository, BasketMapping basketMapping) {
        this.basketRepository = basketRepository;
        this.basketMapping = basketMapping;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketMapping getBasketMapping() {
        return basketMapping;
    }

    public void setBasketMapping(BasketMapping basketMapping) {
        this.basketMapping = basketMapping;
    }
}
