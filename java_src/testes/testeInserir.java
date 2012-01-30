package testes;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.Equipamento;
import entity.Municipio;
import entity.Portal;
import entity.UF;

public class TesteInserir {

	public static void main(String[] args) {
//		AnnotationConfiguration config = new AnnotationConfiguration();
//		config.addAnnotatedClass(Equipamento.class)
//			  .addAnnotatedClass(Portal.class)
//			  .addAnnotatedClass(Municipio.class)
//			  .addAnnotatedClass(UF.class);
//		config.configure("hibernate.cfg.xml");
//		
//		new SchemaExport(config).create(true, true);
//		
//		SessionFactory factory = config.buildSessionFactory();
//		Session session = factory.openSession();
		
		Session session = HibernateUtil.getInstance().getSession();
		
		session.beginTransaction();
		
		UF uf1 = new UF();
		uf1.setNome("Rio De Janeiro");
		uf1.setSigla("RJ");
		session.save(uf1);
		
		Municipio m1 = new Municipio();
		m1.setNome("Rio de Janeiro");
		m1.setUf(uf1);
		session.save(m1);
		
		Portal p1 = new Portal();
		p1.setAltitude(0.0);
		p1.setLatitude(1.0);
		p1.setLongitude(2.0);
		p1.setNome("Antena Testanto HibernateUtils");
		p1.setMunicipio(m1);
		session.save(p1);
		
		System.out.println("Equipamentos de p1 logo após o SAVE: " + p1.getEquipamento());
		session.refresh(p1);
		System.out.println("Equipamentos de p1 logo após o REFRESH " + p1.getEquipamento());
		
		Equipamento e1 = new Equipamento();
		e1.setNome("A1Eqp1");
//		e1.setOrdem(1);
//		e1.setStatus(1);
		e1.setPortal(p1);
		session.save(e1);
		
		Equipamento e2 = new Equipamento();
		e2.setNome("A1Eqp2");
//		e2.setOrdem(2);
//		e2.setStatus(1);
		e2.setPortal(p1);
		session.save(e2);

		
		Portal p2 = new Portal();
		
		Equipamento e3 = new Equipamento();
		e3.setNome("Equipamento via List");
		e3.setPortal(p2);
		List<Equipamento> equipamentos = new ArrayList<Equipamento>();
		equipamentos.add(e3);
		
		p2.setNome("Antena2");
		p2.setMunicipio(m1);
		p2.setEquipamento(equipamentos);
		session.save(p2);

		
		session.getTransaction().commit();
		
		session.close();
		
//		session = factory.openSession();
//		
//		List<Portal> portais = session.createQuery("from Portal").list();
//		System.out.println(portais.get(1).getEquipamento().get(0).getNome());
	}

}
