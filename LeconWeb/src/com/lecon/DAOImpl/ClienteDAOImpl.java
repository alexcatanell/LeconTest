package com.lecon.DAOImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lecon.Bean.Cliente;
import com.lecon.Bean.Contrato;
import com.lecon.Bean.Servico;
import com.lecon.DAO.ClienteDAO;
import com.lecon.hibernate.util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO{
	
	public void saveCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			System.out.println("Cliente inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> findAllCliente(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Cliente> list = null;
		try {
			transaction = session.beginTransaction();
			list = session.createQuery("from Cliente").list();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public Cliente findClienteById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Cliente cliente = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Cliente where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			cliente = (Cliente) query.uniqueResult();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cliente;
	}

	public void deleteCliente(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryString = "from Cliente where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			Cliente cliente = (Cliente) query.uniqueResult();
			session.delete(cliente);
			System.out.println("Cliente records deleted!");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> findServicosCliente(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Servico> list = new ArrayList<Servico>();
		Calendar cal1 = new GregorianCalendar();
	    Calendar cal2 = new GregorianCalendar();
	    
		try {
			transaction = session.beginTransaction();
			String queryString = "from Contrato where Cliente.id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			List<Contrato> listContrato = query.list();
			for(Contrato c : listContrato){
				Servico service = c.getServico();

			    cal1.setTime(new Date());
			    cal2.setTime(c.getDtFim());
				service.setDaysLeft(daysBetween(cal1.getTime(),cal2.getTime())+1);
				float desconto = 0;
				if(c.getCliente().getClasse()==1){
					desconto = (float) (desconto+0.1);
				}
				else if(c.getCliente().getClasse()==2){
					desconto = (float) (desconto+0.05);
				}
				if(service.getDaysLeft()>=10){
					desconto = (float) (desconto+0.05);
				}

				service.setValorDesconto((float) (service.getValor()-(desconto*service.getValor())));
				list.add(service);
			}
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

}
