package application;

import java.util.Date;
import model.entities.Department;
import model.entities.Seller;
import model.entities.dao.DaoFactory;
import model.entities.dao.SellerDao;
import model.entities.dao.impl.SellerDaoJDBC;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===== ");

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }

}
