package bo.gob.aduana.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.base.dao.PlacaDAO;
import bo.gob.aduana.base.model.Placa;

@Repository
@Transactional
public class PlacaDAOImpl extends GenericDAOImpl<Placa> implements PlacaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public PlacaDAOImpl() {
		super(Placa.class);
	}

	}
