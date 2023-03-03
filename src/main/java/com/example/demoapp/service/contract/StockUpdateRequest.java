package com.example.demoapp.service.contract;

import com.example.demoapp.model.dto.request.UpdateStockForGamesRequestDto;

import java.util.List;
import java.util.Objects;

public record StockUpdateRequest(List<UpdateStockForGamesRequestDto> updateStockRequests) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (StockUpdateRequest) obj;
        return Objects.equals(this.updateStockRequests, that.updateStockRequests);
    }

    @Override
    public String toString() {
        return "StockUpdateRequest[" +
                "updateStockRequests=" + updateStockRequests + ']';
    }

}