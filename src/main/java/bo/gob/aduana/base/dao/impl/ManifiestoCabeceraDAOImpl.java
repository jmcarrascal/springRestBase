package bo.gob.aduana.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.base.dao.ManifiestoCabeceraDAO;
import bo.gob.aduana.base.model.ManifiestoCabecera;

@Repository
@Transactional
public class ManifiestoCabeceraDAOImpl extends GenericDAOImpl<ManifiestoCabecera> implements ManifiestoCabeceraDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ManifiestoCabeceraDAOImpl() {
		super(ManifiestoCabecera.class);
	}

	}
