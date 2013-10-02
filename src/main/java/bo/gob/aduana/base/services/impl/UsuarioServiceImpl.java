package bo.gob.aduana.base.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.aduana.base.dao.UsuarioDAO;
import bo.gob.aduana.base.model.JsonResult;
import bo.gob.aduana.base.model.Usuario;
import bo.gob.aduana.base.services.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public Boolean validateUsuario() {				
		return true;
	}

	@Override
	public List<Usuario> geAll() {		
		return usuarioDAO.getAll();
	}

	@Override
	public void newUser(Usuario usuario) {
		usuarioDAO.save(usuario);	
	}

	
	public JsonResult validateUser(Usuario usuarioIn) {
		JsonResult jsonResult = new JsonResult(false,null);
		Usuario usuario = usuarioDAO.getUserbyUserPass(usuarioIn);
		if (usuario == null){
			jsonResult = new JsonResult(false,"Error en la autenticacion");
		}else{
			jsonResult = new JsonResult(true,"Nombre Usuario: " + usuario.getNombreUsuario());
		}
		return jsonResult;
		
	}
	
}
