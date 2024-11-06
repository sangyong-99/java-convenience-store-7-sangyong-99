package model;

public record Product(String name, int price, int quantity, String promotion) {
    @Override
    public String toString() {
        return null;
    }
}
