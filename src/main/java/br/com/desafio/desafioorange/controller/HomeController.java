package br.com.desafio.desafioorange.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafio.desafioorange.dao.UsuariosDao;
import br.com.desafio.desafioorange.model.Usuarios;

@Controller
public class HomeController {
	
	@Autowired
	private UsuariosDao usuariosrepositorio;

	@GetMapping("/")
	public ModelAndView index(Usuarios usuarios) {		
		ModelAndView mv = new ModelAndView();	
		mv.setViewName("redirect:usuarios-adicionados");
		mv.addObject("usuarios", new Usuarios());
		return mv;
	}
	
	@PostMapping("CadastrarUsuarios")
	public ModelAndView cadastrarUsuarios(@Valid Usuarios usuarios, BindingResult result) {
		if(result.hasErrors()) {
			return index(usuarios);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:usuarios-adicionados");
		usuariosrepositorio.save(usuarios);
		return mv;
	}
	
	@GetMapping("usuarios-adicionados")
	public ModelAndView listagemUsuarios(Usuarios usuarios) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("usuariosList", usuariosrepositorio.findAll());
		return mv;
	}
}