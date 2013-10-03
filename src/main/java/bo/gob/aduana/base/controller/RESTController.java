package bo.gob.aduana.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bo.gob.aduana.base.model.JsonResult;
import bo.gob.aduana.base.model.Usuario;
import bo.gob.aduana.base.services.UsuarioService;


@Controller
@Transactional
public class RESTController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value="/rest/usuario/getAll", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getAll() {		
		List<Usuario> usuarioList = usuarioService.geAll();
		return usuarioList;
	}
	
	//@RequestMapping(method = RequestMethod.POST, value = "value="/stub", consumes = "application/json", produces = "application/json")
	@RequestMapping(value="/rest/usuario/new", method = RequestMethod.POST)
	public @ResponseBody void setNewUser(Usuario usuario) {		
		 usuarioService.newUser(usuario);
	}
	
	@RequestMapping(value="/rest/usuario/validate", method = RequestMethod.POST)
	public @ResponseBody JsonResult validateUser(Usuario usuario) {		
		 return usuarioService.validateUser(usuario);
	}
	
	@RequestMapping(value="/rest/loginOut", method = RequestMethod.GET)
	public @ResponseBody String loginOut() {		
		 return "out";
	}
		
}