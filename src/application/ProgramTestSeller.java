package application;

import db.DbException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.entities.Department;
import model.entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class ProgramTestSeller {

    public static void main(String[] args) {

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller findById ===== ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller findByDepartment ===== ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll =====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4 ====");
        try {
            Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", formatador.parse("19/01/1985"), 4000.0, department);
            sellerDao.insert(newSeller);
            System.out.println("Insert! New id = " + newSeller.getId());
        } catch (ParseException e) {
            throw new DbException("Error to insert, birthdate incorrect");
        }

        System.out.println("\n=== TEST 5 ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6 ====");
        System.out.println("Enter id for delete teste: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }

}
