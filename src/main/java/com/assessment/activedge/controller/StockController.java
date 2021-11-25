package com.assessment.activedge.controller;

import com.assessment.activedge.dto.StockDto;
import com.assessment.activedge.entity.Stock;
import com.assessment.activedge.responses.ApiResponse;
import com.assessment.activedge.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("/stock")
    private ResponseEntity<ApiResponse<List<Stock>>> getAllStock()
    {
        var response = new ApiResponse<>(HttpStatus.OK, "Successful", stockService.getAllStock());
        return new ResponseEntity<>(response, response.getStatus());
    }


    @GetMapping("/stock/{id}")
    private ResponseEntity<ApiResponse<Stock>> getStock(@PathVariable("id") long id)
    {
        ApiResponse<Stock> response = new ApiResponse<>(HttpStatus.CREATED, "Successful", stockService.getStockById(id));
        return new ResponseEntity<>(response, response.getStatus());

    }


    @DeleteMapping("/stock/{id}")
    private ResponseEntity<ApiResponse<Stock>> deleteStock(@PathVariable("id") long id)
    {
        stockService.delete(id);
        ApiResponse<Stock> response = new ApiResponse<>(HttpStatus.OK, "Successful", null);

        return new ResponseEntity<>(response, response.getStatus());
    }


    @PostMapping("/stock")
    private ResponseEntity<ApiResponse<Stock>> addStock(@RequestBody StockDto stockDto)
    {
        ApiResponse<Stock> response = new ApiResponse<>(HttpStatus.CREATED, "Successful", stockService.addStock(stockDto));
        System.out.println(response.toString());
        return new ResponseEntity<>(response, response.getStatus());
    }


    @PutMapping("/stock/{id}")
    private ResponseEntity<ApiResponse<Stock>> updateStock( @PathVariable("id") long id, @RequestBody StockDto stockDto)
    {
        ApiResponse<Stock> response = new ApiResponse<>(HttpStatus.CREATED, "Successful", stockService.updateStock(id, stockDto));
        System.out.println(response.toString());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
