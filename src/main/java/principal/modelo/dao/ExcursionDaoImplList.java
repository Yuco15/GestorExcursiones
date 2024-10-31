package principal.modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import principal.modelo.javabean.Excursion;

/**
 * Implementación de la interfaz ExcursionDao que utiliza una lista como almacenamiento en memoria
 * para gestionar excursiones. Proporciona métodos para realizar operaciones CRUD y consultas
 * basadas en diferentes criterios, como estado, origen, destino y precio.
 * 
 * @author Andres Matabuena
 * @version 1.0
 * @since 2024
 */
@Repository
public class ExcursionDaoImplList implements ExcursionDao{
	
	private List<Excursion> lista;  // Lista de excursiones en memoria
	
	/** 
     * Carga una lista inicial de excursiones para pruebas de funcionalidad.
     * Este método simula una carga de datos en memoria.
     */
	private void cargarDatos() {
		lista.add(new Excursion(1, "Viaje para conocer las maravillas de Orense", "Madrid", "Orense", LocalDate.of(2024, 12, 01), 3, "CREADO", "S", 180, 60, 250, null, LocalDate.of(2024, 9, 01)));
		lista.add(new Excursion(2, "Excursion a la Costa Brava", "Barcelona", "Costa Brava", LocalDate.of(2024, 11, 15), 2, "CREADO", "N", 150, 50, 200, null, LocalDate.of(2024, 9, 10)));
		lista.add(new Excursion(3, "Ruta por los Picos de Europa", "Oviedo", "Picos de Europa", LocalDate.of(2023, 5, 10), 5, "TERMINADO", "S", 100, 40, 300, null, LocalDate.of(2024, 10, 15)));
		lista.add(new Excursion(4, "Descubre la Alhambra", "Madrid", "Granada", LocalDate.of(2024, 12, 25), 4, "CANCELADO", "S", 120, 45, 180, null, LocalDate.of(2024, 8, 22)));
		lista.add(new Excursion(5, "Viaje cultural a Santiago de Compostela", "Bilbao", "Santiago de Compostela", LocalDate.of(2022, 3, 20), 3, "TERMINADO", "N", 200, 70, 220, null, LocalDate.of(2024, 11, 01)));
		lista.add(new Excursion(6, "Aventura en los Pirineos", "Zaragoza", "Pirineos", LocalDate.of(2023, 7, 10), 7, "TERMINADO", "S", 80, 30, 400, null, LocalDate.of(2024, 7, 15)));
		lista.add(new Excursion(7, "Tour por la Ruta del Vino de La Rioja", "Logroño", "La Rioja", LocalDate.of(2025, 4, 18), 2, "CANCELADO", "N", 140, 50, 150, null, LocalDate.of(2024, 9, 18)));
		lista.add(new Excursion(8, "Exploracion del Parque Nacional de Doñana", "Sevilla", "Doñana", LocalDate.of(2024, 11, 10), 3, "CREADO", "S", 90, 40, 150, null, LocalDate.of(2024, 9, 25)));
		lista.add(new Excursion(9, "Viaje a las Cuevas del Drach", "Palma", "Cuevas del Drach", LocalDate.of(2023, 9, 5), 1, "TERMINADO", "N", 80, 30, 120, null, LocalDate.of(2024, 9, 1)));
		lista.add(new Excursion(10, "Ruta de senderismo en el Teide", "Santa Cruz de Tenerife", "Teide", LocalDate.of(2025, 2, 28), 4, "CREADO", "S", 70, 25, 300, null, LocalDate.of(2024, 10, 15)));
		lista.add(new Excursion(11, "Tour histórico en Toledo", "Madrid", "Toledo", LocalDate.of(2023, 6, 15), 1, "TERMINADO", "N", 120, 50, 90, null, LocalDate.of(2024, 9, 20)));
		lista.add(new Excursion(12, "Escapada a las playas de Fuerteventura", "Las Palmas", "Fuerteventura", LocalDate.of(2024, 12, 5), 5, "CANCELADO", "S", 150, 60, 250, null, LocalDate.of(2024, 8, 30)));
		lista.add(new Excursion(13, "Paseo en globo en Segovia", "Segovia", "Segovia", LocalDate.of(2023, 4, 10), 1, "TERMINADO", "S", 60, 20, 180, null, LocalDate.of(2024, 8, 10)));
		lista.add(new Excursion(14, "Descubre el Camino de Santiago", "Pamplona", "Santiago de Compostela", LocalDate.of(2025, 8, 15), 10, "CREADO", "N", 250, 100, 800, null, LocalDate.of(2024, 9, 10)));
		lista.add(new Excursion(15, "Crucero por las Islas Baleares", "Valencia", "Ibiza", LocalDate.of(2022, 8, 20), 7, "TERMINADO", "S", 300, 120, 500, null, LocalDate.of(2024, 10, 1)));
		lista.add(new Excursion(16, "Viaje inolvidable a la Costa del Sol", "Sevilla", "Costa del Sol", LocalDate.of(2024, 11, 25), 3, "CREADO", "S", 180, 60, 260, null, LocalDate.of(2024, 10, 1)));
		lista.add(new Excursion(17, "Ruta de aventura en los Pirineos", "Barcelona", "Pirineos", LocalDate.of(2025, 3, 22), 5, "CREADO", "S", 90, 35, 250, null, LocalDate.of(2024, 11, 15)));
		lista.add(new Excursion(18, "Ruta de exploración por La Rioja", "Bilbao", "La Rioja", LocalDate.of(2024, 8, 15), 2, "CREADO", "N", 140, 50, 200, null, LocalDate.of(2024, 7, 10)));
	}
	
