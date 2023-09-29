package com.stock.register.infra.repository;

import com.stock.register.infra.db.StockClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<StockClient,Long> {

}
