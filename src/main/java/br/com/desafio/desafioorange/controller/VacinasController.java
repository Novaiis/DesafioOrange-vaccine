package br.com.desafio.desafioorange.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafio.desafioorange.dao.VacinasDao;
import br.com.desafio.desafioorange.model.Vacinas;

@Controller
public class VacinasController {
	
	@Autowired
	private VacinasDao vacinasrepositorio;
	
	@GetMapping("/vacinas")
	public ModelAndView vacinas(Vacinas vacinas) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:listaVacinas");
		mv.addObject("vacinas", new Vacinas());
		return mv;
	}
	
	@PostMapping("CadastrarVacinas")
	public ModelAndView cadastrarVacina(@Valid Vacinas vacinas, BindingResult result) {
		if(result.hasErrors()) {
			return vacinas(vacinas);
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:listaVacinas");	
		vacinasrepositorio.save(vacinas);
		return mv;		
	}
	
	@GetMapping("listaVacinas")
	public ModelAndView listagemVacinas(Vacinas vacinas) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/vacinas");
		mv.addObject("vacinasList", vacinasrepositorio.findAll());
		return mv;
	}

}
