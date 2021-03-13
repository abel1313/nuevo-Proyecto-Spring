package com.ferreteria.nuevo.proyecto.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona extends Base
{

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre_Persona")
	private String nombrePersona;
	
	@Column(name = "materno_Persona")
	private String maternoPersona;
	
	@Column(name = "paterno_Persona")
	private String paternoPersona;
	
	@Column(name = "fecha_Nacimientos_Persona")
	private String fechanacimientosPersona;
	
	@Column(name = "genero_Persona")
	private String generoPersona;
	
	@Column(name = "correo_Electronico_Persona")
	private String correoelectronicoPersona;
	

/*
	@ManyToOne(optional = false ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
 *    @JoinColumn(name="id_DirecconFK", nullable=false)
	private Direction direccion;
	
	@OneToOne(optional = false ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name="id_UsuarioFK", nullable=false)
	private Usuario usuario;
 * */
	
//	public Persona() {}
//
//
//	public Persona(int idPersona, String nombrePersona, String maternoPersona, String paternoPersona,
//			String fechaNacimientosPersona, String generoPersona, String correoElectronicoPersona,
//			Direction direccion) {
//		this.idPersona = idPersona;
//		this.nombrePersona = nombrePersona;
//		this.maternoPersona = maternoPersona;
//		this.paternoPersona = paternoPersona;
//		this.fechaNacimientosPersona = fechaNacimientosPersona;
//		this.generoPersona = generoPersona;
//		this.correoElectronicoPersona = correoElectronicoPersona;
//		this.direccion = direccion;
//	}
//
//
//	public int getIdPersona() {
//		return idPersona;
//	}
//
//
//	public void setIdPersona(int idPersona) {
//		this.idPersona = idPersona;
//	}
//
//
//	public String getNombrePersona() {
//		return nombrePersona;
//	}
//
//
//	public void setNombrePersona(String nombrePersona) {
//		this.nombrePersona = nombrePersona;
//	}
//
//
//	public String getMaternoPersona() {
//		return maternoPersona;
//	}
//
//
//	public void setMaternoPersona(String maternoPersona) {
//		this.maternoPersona = maternoPersona;
//	}
//
//
//	public String getPaternoPersona() {
//		return paternoPersona;
//	}
//
//
//	public void setPaternoPersona(String paternoPersona) {
//		this.paternoPersona = paternoPersona;
//	}
//
//
//	public String getFechaNacimientosPersona() {
//		return fechaNacimientosPersona;
//	}
//
//
//	public void setFechaNacimientosPersona(String fechaNacimientosPersona) {
//		this.fechaNacimientosPersona = fechaNacimientosPersona;
//	}
//
//
//	public String getGeneroPersona() {
//		return generoPersona;
//	}
//
//
//	public void setGeneroPersona(String generoPersona) {
//		this.generoPersona = generoPersona;
//	}
//
//
//	public String getCorreoElectronicoPersona() {
//		return correoElectronicoPersona;
//	}
//
//
//	public void setCorreoElectronicoPersona(String correoElectronicoPersona) {
//		this.correoElectronicoPersona = correoElectronicoPersona;
//	}
//
//
//	public Direction getDireccion() {
//		return direccion;
//	}
//
//
//	public void setDireccion(Direction direccion) {
//		this.direccion = direccion;
//	}
//
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//	
//	


}
