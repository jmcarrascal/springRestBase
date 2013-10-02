package bo.gob.aduana.base.dao;

import bo.gob.aduana.base.model.Usuario;




public interface UsuarioDAO extends GenericDAO<Usuario> {

	Usuario getUserbyUserPass(Usuario usuario);
	

	
}
