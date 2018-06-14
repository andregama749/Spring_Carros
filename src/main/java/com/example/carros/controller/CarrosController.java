package com.example.carros.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.carros.model.Carro;
import com.example.carros.repository.Carros;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Controller
@RequestMapping("/carros")
public class CarrosController {

	@Autowired
	private Carros carros;


	@RequestMapping("")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		mv.addObject(new Carro());
		mv.addObject("carros", carros.findAll());
		return (mv);
	}

	@PostMapping
	public String salvar(Carro carro) {
		carros.save(carro);
		return "redirect:/carros";
	}

	@RequestMapping(value ="/excluir/{id}")
	public String excluirCarroByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		this.carros.deleteById(id);
		return "redirect:/carros";
	}
	
	@RequestMapping(value ="/alterar/{id}")
	public ModelAndView alterarCarroByPathVariable(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("ListaCarros");
		Carro carro = (Carro) carros.getOne(id);
		mv.addObject(carro);
		mv.addObject("carros", carros.findAll());
		return (mv);
	}
	
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}

