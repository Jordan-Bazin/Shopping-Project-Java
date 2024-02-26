package com.shopping.shopping;

import com.shopping.shopping.model.OrderT;
import com.shopping.shopping.model.Product;
import com.shopping.shopping.model.UserT;
import com.shopping.shopping.repository.OrderRepository;
import com.shopping.shopping.repository.ProductOrderRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class LoadDataProducts {
    private static final Logger log = LoggerFactory.getLogger(LoadDataProducts.class);
    String products;
    String users;
    String orders;
    String productOrders;
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        return args-> {
            try{
                products = new String(Files.readAllBytes(Paths.get("C:/dev/java/projet/Shopping-Project-Java/data/dataProducts.json")));
                users = new String(Files.readAllBytes(Paths.get("C:/dev/java/projet/Shopping-Project-Java/data/dataUsers.json")));
                orders = new String(Files.readAllBytes(Paths.get("C:/dev/java/projet/Shopping-Project-Java/data/dataOrders.json")));
                productOrders = new String(Files.readAllBytes(Paths.get("C:/dev/java/projet/Shopping-Project-Java/data/dataProductOrders.json")));

                JSONArray jsonProducts = new JSONArray(products);
                JSONArray jsonUsers = new JSONArray(users);
                JSONArray jsonOrders  = new JSONArray(orders);
                JSONArray jsonProductOrders = new JSONArray(productOrders);

                // Load products
                for (int i = 0; i < jsonProducts.length(); i++) {
                    JSONObject jsonObject = jsonProducts.getJSONObject(i);
                    //System.out.println(jsonObject);
                    // Extraire les données de chaque objet JSON
                    int id = jsonObject.getInt("id");
                    String title = jsonObject.getString("title");
                    String description = jsonObject.getString("description");
                    float price = jsonObject.getFloat("price");
                    float rating = jsonObject.getFloat("rating");
                    int stock = jsonObject.getInt("stock");
                    String brand = jsonObject.getString("brand");
                    String category = jsonObject.getString("category");
                    String thumbnail = jsonObject.getString("thumbnail");
                    JSONArray imagesArray = jsonObject.getJSONArray("images");
                    String[] images = new String[imagesArray.length()];
                    for (int j = 0; j < imagesArray.length(); j++) {
                        images[j] = imagesArray.getString(j);
                    }

                    Product product = new Product(title, description, price, rating, stock, brand, category, thumbnail);
                    productRepository.save(product);
                }

                // Load users
                for (int i = 0; i < jsonUsers.length(); i++) {
                    JSONObject jsonObject = jsonUsers.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String password = jsonObject.getString("password");
                    String token = jsonObject.getString("token");

                    UserT user = new UserT(name, password, token);
                    userRepository.save(user);
                }

                // Load orders
                for (int i = 0; i < jsonOrders.length(); i++) {
                    JSONObject jsonObject = jsonOrders.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    int userId = jsonObject.getInt("userId");
                    String status = jsonObject.getString("status");
                    JSONArray productIdArray = jsonObject.getJSONArray("productId");
                    ArrayList<Integer> productId = new ArrayList<>(50);
                    for (int j = 0; j < productIdArray.length(); j++) {
                        productId.add(productIdArray.getInt(j));
                    }

                    OrderT order = new OrderT(productId, userId, status);
                    orderRepository.save(order);
                }

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}


