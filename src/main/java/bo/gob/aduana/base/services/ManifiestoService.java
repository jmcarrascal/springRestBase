package bo.gob.aduana.base.services;

import java.util.List;

import bo.gob.aduana.base.model.Aduana;
import bo.gob.aduana.base.model.ManifiestoCabecera;
import bo.gob.aduana.base.model.Placa;





public interface ManifiestoService {


	public List<ManifiestoCabecera> geAll();

	public void newManifiesto(ManifiestoCabecera manifiestoCabecera);

	public List<Aduana> getAduanaAll();

	public List<Placa> getPlacaAll();

	public ManifiestoCabecera getManifiestoCAByKey(Long idManifesto);


}
