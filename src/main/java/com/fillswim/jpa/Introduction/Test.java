package com.fillswim.jpa.Introduction;

import com.fillswim.jpa.Introduction.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Создание пользователя в БД
        Employee employee = new Employee("Ivan", "Pavlov", "HR", 700);
        employeeDAO.saveEmployee(employee);

        // Чтение сотрудника из БД
//        Employee employee = employeeDAO.getEmployee(1);
//        System.out.println(employee);

        // Обновление пользователя в БД
//        Employee employee = employeeDAO.getEmployee(3);
//        System.out.println(employee);
//        employee.setSalary(1500);
//        System.out.println(employee);
//        employeeDAO.saveEmployee(employee);

        // Получение всех сотрудников из БД
//        List<Employee> employees = employeeDAO.getAllEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        // Поиск сотрудников по имени
//        List<Employee> employees = employeeDAO.findByName("Nina");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        // Удаление пользователя
//        employeeDAO.deleteEmployee(3);

    }
}
