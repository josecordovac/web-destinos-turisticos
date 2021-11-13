package pe.gob.mincetur.portaldestinosturisticos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.mincetur.portaldestinosturisticos.repository.DestinoRepository;

@Controller
@RequestMapping("/destinos/")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;	
	
	@GetMapping("list")
	public String destinos(Model model) {
		model.addAttribute("destinos", this.destinoRepository.findAll());
		return "destinos";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(@RequestParam (value = "name", required = false) String name, Model model) {
		model.addAttribute("search", destinoRepository.findByName(name));
        return "busqueda";
	}
}
