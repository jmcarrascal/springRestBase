package bo.gob.aduana.base.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import bo.gob.aduana.base.dao.GenericDAO;
import bo.gob.aduana.base.util.exception.DataAccessDPIv1Exception;




/**
 * @author Juan Manuel Carrascal
 * @version 1.0
 * @created 12-Jan-2010 11:19:57 AM
 */

public class GenericDAOImpl<T> implements
		GenericDAO<T> {
	 
	private Class<T> objectType;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	

	public GenericDAOImpl() {
		super();
	}

	public GenericDAOImpl(Class<T> objectType) {
		this.objectType = objectType;
	}

	/*
	 * Realiza una consulta por los valores que esten seteados en el objetos,
	 * like y sin importar las mayusculas
	 */
	// @Transactional
	@SuppressWarnings("unchecked")
	public List<T> findByObjectCriteria(T object)
			throws DataAccessDPIv1Exception {
		List<T> result = new ArrayList<T>();
		try {
			Example example = Example.create(object).enableLike();
			result = sessionFactory.getCurrentSession().createCriteria(objectType).add(example)
					.list();

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
		return result;

	}

	@SuppressWarnings("unchecked")
	public List<T> findByObjectCriteria(HashMap<String, Object> res)
			throws DataAccessDPIv1Exception {
		List<T> result = new ArrayList<T>();
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(objectType);
			for (Iterator iter = res.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				criteria.add(Restrictions.eq(name, res.get(name)));
			}
			result = criteria.list();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() throws DataAccessDPIv1Exception {
		try {
			return sessionFactory.getCurrentSession().createCriteria(objectType).list();
					//"from " + objectType.getSimpleName());

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
	}

	@SuppressWarnings("unchecked")
	public T getByPrimaryKey(Long id) throws DataAccessDPIv1Exception {
		T returnValue = null;
		try {

			returnValue = (T) sessionFactory.getCurrentSession().get(objectType.getName(),
					id);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	public T getByPrimaryKey(Integer id) throws DataAccessDPIv1Exception {
		T returnValue = null;
		try {

			returnValue = (T) sessionFactory.getCurrentSession().get(objectType.getName(),
					id);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	public T getByPrimaryKey(String id) throws DataAccessDPIv1Exception {
		T returnValue = null;
		try {

			returnValue = (T) sessionFactory.getCurrentSession().get(objectType.getName(),
					id);

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.GET_ERROR, e);
		}
		return returnValue;
	}

	public void remove(T persistenceInstance) throws DataAccessDPIv1Exception {
		try {

			this.sessionFactory.getCurrentSession().setFlushMode(FlushMode.COMMIT);
			sessionFactory.getCurrentSession().delete(persistenceInstance);
			this.sessionFactory.getCurrentSession().flush();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.DELETE_ERROR, e);
		}
	}

	public void save(T newInstance) throws DataAccessDPIv1Exception {
		try {
//			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().save(newInstance);
//			sessionFactory.getCurrentSession().flush();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.SAVE_ERROR, e);
		}
	}

	public void update(T persistenceInstance) throws RuntimeException {
		try {
			this.sessionFactory.getCurrentSession().setFlushMode(FlushMode.COMMIT);
			sessionFactory.getCurrentSession().update(persistenceInstance);
			this.sessionFactory.getCurrentSession().setFlushMode(FlushMode.COMMIT);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.UPDATE_ERROR, e);
		}
	}

	
	
	public void saveOrUpdate(T newInstance) throws DataAccessDPIv1Exception {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(newInstance);
			sessionFactory.getCurrentSession().flush();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessDPIv1Exception(
					DataAccessDPIv1Exception.SAVE_ERROR, e);
		}
	}

	

}
