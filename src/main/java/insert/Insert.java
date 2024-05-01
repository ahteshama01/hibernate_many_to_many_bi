package insert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import EntityClass.Student;
import EntityClass.Subject;

public class Insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_many_to_many_bi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student st1=new Student(1,"Rahul",19);
		Student st2=new Student(2,"Prince",20);
		
		
		Subject sub1=new Subject(101,"Physics");
		Subject sub2=new Subject(102,"chemistry");
		Subject sub3=new Subject(103,"Maths");
		Subject sub4=new Subject(104,"Bio");
		
		List<Subject> subjects= new ArrayList<>();
		subjects.add(sub1);
		subjects.add(sub2);
		subjects.add(sub3);
		
		List<Subject> subjects2= new ArrayList<>();
		subjects2.add(sub1);
		subjects2.add(sub2);
		subjects2.add(sub4);
		
		st1.setSubjects(subjects);
		st2.setSubjects(subjects2);
		
		et.begin();
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		em.persist(sub4);
		em.persist(st1);
		em.persist(st2);
		et.commit();
		
		
		
	}
}
