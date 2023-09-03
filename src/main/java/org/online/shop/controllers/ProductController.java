package org.online.shop.controllers;


import org.online.shop.entities.ProductEntity;
import org.online.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    public ProductController() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/firstPage")
    public ModelAndView getFirstPage() {
        ModelAndView modelAndView = new ModelAndView("firstPage");
        modelAndView.addObject("fridge1", productRepository.findFridge1("keyword"));
        modelAndView.addObject("fridge3", productRepository.findFridge3("keyword"));
        modelAndView.addObject("fridge58", productRepository.findFridge58("keyword"));
        modelAndView.addObject("fridge64", productRepository.findFridge64("keyword"));
        modelAndView.addObject("fridge67", productRepository.findFridge67("keyword"));
        modelAndView.addObject("fridge77", productRepository.findFridge77("keyword"));
        return modelAndView;
    }


    @GetMapping("/search")
    public ModelAndView getSearchElement(String keyword) {
        ModelAndView modelAndView = new ModelAndView("products");
        if(keyword != null) {
            modelAndView.addObject("productList", productRepository.findByKeyword(keyword));
        }else{
            modelAndView.addObject("productList", productRepository.findAll());
            return modelAndView;
        }
        return modelAndView;
    }

    //pagination
    @GetMapping("/fridges")
    public ModelAndView getFridgeProducts() {
        ModelAndView modelAndView = new ModelAndView("fridges");
        modelAndView.addObject("fridge1", productRepository.findFridge1("keyword"));
        modelAndView.addObject("fridge2", productRepository.findFridge2("keyword"));
        modelAndView.addObject("fridge3", productRepository.findFridge3("keyword"));
        modelAndView.addObject("fridge4", productRepository.findFridge4("keyword"));
        modelAndView.addObject("fridge5", productRepository.findFridge5("keyword"));
        modelAndView.addObject("fridge6", productRepository.findFridge6("keyword"));
        modelAndView.addObject("fridge7", productRepository.findFridge6("keyword"));
        modelAndView.addObject("fridge9", productRepository.findFridge6("keyword"));
        modelAndView.addObject("fridge35", productRepository.findFridge35("keyword"));
        modelAndView.addObject("fridge36", productRepository.findFridge35("keyword"));
        modelAndView.addObject("fridge40", productRepository.findFridge35("keyword"));
        modelAndView.addObject("fridge41", productRepository.findFridge35("keyword"));
        modelAndView.addObject("fridge46", productRepository.findFridge46("keyword"));
        modelAndView.addObject("fridge48", productRepository.findFridge48("keyword"));
        modelAndView.addObject("fridge49", productRepository.findFridge49("keyword"));
        modelAndView.addObject("fridge50", productRepository.findFridge50("keyword"));
        modelAndView.addObject("fridge51", productRepository.findFridge51("keyword"));
        modelAndView.addObject("fridge52", productRepository.findFridge52("keyword"));
        modelAndView.addObject("fridge53", productRepository.findFridge53("keyword"));
        modelAndView.addObject("fridge54", productRepository.findFridge54("keyword"));
        modelAndView.addObject("fridge55", productRepository.findFridge55("keyword"));
        modelAndView.addObject("fridge57", productRepository.findFridge57("keyword"));
        modelAndView.addObject("fridge58", productRepository.findFridge58("keyword"));
        modelAndView.addObject("fridge59", productRepository.findFridge59("keyword"));
        modelAndView.addObject("fridge60", productRepository.findFridge60("keyword"));
        modelAndView.addObject("fridge61", productRepository.findFridge61("keyword"));
        modelAndView.addObject("fridge62", productRepository.findFridge62("keyword"));
        modelAndView.addObject("fridge64", productRepository.findFridge64("keyword"));
        modelAndView.addObject("fridge65", productRepository.findFridge65("keyword"));
        modelAndView.addObject("fridge66", productRepository.findFridge66("keyword"));
        modelAndView.addObject("fridge67", productRepository.findFridge67("keyword"));
        modelAndView.addObject("fridge68", productRepository.findFridge68("keyword"));
        modelAndView.addObject("fridge72", productRepository.findFridge72("keyword"));
        modelAndView.addObject("fridge73", productRepository.findFridge73("keyword"));
        modelAndView.addObject("fridge74", productRepository.findFridge74("keyword"));
        modelAndView.addObject("fridge75", productRepository.findFridge75("keyword"));
        modelAndView.addObject("fridge77", productRepository.findFridge77("keyword"));
        modelAndView.addObject("fridge78", productRepository.findFridge78("keyword"));
        modelAndView.addObject("fridge80", productRepository.findFridge80("keyword"));
        modelAndView.addObject("fridge81", productRepository.findFridge81("keyword"));
        modelAndView.addObject("fridge82", productRepository.findFridge82("keyword"));
        modelAndView.addObject("fridge96", productRepository.findFridge96("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }


    @GetMapping("/tvs")
    public ModelAndView getTvProducts() {
        ModelAndView modelAndView = new ModelAndView("tvs");
        modelAndView.addObject("productList", productRepository.findByTvProducts("keyword"));
        return modelAndView;
    }

    @GetMapping("/washingMachines")
    public ModelAndView getWashingMachineProducts() {
        ModelAndView modelAndView = new ModelAndView("washingMachines");
        modelAndView.addObject("productList", productRepository.findByWashingMachineProducts("keyword"));
        return modelAndView;
    }

    @GetMapping("/phones")
    public ModelAndView getPhoneProducts() {
        ModelAndView modelAndView = new ModelAndView("phones");
        modelAndView.addObject("productList", productRepository.findByPhoneProducts("keyword"));
        return modelAndView;
    }

    @GetMapping("/product/add")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView("productEdit");
        modelAndView.addObject("product", new ProductEntity());
        return modelAndView;
    }



    @PostMapping(value = "/product/save", consumes = {"multipart/form-data"})
    public ModelAndView productSave(@ModelAttribute("product") ProductEntity productEntity,
                                    @RequestParam("file") MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/firstPage");
        String path1 = "target/classes/static/imagines";
        String path2 = "src/main/resources/static/imagines";
        String filename = file.getOriginalFilename();

        if (filename != null && !filename.isEmpty()) {
            saveFile(path1, filename, file);
            saveFile(path2, filename, file);
            productEntity.setImageUrl("/imagines/" + filename);
        }
        productRepository.save(productEntity);
        return modelAndView;
    }

    public void saveFile(String path, String fileName, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(path);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        }
    }

    @GetMapping("/product/view/{id}")
    public ModelAndView productView(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("productView");
        modelAndView.addObject("product", productRepository.getById(id));
        return modelAndView;
    }


    @GetMapping("/product/edit/{id}")
    public ModelAndView productEdit(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("productEdit");
        modelAndView.addObject("product", productRepository.getById(id));
        return modelAndView;
    }


    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent()) {
            productRepository.delete(productEntity.get());
            ModelAndView modelAndView = new ModelAndView("redirect:/firstPage");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }


    //Code for Samsung fridges
    @GetMapping("/samsung/range1")
    public ModelAndView samsungRange1() {
        ModelAndView modelAndView = new ModelAndView("samsungRangeP1");
        modelAndView.addObject("productList1", productRepository.findBSamsung1("keyword"));
        return modelAndView;
    }

    @GetMapping("/samsung/range2")
    public ModelAndView samsungRange2() {
        ModelAndView modelAndView = new ModelAndView("samsungRangeP2");
        modelAndView.addObject("productList2", productRepository.findBSamsung2("keyword"));
        return modelAndView;
    }

    @GetMapping("/samsung/fridges")
    public ModelAndView samsungFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findSamsungFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/asc/prices")
    public ModelAndView samsungFridgesAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findSamsungFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/desc/prices")
    public ModelAndView samsungFridgesDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findSamsungFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/doors1")
    public ModelAndView samsungFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/doors2")
    public ModelAndView samsungFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/noFrost")
    public ModelAndView samsungFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/dynamic")
    public ModelAndView samsungFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/static")
    public ModelAndView samsungFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/water/dispenser")
    public ModelAndView samsungFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/prices12")
    public ModelAndView samsungFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/prices23")
    public ModelAndView samsungFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/prices34")
    public ModelAndView samsungFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/prices45")
    public ModelAndView samsungFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findSamsungFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findSamsungFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/max/price")
    public ModelAndView samsungFridgeMaxPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findSamsungFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/samsung/fridge/min/price")
    public ModelAndView samsungFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findSamsungFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }


    @GetMapping("/bosch/range")
    public ModelAndView boschRange() {
        ModelAndView modelAndView = new ModelAndView("bosch");
        modelAndView.addObject("productList", productRepository.findBoschRange("keyword"));
        return modelAndView;
    }

    @GetMapping("/bosch/fridges")
    public ModelAndView boschFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findBoschFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/asc/prices")
    public ModelAndView fridgesBoschAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findBoschFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/desc/prices")
    public ModelAndView fridgesBoschDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findBoschFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/doors1")
    public ModelAndView boschFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/doors2")
    public ModelAndView boschFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/noFrost")
    public ModelAndView boschFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/dynamic")
    public ModelAndView boschFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/static")
    public ModelAndView boschFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/water/dispenser")
    public ModelAndView boschFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/prices12")
    public ModelAndView boschFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/prices23")
    public ModelAndView boschFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/prices34")
    public ModelAndView boschFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/prices45")
    public ModelAndView boschFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findBoschFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findBoschFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/max/price")
    public ModelAndView boschFridgeMaxPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findBoschFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bosch/fridge/min/price")
    public ModelAndView boschFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findBoschFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }


    //Code for Arctic fridges
    @GetMapping("/arctic/range")
    public ModelAndView arcticRange() {
        ModelAndView modelAndView = new ModelAndView("arctic");
        modelAndView.addObject("productList", productRepository.findArcticRange("keyword"));
        return modelAndView;
    }

    @GetMapping("/arctic/fridges")
    public ModelAndView arcticFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findArcticFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/asc/prices")
    public ModelAndView arcticFridgesAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findArcticFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/desc/prices")
    public ModelAndView arcticFridgesDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findArcticFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/doors1")
    public ModelAndView arcticFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/doors2")
    public ModelAndView arcticFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/noFrost")
    public ModelAndView arcticFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/dynamic")
    public ModelAndView arcticFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/static")
    public ModelAndView arcticFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/water/dispenser")
    public ModelAndView arcticFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgArcticFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgArcticFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/prices12")
    public ModelAndView arcticFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/prices23")
    public ModelAndView arcticFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/prices34")
    public ModelAndView arcticFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/prices45")
    public ModelAndView arcticFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findArcticFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findArcticFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/max/price")
    public ModelAndView arcticFridgeMaxPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findArcticFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/arctic/fridge/min/price")
    public ModelAndView arcticFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findArcticFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    //code for LG fridges
    @GetMapping("/lg/range")
    public ModelAndView lgRange() {
        ModelAndView modelAndView = new ModelAndView("lg");
        modelAndView.addObject("productList", productRepository.findLgRange("keyword"));
        return modelAndView;
    }

    @GetMapping("/lg/fridges")
    public ModelAndView lgFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findLgFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/asc/prices")
    public ModelAndView lgFridgesAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findLgFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/desc/prices")
    public ModelAndView lgFridgesDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findLgFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/doors1")
    public ModelAndView lgFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/doors2")
    public ModelAndView lgFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/noFrost")
    public ModelAndView lgFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/dynamic")
    public ModelAndView lgFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/static")
    public ModelAndView lgFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/water/dispenser")
    public ModelAndView lgFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/prices12")
    public ModelAndView lgFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/prices23")
    public ModelAndView lgFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/prices34")
    public ModelAndView lgFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/prices45")
    public ModelAndView lgFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findLgFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findLgFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/max/price")
    public ModelAndView lgFridgeMaxPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findLgFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/lg/fridge/min/price")
    public ModelAndView lgFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findLgFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    //code for Indesit fridges
    @GetMapping("/indesit/range")
    public ModelAndView indesitRange() {
        ModelAndView modelAndView = new ModelAndView("indesit");
        modelAndView.addObject("productList", productRepository.findIndesitRange("keyword"));
        return modelAndView;
    }

    @GetMapping("/indesit/fridges")
    public ModelAndView indesitFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findIndesitFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/asc/prices")
    public ModelAndView indesitFridgesAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findIndesitFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/desc/prices")
    public ModelAndView indesitFridgesDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findIndesitFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/doors1")
    public ModelAndView indesitFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/doors2")
    public ModelAndView indesitFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/noFrost")
    public ModelAndView indesitFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/dynamic")
    public ModelAndView indesitFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/static")
    public ModelAndView indesitFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/water/dispenser")
    public ModelAndView indesitFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/prices12")
    public ModelAndView indesitFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/prices23")
    public ModelAndView indesitFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/prices34")
    public ModelAndView indesitFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/prices45")
    public ModelAndView indesitFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findIndesitFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findIndesitFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/max/price")
    public ModelAndView indesitFridgeMaxPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findIndesitFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/indesit/fridge/min/price")
    public ModelAndView indesitFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findIndesitFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    //Code for Whirlpool fridges
    @GetMapping("/whirlpool/range")
    public ModelAndView whirlpoolRange() {
        ModelAndView modelAndView = new ModelAndView("whirlpool");
        modelAndView.addObject("productList", productRepository.findWhirlpoolRange("keyword"));
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridges")
    public ModelAndView whirlpoolFridges() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridges("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/asc/prices")
    public ModelAndView whirlpoolFridgesAscPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesAscPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/desc/prices")
    public ModelAndView whirlpoolFridgesDescPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesDescPrices("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/doors1")
    public ModelAndView whirlpoolFridgesDoors1() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesDoors1("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesDoors1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/doors2")
    public ModelAndView whirlpoolFridgesDoors2() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesDoors2("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesDoors2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/noFrost")
    public ModelAndView whirlpoolFridgesNoFrost() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesNoFrostCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesNoFrostCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/dynamic")
    public ModelAndView whirlpoolFridgesDynamic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesDynamicCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesDynamicCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/static")
    public ModelAndView whirlpoolFridgesStatic() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesStaticCoolingSystem("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesStaticCoolingSystem("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/water/dispenser")
    public ModelAndView whirlpoolFridgesWaterDispenser() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesWaterDispenser("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesWaterDispenser("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/prices12")
    public ModelAndView whirlpoolFridgesPrices12() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesPrices12("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesPrices12("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/prices23")
    public ModelAndView whirlpoolFridgesPrices23() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesPrices23("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesPrices23("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/prices34")
    public ModelAndView whirlpoolFridgesPrices34() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesPrices34("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesPrices34("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/prices45")
    public ModelAndView whirlpoolFridgesPrices45() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductEntity> productEntityList = productRepository.findWhirlpoolFridgesPrices45("keyword");
        if (productEntityList.isEmpty()) {
            modelAndView = new ModelAndView("soldOut");
            return modelAndView;
        }
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgesPrices45("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/max/price")
    public ModelAndView whirlpoolFridgeMaxPrices() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgeMaxPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/whirlpool/fridge/min/price")
    public ModelAndView whirlpoolFridgeMinPrice() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("productList", productRepository.findWhirlpoolFridgeMinPrice("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }


    @GetMapping("/bFridge1")
    public ModelAndView bFridge1(){
        ModelAndView modelAndView = new ModelAndView("1pagination");
        modelAndView.addObject("productListB1", productRepository.findBFridge1("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bFridge2")
    public ModelAndView bFridge2(){
        ModelAndView modelAndView = new ModelAndView("2pagination");
        modelAndView.addObject("productListB2", productRepository.findBFridge2("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bFridge3")
    public ModelAndView bFridge3(){
        ModelAndView modelAndView = new ModelAndView("3pagination");
        modelAndView.addObject("productListB3", productRepository.findBFridge3("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bFridge4")
    public ModelAndView bFridge4(){
        ModelAndView modelAndView = new ModelAndView("4pagination");
        modelAndView.addObject("productListB4", productRepository.findBFridge4("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }

    @GetMapping("/bFridge5")
    public ModelAndView bFridge5(){
        ModelAndView modelAndView = new ModelAndView("5pagination");
        modelAndView.addObject("productListB5", productRepository.findBFridge5("keyword"));
        modelAndView.addObject("samsungFridgesTotalQuantity", productRepository.findSamsungFridgesTotalQuantity());
        modelAndView.addObject("boschFridgesTotalQuantity", productRepository.findBoschFridgesTotalQuantity());
        modelAndView.addObject("arcticFridgesTotalQuantity", productRepository.findArcticFridgesTotalQuantity());
        modelAndView.addObject("lgFridgesTotalQuantity", productRepository.findLgFridgesTotalQuantity());
        modelAndView.addObject("indesitFridgesTotalQuantity", productRepository.findIndesitFridgesTotalQuantity());
        modelAndView.addObject("whirlpoolFridgesTotalQuantity", productRepository.findWhirlpoolFridgesTotalQuantity());
        return modelAndView;
    }


    @GetMapping("/display/error/page")
    public ModelAndView displayErrorPage(){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

}
