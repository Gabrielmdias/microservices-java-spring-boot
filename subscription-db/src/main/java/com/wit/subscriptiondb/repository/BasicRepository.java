package com.wit.subscriptiondb.repository;

import com.wit.subscriptiondb.domain.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
public interface BasicRepository<T extends BasicEntity> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {
}
