package ru.netology.domain;

public class TShirt extends Product{
    private String size;

    public TShirt(int id, String name, int price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
