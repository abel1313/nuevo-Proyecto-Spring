package com.ferreteria.nuevo.proyecto.repository;

import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Usuario;

@Repository
public interface IUsuarioRepository extends BaseRepository<Usuario, Integer>
{

}
