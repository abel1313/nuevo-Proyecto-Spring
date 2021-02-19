package com.ferreteria.nuevo.proyecto.servicio;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.ferreteria.nuevo.proyecto.repository.BaseRepository;

import com.ferreteria.nuevo.proyecto.modelo.*;;

public abstract class BaseServiceImpl <T extends Base, ID extends Serializable> implements IBaseService<T, ID>
{
	protected BaseRepository<T, ID> baseRepository;
	
	public BaseServiceImpl(BaseRepository<T, ID> baseRepository)
	{
		this.baseRepository = baseRepository;
	}

	@Override
	public List<T> findAll() throws Exception {
		
		try {
			List<T> entities = baseRepository.findAll();
			return entities;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public T findById(ID id) throws Exception {
		try {
			Optional<T> entityOptional = baseRepository.findById(id);
			return entityOptional.get();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T save(T entity) throws Exception {
		try {
			entity = baseRepository.save(entity);
			return entity;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T update(ID id, T entity) throws Exception {
		// 
		try {
			
			Optional<T> entityOptional = this.baseRepository.findById(id);
			T entityUpdate = entityOptional.get();
			entityUpdate = baseRepository.save(entityUpdate);
			return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public boolean delete(ID id) throws Exception {
		try {
			
			if(baseRepository.existsById(id))
			{
				baseRepository.deleteById(id);
				return true;
			}else {
				throw new Exception( );
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
