package com.fillswim.jpa.Introduction;

import com.fillswim.jpa.Introduction.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.persistence.*;
import java.util.List;

public class EmployeeDAO {

    // Сохранение или обновление данных
    public void saveEmployee(Employee employee) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.merge(employee);
            transaction.commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Чтение данных
    public Employee getEmployee(int id) {

        Employee employee = new Employee();

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            employee = entityManager.find(Employee.class, id);
            transaction.commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return employee;
    }

    // Получение всех записей из БД
    public List<Employee> getAllEmployees() {

        List<Employee> employees = null;

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            employees = entityManager.createQuery("from Employee").getResultList();
            transaction.commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return employees;
    }

    // Поиск сотрудника по имени
    public List<Employee> findByName(String findName) {

        List<Employee> employees = null;

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            Query query = entityManager.createQuery("from Employee where name =: name");
            query.setParameter("name", findName);

            employees = query.getResultList();

            transaction.commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return employees;
    }

    // Удаление данных
    public void deleteEmployee(int id) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
            entityManager = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            Query query = entityManager.createQuery("delete from Employee where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();

            transaction.commit();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
