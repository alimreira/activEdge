package com.assessment.activedge.service;

import com.assessment.activedge.dto.StockDto;
import com.assessment.activedge.entity.Stock;
import com.assessment.activedge.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    //get the list of stocks
    public List<Stock> getAllStock()
    {
        List<Stock> stocks = new ArrayList<Stock>();
        stockRepository.findAll().forEach(stock -> stocks.add(stock));
        return stocks;
    }


    //get a single stock from the list by its ID
    public Stock getStockById(long id)
    {
        return stockRepository.findById(id).get();
    }

    //Create a new stock
    public Stock addStock(StockDto stockDto)
    {
        Stock stock = new Stock();
        stock.setCreate_date(new Date());
        stock.setName(stockDto.getName());
        stock.setCurrent_price(stockDto.getCurrent_price());
        return stockRepository.save(stock);

    }


    //delete a single stock by its ID
    public void delete(long id)
    {
        stockRepository.deleteById(id);
    }

    //update the current_price/name of a single stock
    public Stock updateStock(long id, StockDto stockDto)
    {
        Stock stock = getStockById(id);
        stock.setName(stockDto.getName());
        stock.setCurrent_price(stockDto.getCurrent_price());
        stock.setLast_update(new Date());

        return stockRepository.save(stock);
    }

}
