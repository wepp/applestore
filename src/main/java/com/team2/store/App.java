package com.team2.store;

import com.team2.store.entities.User;
import com.team2.store.enums.RoleEnum;
import com.team2.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IUserService userService = (IUserService) context.getBean("userService");
        User user = new User();
        user.setLogin("newUser");
        user.setPassword("newPassword");
        user.setRole(RoleEnum.SELLER.getValue());
        userService.addUser(user);
    }
}
