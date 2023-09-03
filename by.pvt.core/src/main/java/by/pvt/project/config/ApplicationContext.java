package by.pvt.project.config;

import by.pvt.project.connector.PostgresqlConnector;
import by.pvt.project.mapping.BasketMapping;
import by.pvt.project.mapping.GoodMapping;
import by.pvt.project.mapping.UserMapping;
import by.pvt.project.repository.BD.BasketRepositoryBD;
import by.pvt.project.repository.BD.GoodRepositoryBD;
import by.pvt.project.repository.BD.OrderRepositoryBD;
import by.pvt.project.repository.BD.UserRepositoryBD;
import by.pvt.project.repository.file.BasketRepositoryFile;
import by.pvt.project.repository.file.GoodRepositoryFile;
import by.pvt.project.repository.file.OrderRepositoryFile;
import by.pvt.project.repository.file.UserRepositoryFile;
import by.pvt.project.service.BasketService;
import by.pvt.project.service.GoodService;
import by.pvt.project.service.OrderService;
import by.pvt.project.service.UserService;
import by.pvt.project.service.imp.BasketServerImp;
import by.pvt.project.service.imp.GoodServiceImp;
import by.pvt.project.service.imp.OrderServerImp;
import by.pvt.project.service.imp.UserServerImp;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final BasketRepositoryBD basketRepositoryBD;
    private UserRepositoryBD userRepositoryBD;
    private GoodRepositoryBD goodRepositoryBD;
    private  GoodMapping goodMapping;
    private  UserMapping userMapping;
    private  UserService userService;
    private   GoodService goodService;
    private  BasketService basketService;
    private  BasketMapping basketMapping;
    private OrderRepositoryBD orderRepositoryBD;
    private  OrderService orderService;




    private ApplicationContext() {
        this.userRepositoryBD = new UserRepositoryBD(new PostgresqlConnector());
        this.goodRepositoryBD = new GoodRepositoryBD(new PostgresqlConnector());
        this.goodMapping = new GoodMapping();
        this.userMapping = new UserMapping();
        this.userService =  new UserServerImp(userRepositoryBD,userMapping);
        this.goodService = new GoodServiceImp(goodMapping, goodRepositoryBD);
        this.basketRepositoryBD = new BasketRepositoryBD(new PostgresqlConnector());
        this.basketMapping = new BasketMapping();
        this.basketService = new BasketServerImp(basketRepositoryBD, basketMapping);
        this.orderRepositoryBD =new OrderRepositoryBD(new PostgresqlConnector());
        this.orderService=new OrderServerImp(orderRepositoryBD);
    }
    public static ApplicationContext getInstance(){
        if (applicationContext==null){
            applicationContext=new ApplicationContext();
        }
        return applicationContext;
    }



    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContext.applicationContext = applicationContext;
    }

    public UserRepositoryBD getUserRepositoryBD() {
        return userRepositoryBD;
    }

    public void setUserRepositoryBD(UserRepositoryBD userRepositoryBD) {
        this.userRepositoryBD = userRepositoryBD;
    }

    public GoodRepositoryBD getGoodRepository() {
        return goodRepositoryBD;
    }

    public GoodMapping getGoodMapping() {
        return goodMapping;
    }

    public UserMapping getUserMapping() {
        return userMapping;
    }

    public UserService getUserService() {
        return userService;
    }

    public GoodService getGoodService() {
        return goodService;
    }

    public BasketService getBasketService() {
        return basketService;
    }

    public BasketMapping getBasketMapping() {
        return basketMapping;
    }

    public BasketRepositoryBD getBasketRepositoryBD() {
        return basketRepositoryBD;
    }

    public OrderRepositoryBD getOrderRepositoryBD() {
        return orderRepositoryBD;
    }

    public OrderService getOrderService() {
        return orderService;
    }

}