	/** 
     * Constructor que inicializa la lista y carga los datos de ejemplo.
     */
    public ExcursionDaoImplList() {
        lista = new ArrayList<>();
        cargarDatos();
    }

    /** 
     * Busca una excursión por su ID.
     * 
     * @param idExcursion el identificador único de la excursión
     * @return la Excursion correspondiente si se encuentra, o null si no existe
     */
    @Override
    public Excursion findById(int idExcursion) {
        Excursion excursion = new Excursion();
        excursion.setIdExcursion(idExcursion);
        int pos = lista.indexOf(excursion);
        
        if (pos != -1) {
            return lista.get(pos);
        }
        return null;
    }

    /** 
     * Recupera todas las excursiones disponibles en la lista.
     * 
     * @return una lista con todas las excursiones
     */
    @Override
    public List<Excursion> findAll() {
        return lista;
    }

    /** 
     * Inserta una nueva excursión en la lista si no existe ya.
     * 
     * @param excursion la nueva excursión a insertar
     * @return 1 si la operación es exitosa, 0 si la excursión ya existe
     */
    @Override
    public int insertOne(Excursion excursion) {
        if (lista.contains(excursion)) {
            return 0;
        }
        return lista.add(excursion) ? 1 : 0;
    }


    /** 
     * Actualiza los datos de una excursión existente en la lista.
     * 
     * @param excursion la excursión con los datos actualizados
     * @return 1 si la actualización se realiza, 0 si la excursión no existe en la lista
     */
    @Override
    public int updateOne(Excursion excursion) {
        int pos = lista.indexOf(excursion);
        
        if (pos != -1) {
            lista.set(pos, excursion);
            return 1;
        }
        return 0;
    }

    /** 
     * Obtiene una lista de todas las excursiones en estado "CREADO".
     * 
     * @return una lista de Excursion en estado "CREADO"
     */
    @Override
    public List<Excursion> findByCreados() {
        List<Excursion> listaCreados = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getEstado().equals("CREADO")) {
                listaCreados.add(ele);
            }
        }
        return listaCreados;
    }

    /** 
     * Obtiene una lista de todas las excursiones en estado "TERMINADO".
     * 
     * @return una lista de Excursion en estado "TERMINADO"
     */
    @Override
    public List<Excursion> findByTerminados() {
        List<Excursion> listaTerminados = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getEstado().equals("TERMINADO")) {
                listaTerminados.add(ele);
            }
        }
        return listaTerminados;
    }

    /** 
     * Obtiene una lista de todas las excursiones destacadas (marcadas como "S").
     * 
     * @return una lista de Excursion destacadas
     */
    @Override
    public List<Excursion> findByDestacados() {
        List<Excursion> listaDestacados = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getDestacado().equals("S")) {
                listaDestacados.add(ele);
            }
        }
        return listaDestacados;
    }

    /** 
     * Busca excursiones cuyo origen contenga una palabra clave específica.
     * 
     * @param palabra palabra clave para buscar en el campo origen
     * @return una lista de Excursion que coinciden con el origen especificado
     */
    @Override
    public List<Excursion> findByOrigen(String palabra) {
        List<Excursion> listaPalabraOrigen = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getDescripcion().toLowerCase().startsWith(palabra.toLowerCase())) {
                listaPalabraOrigen.add(ele);
            }
        }
        return listaPalabraOrigen;
    }

    /** 
     * Busca excursiones cuyo destino contenga una palabra clave específica.
     * 
     * @param palabra palabra clave para buscar en el campo destino
     * @return una lista de Excursion que coinciden con el destino especificado
     */
    @Override
    public List<Excursion> findByDestino(String palabra) {
        List<Excursion> listaPalabraDestino = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getDescripcion().toLowerCase().endsWith(palabra.toLowerCase())) {
                listaPalabraDestino.add(ele);
            }
        }
        return listaPalabraDestino;
    }

    /** 
     * Obtiene una lista de excursiones cuyo precio es mayor que el especificado.
     * 
     * @param precio el precio mínimo a partir del cual buscar excursiones
     * @return una lista de Excursion con precio mayor que el valor especificado
     */
    @Override
    public List<Excursion> findByPrecioMayorQue(Double precio) {
        List<Excursion> listaPrecioMayorQue = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getPrecioUnitario() > precio) {
                listaPrecioMayorQue.add(ele);
            }
        }
        return listaPrecioMayorQue;
    }

    /** 
     * Obtiene una lista de excursiones cuyo precio es menor que el especificado.
     * 
     * @param precio el precio máximo hasta el cual buscar excursiones
     * @return una lista de Excursion con precio menor que el valor especificado
     */
    @Override
    public List<Excursion> findByPrecioMenorQue(Double precio) {
        List<Excursion> listaPrecioMenorQue = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getPrecioUnitario() < precio) {
                listaPrecioMenorQue.add(ele);
            }
        }
        return listaPrecioMenorQue;
    }

    /** 
     * Obtiene una lista de excursiones cuyo precio está dentro de un rango especificado.
     * 
     * @param precioMin el precio mínimo del rango
     * @param precioMax el precio máximo del rango
     * @return una lista de Excursion cuyo precio se encuentra entre precioMin y precioMax
     */
    @Override
    public List<Excursion> findByPrecioMinMax(Double precioMin, Double precioMax) {
        List<Excursion> listaPrecioMinMax = new ArrayList<>();
        for (Excursion ele : lista) {
            if (ele.getPrecioUnitario() > precioMin && ele.getPrecioUnitario() < precioMax) {
                listaPrecioMinMax.add(ele);
            }
        }
        return listaPrecioMinMax;
    }
}
