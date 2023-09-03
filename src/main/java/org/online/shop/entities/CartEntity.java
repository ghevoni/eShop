package org.online.shop.entities;

import javax.persistence.*;
import java.util.Iterator;

@Entity
@Table(name="carts")
public class CartEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cartId;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private Integer total;

    @ManyToOne
    @JoinColumn(name="productId", insertable=false, updatable=false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="userId", insertable=false, updatable=false)
    private UserEntity user;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
