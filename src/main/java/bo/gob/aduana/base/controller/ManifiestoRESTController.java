package bo.gob.aduana.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bo.gob.aduana.base.model.Aduana;
import bo.gob.aduana.base.model.ManifiestoCabecera;
import bo.gob.aduana.base.model.Placa;
import bo.gob.aduana.base.services.ManifiestoService;


@Controller
@Transactional
public class ManifiestoRESTController {

	@Autowired
	private ManifiestoService manifiestoService;
	
	
	@RequestMapping(value="/rest/manifiestoCabecera/getAll", method = RequestMethod.GET)
	public @ResponseBody List<ManifiestoCabecera> getAll() {		
		List<ManifiestoCabecera> manifiestoCabeceraList = manifiestoService.geAll();
		return manifiestoCabeceraList ;
	}
	
	@RequestMapping(value="/rest/aduana/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Aduana> getAduanaAll() {		
		List<Aduana> aduanaList = manifiestoService.getAduanaAll();
		return aduanaList;
	}
			
	@RequestMapping(value="/rest/placa/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Placa> getPlacaAll() {		
		List<Placa> placaList = manifiestoService.getPlacaAll();
		return placaList;
	}

	@RequestMapping(value="/rest/manifiesto/new", method = RequestMethod.POST)
	public @ResponseBody void setNewManifiestoCA(ManifiestoCabecera manifiestoCabecera) {		
		manifiestoService.newManifiesto(manifiestoCabecera);
	}
}