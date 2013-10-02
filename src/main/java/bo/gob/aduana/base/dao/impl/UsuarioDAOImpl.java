package bo.gob.aduana.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.base.dao.UsuarioDAO;
import bo.gob.aduana.base.model.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	
	public Usuario getUserbyUserPass(Usuario usuarioIn) {
		Usuario usuario = null;
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		if (usuarioIn.getNombreUsuario() != null && !usuarioIn.getNombreUsuario().trim().equals("")  && !usuarioIn.getPassword().trim().equals("")){
			usuarioList = sessionFactory.getCurrentSession()
		.createQuery("select u from Usuario u where u.nombreUsuario = :userName and password = :password")
		.setParameter("userName", usuarioIn.getNombreUsuario())
		.setParameter("password", usuarioIn.getPassword())
		.list();
		}
		if (usuarioList != null && usuarioList.size() > 0){
			usuario = usuarioList.get(0);
		}
		return usuario;

	}

	
}
