
package application;
import java.util.Date;
import model.entities.Department;
import model.entities.Seller;
import model.entities.dao.DaoFactory;
import model.entities.dao.SellerDao;
import model.entities.dao.impl.SellerDaoJDBC;

public class Program {

  
    public static void main(String[] args) {
        
        Department department = new Department(1, "Book");
        
        Seller seller = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, department);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println(seller);
    }
    
}
