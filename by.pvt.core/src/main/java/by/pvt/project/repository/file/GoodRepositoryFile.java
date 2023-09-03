package by.pvt.project.repository.file;



import by.pvt.project.domain.Good;
import by.pvt.project.repository.FileWorker;
import by.pvt.project.repository.serviceRep.GoodRepository;

import java.util.ArrayList;
import java.util.List;

public class GoodRepositoryFile extends FileWorker implements GoodRepository {
    public static List<Good> goodList = new ArrayList<>();
    public static String way = "C:\\Project Java\\by.pvt.project\\by.pvt.core\\src\\main\\java\\by\\pvt\\project\\data\\Good.txt";

    public GoodRepositoryFile() {
    }

    public void addgood(Good good) {
        goodList = update();
        goodList.add(good);
        serializeObject(goodList, way);
        saveGood();

    }


    public void deleteGood(Good good) {
        goodList = update();
        goodList.remove(good);
        saveGood();
    }

    @Override
    public List<Good> getAllGood() {
        return null;
    }

    @Override
    public Good findGoodById(int id) {
        return null;
    }

    public List<Good> allGood() {
        goodList= (List<Good>) deserializeObject(way);
        return goodList;
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
