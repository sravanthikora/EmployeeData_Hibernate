package hibernate1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@WebServlet("")
public class applicationservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		application app = new application(0,name,email);
		applicationcontroller con = new applicationcontroller();
		con.insertion();
//		if(i) {
//			resp.sendRedirect("welcome.jsp");
//		}
//		else {
//			resp.sendRedirect("error");
//		}
		
		
	}

}
