package principal.modelo.dao;

import java.util.List;

import principal.modelo.javabean.Excursion;
/**
 * Interface que define el acceso a datos
 * Proporciona métodos para realizar operaciones CRUD
 * 
 * @author Andres Matabuena
 * @version 1.0
 * @since 2024
 */
public interface ExcursionDao {
	
	/**
	 * Busca excursion por id 
	 * 
	 * @param idExcursion 
	 * @return Excursion si se encuentra o null si no existe 
	 */
	Excursion findById(int idExcursion); 
	
	/**
	 * Devuelve todas las excursiones listadas 
	 * 
	 * @return Una lista de Excursion 
	 */
	List<Excursion> findAll(); 
	
	/** 
	 * Inserta una nueva excursion 
	 * 
	 * @param excursion la excursion a insertar 
	 * @return 1 si se realiza la operacion 0 si no se realiza la insercion
	 */
	int insertOne(Excursion excursion); 
	
	/** 
	 * Actualiza los datos de una excursión existente. 
	 * @param excursion la excursión con los datos actualizados 
	 * @return 1 si se realiza la actualización, 0 si no se realiza 
	 */
	int updateOne(Excursion excursion); 
	
	/** 
	 * Devuelve una lista de excursiones en estado "creado". 
	 * @return una lista de Excursion en estado "creado" 
	 */
	List<Excursion> findByCreados(); 

	/** 
	 * Devuelve una lista de excursiones en estado "terminado". 
	 * 
	 * @return una lista de Excursion en estado "terminado" 
	 */
	List<Excursion> findByTerminados(); 

	/** 
	 * Devuelve una lista de excursiones destacadas. 
	 * 
	 * @return una lista de Excursion destacadas 
	 * */
	List<Excursion> findByDestacados(); 

	/** 
	 * Busca excursiones cuyo origen coincida con la palabra proporcionada. 
	 * 
	 * @param palabra la palabra clave para buscar en el campo de origen 
	 * @return una lista de Excursion que coinciden con el criterio de búsqueda */
	List<Excursion> findByOrigen(String palabra);

	/** Busca excursiones cuyo destino coincida con la palabra proporcionada. 
	 * 
	 * @param palabra la palabra clave para buscar en el campo de destino 
	 * @return una lista de Excursion que coinciden con el criterio de búsqueda */
	List<Excursion> findByDestino(String palabra);

	/** 
	 * Devuelve excursiones con un precio mayor al especificado. 
	 * 
	 * @param precio el precio mínimo a partir del cual se buscarán excursiones 
	 * @return una lista de Excursion que cumplen con el criterio de precio */
	List<Excursion> findByPrecioMayorQue(Double precio);

	/** 
	 * Devuelve excursiones con un precio menor al especificado. 
	 * @param precio el precio máximo hasta el cual se buscarán excursiones 
	 * @return una lista de Excursion que cumplen con el criterio de precio 
	 */
	List<Excursion> findByPrecioMenorQue(Double precio);

	/** 
	 * Devuelve excursiones con precio dentro del rango especificado. 
	 * @param precioMin el precio mínimo del rango @param precioMax el precio máximo del rango 
	 * @return una lista de Excursion que cumplen con el rango de precios especificado 
	 */
	List<Excursion> findByPrecioMinMax(Double precioMin, Double precioMax);
}
