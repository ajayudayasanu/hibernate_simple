package com.ajaypackage.hibernatetest;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajaypackage.hibernate.UserDetails;

public class hibernatetest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserid(3);
		user.setUsername("ajay4");
		user.setAddress("udayasanu4");
		user.setJoiningDate(new Date());
		user.setDescription("it is my description2");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		user =null;
		session= sessionfactory.openSession();
		session.beginTransaction();
		user= (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("the user name is:"+ user.getUsername());
		System.out.println("user id:"+user.getUserid());
		session.getTransaction().commit();
		session.close();
	
	}

}
