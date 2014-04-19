package com.ktds.isc.repo;

// Generated 2014. 4. 16 ?? 4:00:44 by Hibernate Tools 4.0.0

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.ktds.isc.domain.Requestofdeletingsmartsheet;
import com.ktds.isc.domain.User;
import com.ktds.isc.util.GenericUtil;
import com.ktds.isc.util.HbUtil;

/**
 * Home object for domain model class Requestofdeletingsmartsheet.
 * @see com.ktds.isc.domain.Requestofdeletingsmartsheet
 * @author Hibernate Tools
 */
@Repository("requestofdeletingsmartsheetHome")
public class RequestofdeletingsmartsheetHome {

	private static final Logger log = LoggerFactory.getLogger(RequestofdeletingsmartsheetHome.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;// = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return HbUtil.getSessionFactory("java:jboss/hibernate/isc/SessionFactory", this.getClass());
	}

	@Transactional
	public void persist(Requestofdeletingsmartsheet transientInstance) {
		log.debug("persisting Requestofdeletingsmartsheet instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw re;
		}
	}

	@Transactional
	public void attachDirty(Requestofdeletingsmartsheet instance) {
		log.info("attaching dirty Requestofdeletingsmartsheet instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Requestofdeletingsmartsheet sheet = instance;
//			long now = System.currentTimeMillis();
//			Date date = new Date(now);
//			sheet.setModifieddate(date);
			sheet.setUser(new User("82022193", "----"));
			session.saveOrUpdate(sheet);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public void attachClean(Requestofdeletingsmartsheet instance) {
		log.debug("attaching clean Requestofdeletingsmartsheet instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw re;
		}
	}

	@Transactional
	public void delete(Requestofdeletingsmartsheet persistentInstance) {
		log.debug("deleting Requestofdeletingsmartsheet instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw re;
		}
	}

	@Transactional
	public Requestofdeletingsmartsheet merge(Requestofdeletingsmartsheet detachedInstance) {
		log.debug("merging Requestofdeletingsmartsheet instance");
		try {
			Requestofdeletingsmartsheet result = (Requestofdeletingsmartsheet) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw re;
		}
	}

	public Requestofdeletingsmartsheet findById(long id) {
		log.debug("getting Requestofdeletingsmartsheet instance with id: " + id);
		try {
			Requestofdeletingsmartsheet instance = (Requestofdeletingsmartsheet) sessionFactory.getCurrentSession()
					.get("com.ktds.isc.domain.Requestofdeletingsmartsheet", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			}
			else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Requestofdeletingsmartsheet> findByExample(Requestofdeletingsmartsheet instance) {
		log.debug("finding Requestofdeletingsmartsheet instance by example");
		try {
			List<Requestofdeletingsmartsheet> results = GenericUtil.castList(Requestofdeletingsmartsheet.class, 
					sessionFactory.getCurrentSession()
					.createCriteria("com.ktds.isc.domain.Requestofdeletingsmartsheet")
					.add(Example.create(instance))
					.list());
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@Transactional
	public List<Requestofdeletingsmartsheet> findAll() {
		log.info("finding Requestofdeletingsmartsheet instance by example");
		try {
			List<Requestofdeletingsmartsheet> results = GenericUtil.castList(Requestofdeletingsmartsheet.class, 
					sessionFactory.getCurrentSession()
					.createCriteria("com.ktds.isc.domain.Requestofdeletingsmartsheet")
					.list());
			log.info("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	@Transactional
	public List<Requestofdeletingsmartsheet> findAllSortedDesc() {
		log.debug("finding Requestofdeletingsmartsheet instance by example");
		try {
			List<Requestofdeletingsmartsheet> results = GenericUtil.castList(Requestofdeletingsmartsheet.class, 
					sessionFactory.getCurrentSession()
					.createCriteria("com.ktds.isc.domain.Requestofdeletingsmartsheet")
					.addOrder(Order.desc("id"))
					.list());
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}