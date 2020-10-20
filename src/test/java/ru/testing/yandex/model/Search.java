package ru.testing.yandex.model;

public class Search {
    private String priceFrom;
    private String priceTo;

    public Search setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
        return this;
    }

    public Search setPriceTo(String priceTo) {
        this.priceTo = priceTo;
        return this;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    @Override
    public String toString() {
        return "Search{" +
                "priceFrom='" + priceFrom + '\'' +
                ", priceTo='" + priceTo + '\'' +
                '}';
    }
}
