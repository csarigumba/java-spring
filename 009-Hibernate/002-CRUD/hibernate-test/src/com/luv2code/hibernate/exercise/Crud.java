package com.luv2code.hibernate.exercise;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class Crud {
	
	private static SessionFactory factory;

	public static void main(String[] args) {

		// create session factory
		factory = new Configuration().configure("hibernate.cfg.exercise.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			save(session);
			get(session);
			findByCompany(session);
			delete(session);
		} finally {
			factory.close();
		}
	}

	private static void delete(Session session) {
		System.out.println("Delete.");
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		final Integer recordToDelete = 1;
		
		Employee deleteEmp = session.get(Employee.class, 1);
		
		session.delete(deleteEmp);
		
		session.getTransaction().commit();
		
	}

	private static void findByCompany(Session session) {
		System.out.println("Find by query.");
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Employee> empList = session.createQuery("from Employee e WHERE e.company LIKE 'acn'").getResultList();
		displayEmployees(empList);

		session.getTransaction().commit();
	}

	private static final void save(Session session) {
		System.out.println("Saving to employee table!");
		Employee employee = new Employee("test", "test", "acn");
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	private static final void get(Session session) {
		System.out.println("Retrieving from employee table!");
		final Integer id = 1;
		session = factory.getCurrentSession();
		session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		session.getTransaction().commit();
		
		System.out.println("Retrieve: " + e.toString());
	}
	
	private static void displayEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
