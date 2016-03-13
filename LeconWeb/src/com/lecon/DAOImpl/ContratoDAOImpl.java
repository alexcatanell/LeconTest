package com.lecon.DAOImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lecon.Bean.Contrato;
import com.lecon.DAO.ContratoDAO;
import com.lecon.hibernate.util.HibernateUtil;

public class ContratoDAOImpl implements ContratoDAO{
	
	public void saveContrato(Contrato Contrato) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(Contrato);
			transaction.commit();
			System.out.println("Contrato inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Contrato> findAllContratos(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Contrato> list = null;
		try {
			transaction = session.beginTransaction();
			list = session.createQuery("from Contrato").list();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public void deleteContrato(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Contrato where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			Contrato Contrato = (Contrato) query.uniqueResult();
			session.delete(Contrato);
			System.out.println("Contrato records deleted!");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
