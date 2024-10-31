package principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import principal.modelo.dao.ExcursionDao;
/**
 * Controlador para manejar las solicitudes de la página de inicio.
 * Se encarga de obtener y mostrar las excursiones en la vista principal.
 * 
 * @author Andres Matabuena
 * @version 1.0
 * @since 2024
 */
@Controller
public class HomeController {
	
	@Autowired
	private ExcursionDao edao; // Inyección para acceder a los datos de excursiones
	
	/**
	 * Maneja la solicitud GET para la página de inicio.
	 * 
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "home" que muestra todas las excursiones
	 */
	@GetMapping("/")
	public String pageHome(Model model) {
		model.addAttribute("excursiones", edao.findAll());
		return "home";
	}
	
}
