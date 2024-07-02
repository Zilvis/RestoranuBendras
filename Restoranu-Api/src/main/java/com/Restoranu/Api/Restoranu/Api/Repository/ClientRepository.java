package com.Restoranu.Api.Restoranu.Api.Repository;

import com.Restoranu.Api.Restoranu.Api.Entity.ClientsEntity;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientsEntity, Long> {
}
