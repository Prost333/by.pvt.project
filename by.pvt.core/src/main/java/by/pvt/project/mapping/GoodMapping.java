package by.pvt.project.mapping;

import by.pvt.project.domain.Good;
import by.pvt.project.dto.GoodRequest;
import by.pvt.project.dto.GoodResponse;
import by.pvt.project.repository.GoodRepository;
import by.pvt.project.service.GoodService;
import by.pvt.project.service.imp.GoodServiceImp;

import java.util.Optional;


public class GoodMapping {
    GoodServiceImp goodServiceImp;

    public GoodResponse responseGood(Good good) {
        GoodResponse goodResponse = new GoodResponse(good.getName(), good.getId(), good.getType(),
                good.getPrice(), good.getCode());
        return goodResponse;
    }

    public Good requestGood(GoodRequest goodRequest) {
        GoodRepository goodRepository = new GoodRepository();
        Good good=goodRepository.update().stream().filter(good1 -> good1.getId()==goodRequest.getId()).findFirst().orElseThrow();

        return good ;
    }
}
