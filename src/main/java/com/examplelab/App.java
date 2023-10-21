package com.examplelab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.examplelab.entity.Passport;
import com.examplelab.entity.Person;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    System.out.println("Connection started");
    Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory factory=cfg.buildSessionFactory();
    Session session=factory.openSession();
    try
    {
  	  Person p1=new Person();
  	  p1.setName("Ram");
  	  p1.setAge(25);
  	  
  	  Passport pa1=new Passport();
  	  pa1.setAddress("DoctorsColony");
  	  
  	  p1.setPassport(pa1);
  	  pa1.setPerson(p1);
  	  
  	  session.beginTransaction();
  	  session.save(p1);
  	  session.getTransaction().commit();
  	  
  	  Person r1=session.get(Person.class, p1.getId());
      Passport r2=r1.getPassport();
      System.out.println("Person: "+r1.getName());
      System.out.println("Passport: "+r2.getAddress());
   }
    catch(Exception e)
    {
  	  e.printStackTrace();
    }
    finally
    {
  	  session.close();
  	  factory.close();
    }
    
    }
}
    
    

