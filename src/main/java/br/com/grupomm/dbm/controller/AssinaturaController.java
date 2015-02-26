package br.com.grupomm.dbm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssinaturaController {
	
	
	@RequestMapping(value="/")
	public String dashboardAssinaturas(Model model) {
		return "dashboard-assinaturas";
	}
	
}
