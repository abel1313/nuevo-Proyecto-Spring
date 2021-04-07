package com.ferreteria.nuevo.proyecto.modelo;



import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Cliente extends Base
{
	
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	 @JoinColumn( name = "persona_Id", unique=true, nullable=false, updatable=false)
	private Persona persona;

}
