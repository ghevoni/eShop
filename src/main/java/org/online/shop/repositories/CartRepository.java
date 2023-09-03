package org.online.shop.repositories;

import org.online.shop.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Integer> {

    List<CartEntity> findAllByUser_Username(String username);
    CartEntity findByProductIdAndUserId(Integer productId, Integer userId);

}
