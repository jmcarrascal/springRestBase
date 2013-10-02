package bo.gob.aduana.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.base.dao.AduanaDAO;
import bo.gob.aduana.base.model.Aduana;

@Repository
@Transactional
public class AduanaDAOImpl extends GenericDAOImpl<Aduana> implements AduanaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public AduanaDAOImpl() {
		super(Aduana.class);
	}

	
	
}
