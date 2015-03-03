package br.com.grupomm.dbm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcessoController {
	@RequestMapping(value="/publico/login")
	public String login(Model model) {
		return "login";
	}
}
