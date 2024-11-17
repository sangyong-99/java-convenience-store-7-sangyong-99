package dto;

import model.Promotion;

public record ProductDTO(String productName, int price, int quantity, Promotion promotion) {
}
