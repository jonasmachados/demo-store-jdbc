package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramTestDepartment {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("=== TEST 1 ====");
        Department department = departmentDao.findById(1);
        System.out.println(department);
        
        System.out.println("\n=== TEST 2 ====");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("\n=== TEST 3 ===");
        Department dep = new Department(null, "Book");
        departmentDao.insert(dep);
        System.out.println("Insert! New id: " + dep.getId());
        
        System.out.println("\n=== TEST 4 ====");
        department.setName("English");
        departmentDao.update(department);
        System.out.println("Update completed");
        
        System.out.println("\n=== TEST 5 ====");
        System.out.println("Enter id for delete a department: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
        
        sc.close();
        
        
        
    }
    
}
