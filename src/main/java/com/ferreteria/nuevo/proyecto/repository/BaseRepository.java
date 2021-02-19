package com.ferreteria.nuevo.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


import com.ferreteria.nuevo.proyecto.modelo.Base;


@NoRepositoryBean
public interface BaseRepository <T extends Base, ID extends Serializable> extends JpaRepository<T, ID>{

}
