package hibernate1;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class applicationcontroller {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			display();
			ch = Integer.parseInt(sc.nextLine());
			
			switch (ch) {
			case 1:
				insertion();
				break;
			case 2:
				deletion();
				break;
			case 3:
				updation();
				break;
			case 4:
				getall();
				break;
			case 5:
				getbyid();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid operation");
				break;
				
			
			}
		} while (ch>0);
	}

	private static void getbyid() {
		Scanner sc = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("enter id");
		int id = sc.nextInt();
		Transaction t = s.beginTransaction();
		application app = s.get(application.class, id);
		if(app!=null) {
			System.out.println("Id :"+app.getId());
			System.out.println("Name : "+app.getName());
			System.out.println("Email :"+app.getEmail());
		}
		else {
			System.out.println("no data available");
		}
		t.commit();
	}

	private static void getall() {
		Scanner sc = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		List<application> li = s.createQuery("from application",application.class).list();
		t.commit();
		for(application app:li) {
			System.out.println("Id : "+app.getId());
			System.out.println("Name : "+app.getName());
			System.out.println("Name : "+app.getEmail());
		}
		
	}

	private static void updation() {
		Scanner sc = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("Enter id ");
		int id = sc.nextInt();
		Transaction t = s.beginTransaction();
		application app = s.get(application.class, id);
		if(app!=null) {
			System.out.println("Enter new name :");
			String name=sc.next();
			app.setName(name);
			System.out.println("Enter new mail :");
			String email=sc.next();
			app.setEmail(email);
			s.update(app);
			t.commit();
			System.out.println("successfully updated");
		}
		else {
			System.out.println("not updtaed");
		}
	}

	private static void deletion() {
		Scanner sc = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("Enter id :");
		int id = sc.nextInt();

		Transaction t = s.beginTransaction();
		application app = s.get(application.class, id);
		
		s.delete(app);
		t.commit();
		System.out.println("successfully deleted");
		
	}

	public static void insertion() {
		Scanner sc = new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		application app = new application();
		
		System.out.println("Enter Name:");
		String name = sc.nextLine();
		app.setName(name);
		
		System.out.println("Enter email:");
		String email = sc.nextLine();
		app.setEmail(email);
		
		s.save(app);
		t.commit();
		System.out.println("Successfully inserted");
		
	}

	private static void display() {
		System.out.println("__________________");
		System.out.println("\t1.insertion");
		System.out.println("\t2.deletion");
		System.out.println("\t3.updation");
		System.out.println("\t4.getall");
		System.out.println("\t5.getbyid");
		System.out.println("\t6.exit");
		
	}

}
