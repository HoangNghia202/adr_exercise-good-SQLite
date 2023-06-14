package com.example.ex_goods_sllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import DB.DBHandler;
import models.Product;

public class ViewProducts extends AppCompatActivity {
    public static ArrayList<Product> productList;
    public static DBHandler dbHandler;
private RCVProductAdapter rcvProductAdapter;
private RecyclerView productsRV;
Button btnAddNewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnAddNewProduct= (Button) findViewById(R.id.fabAddProduct);
        setContentView(R.layout.view_products);

        productList = new ArrayList<>();
        dbHandler = new DBHandler(ViewProducts.this);
//        dbHandler.insertData("product1", "100", "description1");
        productList = dbHandler.readData();
//        Log.i("Product list", "onCreate: "+productList.get(1).getProductName());
        rcvProductAdapter = new RCVProductAdapter(productList, ViewProducts.this);
        productsRV = findViewById(R.id.viewProductsRCV);
        productsRV.setLayoutManager(new LinearLayoutManager(ViewProducts.this, RecyclerView.VERTICAL, false));
        productsRV.setAdapter(rcvProductAdapter);


    }

    public void addNewProduct (View view ){
        Intent intent = new Intent(ViewProducts.this, AddNewProduct.class);
        startActivity(intent);
    }

}