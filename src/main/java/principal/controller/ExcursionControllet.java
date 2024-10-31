package principal.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.modelo.dao.ExcursionDao;
import principal.modelo.javabean.Excursion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador que maneja las rutas y solicitudes relacionadas con las excursiones.
 * Permite gestionar operaciones de búsqueda, creación, modificación y cancelación 
 * de excursiones, así como la visualización de detalles específicos.
 * 
 * @author Andres Matabuena
 * @version 1.0
 * @since 2024
 */
@Controller
@RequestMapping("/excursiones")
public class ExcursionControllet {
	
	@Autowired
	private ExcursionDao edao; // Inyección del DAO de Excursiones para gestionar datos

	/** 
	 * Busca excursiones cuyo precio es mayor al especificado.
	 * 
	 * @param precioMayorQue el precio mínimo para la búsqueda
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "busquedaMayorQue" con los resultados de la búsqueda y el precio usado como filtro
	 */
	@PostMapping("/mayorque")
	public String mayorQue(double precioMayorQue, Model model) {
		model.addAttribute("busquedas", edao.findByPrecioMayorQue(precioMayorQue));
		model.addAttribute("mensaje", precioMayorQue);
		
		return "busquedaMayorQue";
	}
	
	/** 
	 * Maneja la solicitud post para buscar excursiones cuyo precio es menor al especificado.
	 * 
	 * @param precioMenorQue el precio máximo para la búsqueda
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "busquedaMenorQue" con los resultados de la búsqueda y el precio usado como filtro
	 */
	@PostMapping("/menorque")
	public String menorQue(double precioMenorQue, Model model) {
	    model.addAttribute("busquedas", edao.findByPrecioMenorQue(precioMenorQue));
	    model.addAttribute("mensaje", precioMenorQue);
	    
		return "busquedaMenorQue";
	}
	
	/** 
	 * Maneja la solicitud post para buscar excursiones dentro de un rango de precios especificado.
	 * 
	 * @param precioMin el precio mínimo del rango
	 * @param precioMax el precio máximo del rango
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "busquedaMinMax" con excursiones en el rango de precios especificado
	 */
	@PostMapping("/preciominmax")
	public String precioMinMax(double precioMin, double precioMax, Model model) {
		model.addAttribute("busquedas", edao.findByPrecioMinMax(precioMin, precioMax)); 
		model.addAttribute("mensajeMin", precioMin);
		model.addAttribute("mensajeMax", precioMax);
		
		return "busquedaMinMax";
	}
	
	/** 
	 * Maneja la solicitud post para buscar excursiones cuyo destino contiene la palabra proporcionada.
	 * 
	 * @param palabraDestino la palabra clave a buscar en el destino
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "busquedaDestino" con los resultados de la búsqueda y el destino usado como filtro
	 */
	@PostMapping("/destino")
	public String porDestino(String palabraDestino, Model model) {
		model.addAttribute("busquedas", edao.findByDestino(palabraDestino));
		model.addAttribute("mensaje", palabraDestino);
		
		return "busquedaDestino";
	}
	
	/** 
	 * Maneja la solicitud post para buscar excursiones cuyo origen contiene la palabra proporcionada.
	 * 
	 * @param palabraOrigen la palabra clave a buscar en el origen
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "busquedaOrigen" con los resultados de la búsqueda y el origen usado como filtro
	 */
	@PostMapping("/origen")
	public String porOrigen(String palabraOrigen, Model model) {
		model.addAttribute("busquedas", edao.findByOrigen(palabraOrigen)); 
		model.addAttribute("mensaje", palabraOrigen);
		
		return "busquedaOrigen";
	}
	
	/** 
	 * Maneja la solitud GET y muestra la vista de opciones de búsqueda.
	 * 
	 * @return la vista "busquedas" que contiene los filtros y opciones de búsqueda de excursiones
	 */
	@GetMapping("/busquedas")
	public String buquedas() {
		return "busquedas";
	}
	
	/** 
	 * Maneja la solicitud GET y muestra las excursiones en estado "TERMINADO".
	 * 
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "terminados" con las excursiones en estado "TERMINADO"
	 */
	@GetMapping("/terminados")
	public String terminados(Model model) {
		model.addAttribute("terminados", edao.findByTerminados());
		
		return "terminados";
	}
	
	/** 
	 * Maneja la solicitud GET y muestra las excursiones en estado "CREADO".
	 * 
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "creados" con las excursiones en estado "CREADO"
	 */
	@GetMapping("/creados")
	public String creados(Model model) {
		model.addAttribute("creados", edao.findByCreados());
		
		return "creados";
	}
	
