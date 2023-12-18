package com.example.demo7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private Button AddProduct1Button;

    @FXML
    private Button AddProduct2Button;

    @FXML
    private Button AddProduct3Button;

    @FXML
    private Button DeleteProduct1Button;

    @FXML
    private Button DeleteProduct2Button;

    @FXML
    private Button DeleteProduct3Button;
    @FXML
    private AnchorPane PriceList;
    @FXML
    private AnchorPane FirstProduct;

    @FXML
    private AnchorPane SecondProduct;

    @FXML
    private AnchorPane ThirdProduct;
    @FXML
    private Label product1;

    @FXML
    private Label product2;

    @FXML
    private Label product3;

    @FXML
    private Label TotalPrice;


    private int product1Price = 10;

    private int product_1 = 0;
    private int product2Price = 20;
    private int product_2 = 0;
    private int product3Price = 30;
    private int product_3 = 0;

    private int totalPriceValue = 0;

    @FXML
    void handleAddProduct(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        int productPrice = 0;
        if (sourceButton == AddProduct1Button) {
            productPrice = product1Price;
        product1.setText("You add product 1:  " + product_1++);
        } else if (sourceButton == AddProduct2Button) {
            productPrice = product2Price;
            product2.setText("You add product 2:  " + product_2++) ;
        } else if (sourceButton == AddProduct3Button) {
            productPrice = product3Price;
            product3.setText("You add product 3:  " + product_3++) ;        }

        totalPriceValue += productPrice;
        updateTotalPriceLabel();


    }

    @FXML
    void handleDeleteProduct(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        int productPrice = 0;

        if (sourceButton == DeleteProduct1Button) {
            productPrice = product1Price;
            product1.setText("You delete product 1:  " + product_1--) ;
        } else if (sourceButton == DeleteProduct2Button) {
            productPrice = product2Price;
            product2.setText("You delete product 2:  " + product_3--) ;
        } else if (sourceButton == DeleteProduct3Button) {
            productPrice = product3Price;
            product3.setText("You delete product 3:  " + product_2--) ;
        }

        if (totalPriceValue - productPrice >= 0 && product_1 > 0 && product_2 > 0 && product_3 > 0  ) {
            totalPriceValue -= productPrice;
            product_1 -= 1;
            product_2 -= 1;
            product_3 -= 1;
        } else {
            totalPriceValue = 0;
            product_1 = 0;
            product_2 = 0;
            product_3 = 0;
        }

        updateTotalPriceLabel();
    }

    private void updateTotalPriceLabel() {
        TotalPrice.setText(String.valueOf(totalPriceValue));
    }
}
