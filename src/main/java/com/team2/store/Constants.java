package com.team2.store;

import com.team2.store.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Isaiev on 22.02.2016.
 */
public class Constants {
    public static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    public static User currentUser = null;
}
