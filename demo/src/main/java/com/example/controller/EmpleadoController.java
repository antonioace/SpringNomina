package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exame.servicesImp.EmpleadoServiceImp;
import com.example.model.Empleado;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoServiceImp empleadoService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", empleadoService.getAll());
		return "index";

	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") String id, Model model) {
		if (id != null  ) {
			model.addAttribute("empelado", empleadoService.get(id));
		}
		return "save";

	}

	@PostMapping("/save")
	public String save(Empleado empleado, Model model) {
		empleadoService.save(empleado);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		empleadoService.delete(id);
		return "redirect:/";
	}
	public static void main(String[] args) {
		 EmpleadoServiceImp empleadoServic=new EmpleadoServiceImp();
		System.out.println(empleadoServic.getAll());
	}

}
