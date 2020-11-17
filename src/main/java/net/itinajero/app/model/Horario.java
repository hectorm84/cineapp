/**
 *  Clase de modelo que representa un horario para una determinada pelicula.
 */
package net.itinajero.app.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String hora;
	private String sala;
	private double precio;

	// Relacion Muchos a Uno -> Muchos horarios para una pelicula
	@ManyToOne
	@JoinColumn(name = "idPelicula") // foreignKey en la tabla de Horarios
	private Pelicula pelicula;

	/**
	 * Constructor sin parametros
	 */
	public Horario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", precio=" + precio
				+ ", pelicula=" + pelicula + "]";
	}

}
