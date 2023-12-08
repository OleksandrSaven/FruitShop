package com.example.ittest.repository;

import com.example.ittest.model.CartItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByFruit_Id(Long id);

    List<CartItem> findCartItemsByShoppingCartId(Long id);

}
