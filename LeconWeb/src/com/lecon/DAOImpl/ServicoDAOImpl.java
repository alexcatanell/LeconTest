package com.lecon.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lecon.Bean.Servico;
import com.lecon.DAO.ServicosDAO;
import com.lecon.hibernate.util.HibernateUtil;

public class ServicoDAOImpl implements ServicosDAO{
	
	public void saveServico(Servico servico) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(servico);
			transaction.commit();
			System.out.println("Servico inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Servico> findAllServicos(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Servico> list = null;
		try {
			transaction = session.beginTransaction();
			list = session.createQuery("from Servico").list();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public Servico findServicosById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Servico servico = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Servico where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			servico = (Servico) query.uniqueResult();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return servico;
	}

	public void deleteServico(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Servico where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			Servico servico = (Servico) query.uniqueResult();
			session.delete(servico);
			System.out.println("Servico records deleted!");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
