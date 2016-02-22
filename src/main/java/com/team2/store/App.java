package com.team2.store;

import com.team2.store.entities.Product;
import com.team2.store.entities.User;
import com.team2.store.enums.RoleEnum;
import com.team2.store.service.IProductService;
import com.team2.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {

        IProductService productService = (IProductService) Constants.context.getBean("productService");
//        IUserService userService = (IUserService) context.getBean("userService");
//        User user = new User();
//        user.setLogin("newUser");
//        user.setPassword("newPassword");
//        user.setRole(RoleEnum.SELLER.getValue());
//        userService.addUser(user);
//        Product pr = productService.getProductById(1);
//        System.out.println(pr);
//        productService.addOneProduct(pr);

        Product pr1 = new Product();
        pr1.setProductName("added");
        pr1.setCount(100);
        productService.addNewProduct(pr1);

    }
}
