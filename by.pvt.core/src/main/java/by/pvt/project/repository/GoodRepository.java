package by.pvt.project.repository;



import by.pvt.project.domain.Good;

import java.util.ArrayList;
import java.util.List;

public class GoodRepository extends FileWorker {
    public static List<Good> goodList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Good.txt";

    public GoodRepository() {
    }
    public Good addGood(Good good) {
        goodList = update();
        goodList.add(good);
        serializeObject(goodList, way);
        saveGood();
        return good;
    }

    public void deleteGood(Good good) {
        goodList = update();
        goodList.remove(good);
        saveGood();
    }

    public List<Good> showAllGood() {
        goodList= (List<Good>) deserializeObject(way);
        System.out.println(deserializeObject(way));
        return goodList;
    }


    public void saveGood() {
        serializeObject(goodList, way);
        update();

    }

    public List<Good> update() {
        Object object = deserializeObject(way);
        List<Good> good = new ArrayList<>();
        if (object instanceof List<?>) {
            good = (List<Good>) object;
        }
        return good;
    }
}
