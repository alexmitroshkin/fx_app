package controller;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.logging.StreamHandler;

/**
 * Created by alex on 19.08.2016.
 */
public class ManageEmployee {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee ME = new ManageEmployee();

//      /* Add few employee records in database */
//        Integer empID1 = ME.addEmployee("Alex", "Popova str.", 25, 95, 178, 1, "89236651234", "alex@rambler.ru");
//        Integer empID2 = ME.addEmployee("Petr", "Stroitelei str.", 25, 90, 180, 1, "89236651235", "petr@rambler.ru");
//        Integer empID3 = ME.addEmployee("Sergei", "Nemesiseiova str.", 25, 100, 185, 1, "89236651236", "sergei@rambler.ru");
//      /* Delete an employee from the database */
//      /* List down new list of the employees */
//        ME.listEmployees();
    }
    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String name, String address, int age, int weight, int height, int sex, String phoneNumber, String email){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Client client = new Client(name, address, age, weight, height, sex, phoneNumber, email);
            employeeID = (Integer) session.save(client);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to  READ all the employees */
    public ObservableList<Client> listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        ObservableList<Client> data = new ImmutableObservableList<Client>();
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Client").list();

            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Client employee = (Client) iterator.next();
                data.add(employee);
//                System.out.println("id: " + employee.getClientId());
//                System.out.println("ФИО: " + employee.getName());
//                System.out.println("Адрес: " + employee.getAddress());
//                System.out.println("Возраст: " + employee.getAge());
//                System.out.println("Вес: " + employee.getWeight());
//                System.out.println("Рост: " + employee.getHeight());
//                System.out.println("Пол: " + employee.getSex());
//                System.out.println("Номер телефона: " + employee.getPhoneNumber());
//                System.out.println("email: " + employee.getEmail());
//                System.out.println();
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return data;
    }
    /* Method to UPDATE salary for an employee */
//    public void updateEmployee(int ID, String fio, String address, int age, ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Client employee =
//                    (Client) session.get(Client.class, ID);
//            employee.setSalary( salary );
//            session.update(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer id){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Client employee =
                    (Client) session.get(Client.class, id);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
