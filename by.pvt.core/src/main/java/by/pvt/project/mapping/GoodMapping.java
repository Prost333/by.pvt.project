package by.pvt.project.mapping;

import by.pvt.project.domain.Good;
import by.pvt.project.dto.GoodRequest;
import by.pvt.project.dto.GoodResponse;
import by.pvt.project.repository.file.GoodRepositoryFile;
import by.pvt.project.service.imp.GoodServiceImp;


public class GoodMapping {
    GoodServiceImp goodServiceImp;

    public GoodResponse responseGood(Good good) {
        GoodResponse goodResponse = new GoodResponse(good.getName(), good.getId(), good.getType(),
                good.getPrice(), good.getCode());
        return goodResponse;
    }

    public Good requestGood(GoodRequest goodRequest) {
        Good good= new Good(goodRequest.getName(), goodRequest.getId(), goodRequest.getType(),
                goodRequest.getPrice(), goodRequest.getCode());

        return good ;
    }
}
