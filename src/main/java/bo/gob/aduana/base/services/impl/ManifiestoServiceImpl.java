package bo.gob.aduana.base.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.base.dao.AduanaDAO;
import bo.gob.aduana.base.dao.ManifiestoCabeceraDAO;
import bo.gob.aduana.base.dao.PlacaDAO;
import bo.gob.aduana.base.model.Aduana;
import bo.gob.aduana.base.model.ManifiestoCabecera;
import bo.gob.aduana.base.model.Placa;
import bo.gob.aduana.base.services.ManifiestoService;


@Service
public class ManifiestoServiceImpl implements ManifiestoService{

	
	@Autowired
	private ManifiestoCabeceraDAO manifiestoCabeceraDAO;

	@Autowired
	private AduanaDAO aduanaDAO;

	@Autowired
	private PlacaDAO placaDAO;

	
	@Override
	public List<ManifiestoCabecera> geAll() {
		
		return manifiestoCabeceraDAO.getAll();
	}

	@Override
	public void newManifiesto(ManifiestoCabecera manifiestoCabecera) {		
		manifiestoCabeceraDAO.save(manifiestoCabecera);
	}

	@Override
	public List<Aduana> getAduanaAll() {		
		return aduanaDAO.getAll();
	}

	@Override
	public List<Placa> getPlacaAll() {		
		return placaDAO.getAll();
	}
	
	
	
}
