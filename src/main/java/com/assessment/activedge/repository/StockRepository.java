package com.assessment.activedge.repository;

import com.assessment.activedge.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StockRepository implements JpaRepository<Stock, Long> {
//    Optional<Stock> findStockById(Long id);
//
//    Stock findStockById (Long id);
//
//    String updateStockById (Long id);
//
//    String deleteStockByName(String name);
//
}