	/** 
	 * Maneja la solicitud GET y muestra las excursiones destacadas.
	 * 
	 * @param model el modelo para pasar datos a la vista
	 * @return la vista "destacados" con las excursiones destacadas
	 */
	@GetMapping("/destacados")
	public String destacados(Model model) {
		model.addAttribute("destacados", edao.findByDestacados()); 
		
		return "destacados";
	}
	
	/** 
	 * Procesa la creación de una nueva excursión asignándole un ID único.
	 * 
	 * @param excursion el objeto Excursion a insertar
	 * @param ratt atributos de redirección para pasar mensajes entre redirecciones
	 * @return redirección a la página principal con un mensaje indicando si se realizó el alta
	 */
	@PostMapping("/alta")
	public String altaPost(Excursion excursion, RedirectAttributes ratt) {
		int maxId = -1; //inicializamos variable
		for(Excursion ele:edao.findAll()) { //Buscamos el ultimo ID para autoincrementarlo
			if(ele.getIdExcursion() > maxId) {
				maxId = ele.getIdExcursion();
			}
		}
		excursion.setIdExcursion(++maxId); // Asigna un nuevo ID incrementado
		
		if(edao.insertOne(excursion) == 1) {
			ratt.addFlashAttribute("mensaje", "ALTA REALIZADA");
		} else {
			ratt.addFlashAttribute("mensaje", "ALTA NO REALIZADA");
		}
		return "redirect:/";
	}
	
	/** 
	 * Muestra la vista para dar de alta una nueva excursión.
	 * 
	 * @return la vista "alta" que contiene el formulario para crear una nueva excursión
	 */
	@GetMapping("/alta")
	public String alta() {
		return "alta";
	}
	
	/** 
	 * Procesa la modificación de una excursión existente.
	 * 
	 * @param excursion el objeto Excursion con los datos actualizados
	 * @param ratt atributos de redirección para pasar mensajes entre redirecciones
	 * @param idExcursion el ID de la excursión a modificar
	 * @return redirección a la página principal con un mensaje de éxito o error
	 */
	@PostMapping("/modificar/{idExcursion}")
	public String modificarPost(Excursion excursion, RedirectAttributes ratt, @PathVariable int idExcursion) {
		excursion.setIdExcursion(idExcursion);
		
		if(edao.updateOne(excursion) == 1) {
			ratt.addFlashAttribute("mensaje", "PRODUCTO MODIFICADO");
		} else {
			ratt.addFlashAttribute("mensaje", "PRODUCTO NO MODIFICADO");
		}
		
		return "redirect:/";
	}
	
	/** 
	 * Muestra la vista de modificación para una excursión específica.
	 * 
	 * @param model el modelo para pasar datos a la vista
	 * @param idExcursion el ID de la excursión a modificar
	 * @return la vista "modificar" con los datos de la excursión o redirección si no existe
	 */
	@GetMapping("/modificar/{idExcursion}")
	public String modificar(Model model, @PathVariable int idExcursion) {
		Excursion excursion = edao.findById(idExcursion); 
		
		if(excursion == null) {
			model.addAttribute("mensaje", "NO EXISTE");
			return "forward:/"; 
		}
		model.addAttribute("excursion", excursion); 
		
		return "modificar";
	}
	
	/** 
	 * Cambia el estado de una excursión a "CANCELADO" si no lo está ya.
	 * 
	 * @param model el modelo para pasar mensajes a la vista
	 * @param idExcursion el ID de la excursión a cancelar
	 * @return redirección a la página principal con un mensaje de confirmación
	 */
	@GetMapping("/cancelar/{idExcursion}")
	public String cancelar(Model model, @PathVariable int idExcursion) {
		Excursion excursion = edao.findById(idExcursion);
		
		if(!excursion.getEstado().equals("CANCELADO")) {
			excursion.setEstado("CANCELADO"); 
			model.addAttribute("mensaje", "EXCURSION CANCELADA");
		} else 
			model.addAttribute("mensaje", "EXCURSION YA CANCELADA");
		
		return "forward:/";
	}
	
	/** 
	 * Muestra los detalles de una excursión específica.
	 * 
	 * @param model el modelo para pasar los datos a la vista
	 * @param idExcursion el ID de la excursión de la que se mostrarán los detalles
	 * @return la vista "detalle" con la información completa de la excursión
	 */
	@GetMapping("/detalle/{idExcursion}")
	public String detalle(Model model, @PathVariable int idExcursion) {
		Excursion excursion = edao.findById(idExcursion); 
		model.addAttribute("excursion", excursion); 
		
		return "detalle";
	}
}