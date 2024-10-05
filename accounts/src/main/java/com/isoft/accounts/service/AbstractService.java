package com.isoft.accounts.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import com.isoft.accounts.dto.BaseDTO;
import com.isoft.accounts.entity.BaseEntity;
import com.isoft.accounts.exception.EntityNotFoundException;
import com.isoft.accounts.mapper.Mapper;
import com.isoft.accounts.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Objects;
import lombok.Generated;

public abstract class AbstractService<T extends BaseEntity, S extends BaseDTO, J extends BaseRepository<T>> {
    private final J repository;
    private final Mapper<T, S> mapper;
    @PersistenceContext
    private final EntityManager entityManager;

    public AbstractService(J repository, EntityManager entityManager, Mapper<T, S> mapper) {
        this.repository = repository;
        this.entityManager = entityManager;
        this.mapper = mapper;
    }

    protected T update(S dto, Class<T> entityClass) {
        if (Objects.isNull(dto.getId())) {
            throw new IllegalArgumentException("entity id is null");
        } else {
            T entity = this.findById(dto.getId(), entityClass);
            if (Objects.isNull(entity)) {
                throw new EntityNotFoundException("entity", "id", "" + dto.getId());
            } else {
                this.mapper.mergeEntityWithDTO(dto, entity);
                return (BaseEntity)this.repository.save(entity);
            }
        }
    }

    protected T findById(Long id, Class<T> clazz) {
        return (BaseEntity)this.entityManager.find(clazz, id);
    }

    @Generated
    public J getRepository() {
        return this.repository;
    }

    @Generated
    public Mapper<T, S> getMapper() {
        return this.mapper;
    }

    @Generated
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
