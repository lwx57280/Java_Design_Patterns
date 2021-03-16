package com.design.reuse;

public class CopTest {

    public static void main(String[] args) {
        ProductDao productDao=new ProductDao();
        productDao.setConnection(new MySQLConnecton());
        productDao.addProduct();
    }
}
