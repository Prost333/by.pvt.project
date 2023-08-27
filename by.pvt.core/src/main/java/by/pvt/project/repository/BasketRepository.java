package by.pvt.project.repository;



import by.pvt.project.domain.Basket;
import by.pvt.project.domain.Good;

import java.util.ArrayList;
import java.util.List;

public class BasketRepository extends FileWorker{
    public static List<Basket> basketList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Basket.txt";
    public Basket addBasket(Basket basket) {
        basketList= update();
        basketList.add(basket);
        serializeObject(basketList, way);
        saveBasket();
        return basket;
    }

    public Basket  addBasketloc(Basket basket) {
        basketList= update();
        basketList.add(basket);
        serializeObject(basketList, way);
        saveBasket();
        return basket;
    }
    public void deleteBasked(Basket basket) {
        basketList = update();
        basketList.remove(basket);
        serializeObject(basketList,way);
    }

    public List<Basket> showAllBasket() {
        basketList= (List<Basket>) deserializeObject(way);
        System.out.println(deserializeObject(way));
        return basketList;
    }
    public void serialize (Basket basket){
        serializeObject(basket,way);
        update();
    }


    public void saveBasket() {
        serializeObject(basketList, way);
        update();

    }

    public List<Basket> update() {
        Object object = deserializeObject(way);
        List<Basket> baskets = new ArrayList<>();
        if (object instanceof List<?>) {
            baskets = (List<Basket>) object;
        }
        return baskets;
    }
}

