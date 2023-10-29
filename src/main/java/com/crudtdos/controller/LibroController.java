package com.crudtdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudtdos.model.Libros;
import com.crudtdos.repository.IAutoresRepository;
import com.crudtdos.repository.IGeneroRepository;
import com.crudtdos.repository.ILibrosRepository;


@Controller
public class LibroController {
	
	@Autowired
	private IAutoresRepository repoAutores;
	@Autowired
	private IGeneroRepository repoGeneros;
	@Autowired
	private ILibrosRepository repoLibros;
	
	@GetMapping("/listaLibros")
	public String redirectListApe(Model model) {

		model.addAttribute("lstAutores", repoAutores.findAll());
		model.addAttribute("lstGeneros", repoGeneros.findAll());
		model.addAttribute("lstLibros", repoLibros.findAll());
		model.addAttribute("libro", new Libros());
		
		return "listadoApellido";
	}
	
	@GetMapping("/cargaVista")
	public String cargaListado(Model model) {

		model.addAttribute("lstAutores", repoAutores.findAll());
		model.addAttribute("lstGeneros", repoGeneros.findAll());
		model.addAttribute("libro", new Libros());
		
		return "listadoApellido";
	}
	
	@GetMapping("/actualizarLibro/{cod_libro}")
	public String actualizarLibros(Model model,
			@PathVariable Integer cod_libro) {
		Libros l = repoLibros.findById(cod_libro).get();
		model.addAttribute("libro", l);
		System.out.println(l);
		
		model.addAttribute("lstAutores", repoAutores.findAll());
		model.addAttribute("lstGeneros", repoGeneros.findAll());
		model.addAttribute("lstLibros", repoLibros.findAll());
		
		return "listadoApellido";
	}
	@PostMapping("/grabar")
	public String crudCrear(@ModelAttribute Libros libro, Model model) {
		try {
			repoLibros.save(libro);
			model.addAttribute("mensaje", "Grabacion Correcta: ");
			model.addAttribute("cssmensaje", "alert alert-success");
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
			model.addAttribute("mensaje", "Error en el guardado");
			model.addAttribute("cssmensaje", "alert alert-danger");
		}
		return "redirect:/listadoApellido";
	}
	
}
