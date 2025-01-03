package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.creaseSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        /*System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Mateus", "mateus@gmail.com", new Date(), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido! Novo id = " + newSeller.getId()); */

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Eliza Maciel");
        seller.setEmail("eliza@gmail.com");
        seller.setBaseSalary(4200.0);
        sellerDao.update(seller);
        System.out.println("Atualização completa!");

        System.out.println("\n=== TEST 6: seller delete ===");
        System.out.println("Entre com um ID para o teste: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.print("Funcionário deletado!");


        sc.close();
    }
}
