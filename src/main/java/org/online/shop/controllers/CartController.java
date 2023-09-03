package org.online.shop.controllers;


import org.online.shop.entities.CartEntity;
import org.online.shop.entities.ProductEntity;
import org.online.shop.repositories.CartRepository;
import org.online.shop.repositories.ProductRepository;
import org.online.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Controller
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;



    public CartController() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    public Optional<User> getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (null != auth && auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            return Optional.of(user);
        }
        return Optional.empty();
    }


    @GetMapping("/get-cart")
    public ModelAndView getCart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        Optional<User> user = getLoggedInUser();
        Integer totalCart = 0;
        if (user.isPresent()) {
            List<CartEntity> carts = cartRepository.findAllByUser_Username(user.get().getUsername());
            for (CartEntity cart : carts) {
                totalCart += cart.getProduct().getPrice() * cart.getQuantity();
            }
            modelAndView.addObject("cart", cartRepository.findAllByUser_Username(user.get().getUsername()));
            modelAndView.addObject("total", totalCart);
            modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
            modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
            modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
            modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
            modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
            modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        } else {
            modelAndView.addObject("cart", new ArrayList<>());
        }
        return modelAndView;
    }


    @GetMapping("/order")
    public ModelAndView orderPlaced() {
        ModelAndView modelAndView = new ModelAndView("redirect: cart");
        Optional<User> user = getLoggedInUser();
        if (!user.isPresent()) {
            return new ModelAndView("redirect:/login");
        } else {
            List<CartEntity> carts = cartRepository.findAllByUser_Username(user.get().getUsername());
            if (carts.isEmpty()) {
                return new ModelAndView("redirect:" + "/get-cart");
            } else {
                for (CartEntity cartEntity : carts) {
                    ProductEntity product = productRepository.getById(cartEntity.getProductId());
                    Integer prodQuantityBeforeOrder = product.getQuantity();
                    Integer orderedQuantity = cartEntity.getQuantity();
                    Integer availableQuantity = prodQuantityBeforeOrder - orderedQuantity;
                    if (availableQuantity < 0 && prodQuantityBeforeOrder == 0) {
                        modelAndView = new ModelAndView("error");
                        modelAndView.addObject("message", "Stocul pentru produsul "
                                + product.getName() + " " + product.getBrand() + " este insuficient pentru a onora comanda dumneavoastra.");
                    } else {
                        product.setQuantity(availableQuantity);
                        productRepository.save(product);

                        modelAndView = new ModelAndView("cart");
                        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView1 = new ModelAndView("1pagination");
                        modelAndView1.addObject("productListB1", productRepository.findBFridge1("keyword"));
                        modelAndView1.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView1.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView1.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView1.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView1.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView1.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView2 = new ModelAndView("2pagination");
                        modelAndView2.addObject("productListB2", productRepository.findBFridge2("keyword"));
                        modelAndView2.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView2.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView2.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView2.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView2.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView2.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView3 = new ModelAndView("3pagination");
                        modelAndView3.addObject("productListB3", productRepository.findBFridge3("keyword"));
                        modelAndView3.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView3.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView3.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView3.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView3.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView3.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView4 = new ModelAndView("4pagination");
                        modelAndView4.addObject("productListB4", productRepository.findBFridge4("keyword"));
                        modelAndView4.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView4.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView4.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView4.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView4.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView4.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView5 = new ModelAndView("5pagination");
                        modelAndView5.addObject("productListB5", productRepository.findBFridge5("keyword"));
                        modelAndView5.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView5.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView5.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView5.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView5.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView5.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());


                        ModelAndView modelAndView6 = new ModelAndView("products");
                        modelAndView6.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView6.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView6.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView6.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView6.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView6.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());

                        ModelAndView modelAndView7 = new ModelAndView("fridges");
                        modelAndView7.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
                        modelAndView7.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
                        modelAndView7.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
                        modelAndView7.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
                        modelAndView7.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
                        modelAndView7.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
                    }
                }
            }
        }
        return modelAndView;
    }

    @GetMapping("/add-cart/{productId}")
    public ModelAndView addCart(@PathVariable("productId") Integer id, CartEntity cartEntity) {
        ModelAndView modelAndView = new ModelAndView("redirect:/get-cart");
        Optional<User> user = getLoggedInUser();
        Integer quantity = 1;
        if (user.isPresent()) {
            Integer userId = userRepository.findByUsername(user.get().getUsername()).getUserId();
            CartEntity dbCartEntity = cartRepository.findByProductIdAndUserId(id, userId);
            if (dbCartEntity != null) {
                int dbCartQuantity = dbCartEntity.getQuantity() + 1;
                dbCartEntity.setQuantity(dbCartQuantity);
                dbCartEntity.setTotal(dbCartQuantity * dbCartEntity.getProduct().getPrice());
                cartRepository.save(dbCartEntity);
            } else {
                cartEntity.setProductId(id);
                cartEntity.setQuantity(quantity);
                ProductEntity productEntity = productRepository.getById(id);
                cartEntity.setTotal(quantity * productEntity.getPrice());
                cartEntity.setUserId(userRepository.findByUsername(user.get().getUsername()).getUserId());
                cartRepository.save(cartEntity);
            }
        }
        return modelAndView;
    }

    @GetMapping("/delete-total-cart/{id}")
    public ModelAndView deleteTotalCart(@PathVariable Integer id) {
        Optional<CartEntity> cartEntity = cartRepository.findById(id);
        if (cartEntity.isPresent()) {
            cartRepository.delete(cartEntity.get());
            ModelAndView modelAndView = new ModelAndView("redirect:/get-cart");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }



    @GetMapping("/delete-partial-cart/{id}")
    public ModelAndView deletePartialCart(@PathVariable Integer id) {
        Optional<CartEntity> cartEntity = cartRepository.findById(id);
        if (cartEntity.isPresent()) {
            CartEntity cart = cartEntity.get();
            // scadem cantitatea produsului din cos
            cart.setQuantity(cart.getQuantity() - 1);
            // daca cantitatea devine 0, stergem produsul din cos
            if (cart.getQuantity() == 0) {
                cartRepository.delete(cart);
            } else {
                cartRepository.save(cart);
            }
            ModelAndView modelAndView = new ModelAndView("redirect:/get-cart");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }


}
