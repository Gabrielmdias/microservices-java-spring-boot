package com.wit.subscriptiondb.service;

import com.wit.subscriptiondb.domain.BasicEntity;
import com.wit.subscriptiondb.repository.BasicRepository;
import com.wit.subscriptiondomain.BasicDTO;
import com.wit.subscriptiondomain.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public abstract class BasicService<T extends BasicEntity, R extends BasicRepository<T>> {

    protected final R repository;
    protected final ModelMapper mapper;

    public BasicService(R repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);
    }

    public T findById(UUID id) {
        Optional<T> obj = repository.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object not found Id: " + id + ", type: " + obj.getClass().getName());
        }
        return obj.get();
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Object not found Id: " + id);
        }
    }

    public abstract T getEntity(BasicDTO dto);

    public abstract BasicDTO getDTO(T entity);

    public abstract BasicDTO getListDTO(List<T> entityList);

    public BasicDTO execute(BasicDTO dto) {
        T entity = this.getEntity(dto);
        switch (dto.getOperation()) {
            case CREATE:
                T create = create(entity);
                return getDTO(create);
            case DELETE:
                delete(entity.getId());
                return dto;
            case FIND_BY_ID:
                T findById = findById(entity.getId());
                return getDTO(findById);
            case FIND_ALL:
                List<T> findAll = findAll();
                return getListDTO(findAll);
            default:
                throw new IllegalArgumentException("Unidentified operation");
        }
    }
}
