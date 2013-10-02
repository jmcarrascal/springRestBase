package bo.gob.aduana.base.services;

import java.util.List;

import bo.gob.aduana.base.model.JsonResult;
import bo.gob.aduana.base.model.Usuario;





public interface UsuarioService {

	public Boolean validateUsuario();

	public List<Usuario> geAll();

	public void newUser(Usuario usuario);

	public JsonResult validateUser(Usuario usuarioIn);

}
