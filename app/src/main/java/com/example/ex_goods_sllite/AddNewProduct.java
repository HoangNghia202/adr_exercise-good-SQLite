package com.example.ex_goods_sllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DB.DBHandler;
import models.Product;

public class AddNewProduct extends AppCompatActivity {
    EditText etProductName, etProductPrice, etProductDescription;
    Button btnAddProduct;
    int productId;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_product);
        etProductName = findViewById(R.id.etAddName);
        etProductPrice = findViewById(R.id.etAddPrice);
        etProductDescription = findViewById(R.id.etAddDesc);
        btnAddProduct = findViewById(R.id.btnAddProduct);


        dbHandler = new DBHandler(AddNewProduct.this);


        btnAddProduct.setOnClickListener(v -> {
            try {
                if (
                        etProductName.getText().toString().isEmpty() ||
                                etProductPrice.getText().toString().isEmpty() ||
                                etProductDescription.getText().toString().isEmpty()
                ) {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                String newName = etProductName.getText().toString();
                String newPrice = etProductPrice.getText().toString();
                String newDesc = etProductDescription.getText().toString();
                dbHandler.insertData(newName, newPrice, newDesc);
                Intent intent = new Intent(AddNewProduct.this, ViewProducts.class);
                startActivity(intent);
//                finish();
                Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error while adding product", Toast.LENGTH_SHORT).show();
            }
        });
    }
}