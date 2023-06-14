package models;

public class Product {
    private  int productId;
    private String ProductName;
    private String ProductDescription;
    private String ProductPrice;

    public Product(String ProductName, String ProductDescription, String ProductPrice) {
        this.ProductName = ProductName;
        this.ProductDescription = ProductDescription;
        this.ProductPrice = ProductPrice;
    }

    public Product(int id,String ProductName, String ProductDescription, String ProductPrice) {
        this.productId = id;
        this.ProductName = ProductName;
        this.ProductDescription = ProductDescription;
        this.ProductPrice = ProductPrice;
    }

    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String ProductDescription) {
        this.ProductDescription = ProductDescription;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }
}
