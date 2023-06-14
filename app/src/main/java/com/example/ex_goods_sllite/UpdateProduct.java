package com.example.ex_goods_sllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProduct extends AppCompatActivity {
    EditText etProductName, etProductPrice, etProductDescription;
    int productId;
    Button btnUpdateProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_product);

        etProductName = findViewById(R.id.etUpdateName);
        etProductPrice = findViewById(R.id.etUpdatePrice);
        etProductDescription = findViewById(R.id.etUpdateDesc);
        btnUpdateProduct = findViewById(R.id.btnUpdateProduct);

        etProductName.setText(getIntent().getStringExtra("name"));
        etProductPrice.setText(getIntent().getStringExtra("price"));
        etProductDescription.setText(getIntent().getStringExtra("desc"));
        productId = getIntent().getIntExtra("id", 0);

        btnUpdateProduct.setOnClickListener(v -> {
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
                ViewProducts.dbHandler.updateData(productId, newName, newPrice, newDesc);
                Intent intent = new Intent(UpdateProduct.this, ViewProducts.class);
                Toast.makeText(this, "Update product successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this, "Error while updating product", Toast.LENGTH_SHORT).show();
        }});


    }
}