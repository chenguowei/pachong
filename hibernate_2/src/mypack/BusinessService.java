package mypack;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class BusinessService{
  public static SessionFactory sessionFactory;
  static{
     try{
       Configuration config = new Configuration()
                              .configure(); //����hibernate.cfg.xml�ļ������õ���Ϣ
      sessionFactory = config.buildSessionFactory();
    }catch(RuntimeException e){e.printStackTrace();throw e;}
  }

  public Monkey loadMonkey(long monkey_id){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Monkey monkey=(Monkey)session.get(Monkey.class,new Long(monkey_id));
      tx.commit();
      return monkey;
    }catch (RuntimeException e) {
      if (tx != null) {
         tx.rollback();
      }
      throw e;
    } finally {
       session.close();
    }
  }

  public void saveMonkey(Monkey monkey){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      session.save(monkey);
      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
         tx.rollback();
      }
      throw e;
    } finally {
       session.close();
    }
  }

  public void loadAndUpdateMonkey(long monkeyId) {
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      Monkey monkey=(Monkey)session.get(Monkey.class,new Long(monkeyId));
      monkey.setDescription("�¸���η!");
      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
        tx.rollback();
      }
      throw e;
    } finally {
      session.close();
    }
  }

  public void updateMonkey(Monkey monkey){
    Session session = sessionFactory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      session.update(monkey);
      tx.commit();

    }catch (RuntimeException e) {
      if (tx != null) {
         tx.rollback();
      }
      throw e;
    } finally {
       session.close();
    }
  }


  public void printMonkey(Monkey monkey){
    System.out.println("name:"+monkey.getName());
    System.out.println("gender:"+monkey.getGender());
    System.out.println("description:"+monkey.getDescription());
    System.out.println("age:"+monkey.getAge());
    System.out.println("avgAge:"+monkey.getAvgAge());
  }

   public void test(){
      Monkey monkey=new Monkey("���","��",'M',500,"��ͨ���!");
      saveMonkey(monkey);

      monkey=loadMonkey(1);
      printMonkey(monkey);

      monkey.setDescription("�����ʥ!");
      updateMonkey(monkey);

      loadAndUpdateMonkey(1);
   }

  public static void main(String args[]) {
    new BusinessService().test();
    sessionFactory.close();
  }
}
