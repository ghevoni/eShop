package org.online.shop.repositories;

import org.online.shop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

      @Query(value="select * from products where concat(brand, extra_description, short_description) like %?1%", nativeQuery = true)
      List<ProductEntity> findByKeyword(@Param("keyword") String keyword);


      @Query(value="select * from products where name='Televizor' ", nativeQuery=true)
      List<ProductEntity> findByTvProducts(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Masina de spalat' ", nativeQuery=true)
      List<ProductEntity> findByWashingMachineProducts(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Telefon' ", nativeQuery=true)
      List<ProductEntity> findByPhoneProducts(@Param("keyword") String keyword);

      //pagination
      @Query(value="select * from products where product_id=1", nativeQuery = true)
      ProductEntity findFridge1(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=2", nativeQuery = true)
      ProductEntity findFridge2(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=3", nativeQuery = true)
      ProductEntity findFridge3(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=4", nativeQuery = true)
      ProductEntity findFridge4(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=5", nativeQuery = true)
      ProductEntity findFridge5(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=6", nativeQuery = true)
      ProductEntity findFridge6(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=7", nativeQuery = true)
      ProductEntity findFridge7(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=9", nativeQuery = true)
      ProductEntity findFridge9(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=35", nativeQuery = true)
      ProductEntity findFridge35(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=36", nativeQuery = true)
      ProductEntity findFridge36(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=40", nativeQuery = true)
      ProductEntity findFridge40(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=41", nativeQuery = true)
      ProductEntity findFridge41(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=46", nativeQuery = true)
      ProductEntity findFridge46(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=48", nativeQuery = true)
      ProductEntity findFridge48(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=49", nativeQuery = true)
      ProductEntity findFridge49(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=50", nativeQuery = true)
      ProductEntity findFridge50(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=51", nativeQuery = true)
      ProductEntity findFridge51(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=52", nativeQuery = true)
      ProductEntity findFridge52(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=53", nativeQuery = true)
      ProductEntity findFridge53(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=54", nativeQuery = true)
      ProductEntity findFridge54(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=55", nativeQuery = true)
      ProductEntity findFridge55(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=57", nativeQuery = true)
      ProductEntity findFridge57(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=58", nativeQuery = true)
      ProductEntity findFridge58(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=59", nativeQuery = true)
      ProductEntity findFridge59(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=60", nativeQuery = true)
      ProductEntity findFridge60(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=61", nativeQuery = true)
      ProductEntity findFridge61(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=62", nativeQuery = true)
      ProductEntity findFridge62(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=64", nativeQuery = true)
      ProductEntity findFridge64(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=65", nativeQuery = true)
      ProductEntity findFridge65(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=66", nativeQuery = true)
      ProductEntity findFridge66(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=67", nativeQuery = true)
      ProductEntity findFridge67(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=68", nativeQuery = true)
      ProductEntity findFridge68(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=72", nativeQuery = true)
      ProductEntity findFridge72(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=73", nativeQuery = true)
      ProductEntity findFridge73(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=74", nativeQuery = true)
      ProductEntity findFridge74(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=75", nativeQuery = true)
      ProductEntity findFridge75(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=77", nativeQuery = true)
      ProductEntity findFridge77(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=78", nativeQuery = true)
      ProductEntity findFridge78(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=80", nativeQuery = true)
      ProductEntity findFridge80(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=81", nativeQuery = true)
      ProductEntity findFridge81(@Param("keyword") String keyword);

      @Query(value="select * from products where product_id=82", nativeQuery = true)
      ProductEntity findFridge82(@Param("keyword") String keyword);

      //test fridge
      @Query(value="select * from products where product_id=96", nativeQuery = true)
      ProductEntity findFridge96(@Param("keyword") String keyword);


      //Bootstrap pagination
      @Query(value="select * from products where name='Frigider' limit 0, 9", nativeQuery = true)
      List<ProductEntity> findBFridge1(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' limit 9, 9", nativeQuery = true)
      List<ProductEntity> findBFridge2(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' limit 18, 9", nativeQuery = true)
      List<ProductEntity> findBFridge3(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' limit 27, 9", nativeQuery = true)
      List<ProductEntity> findBFridge4(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' limit 36, 6", nativeQuery = true)
      List<ProductEntity> findBFridge5(@Param("keyword") String keyword);


      //code for Samsung fridges
      @Query(value="select * from products where brand='Samsung' limit 0, 9", nativeQuery = true)
      List<ProductEntity> findBSamsung1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' limit 9, 9", nativeQuery = true)
      List<ProductEntity> findBSamsung2(@Param("keyword") String keyword);


      @Query(value="select * from products where image_url like '%frSamsung%' ", nativeQuery = true)
      List<ProductEntity> findSamsungFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' order by price desc", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='Samsung' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Samsung' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findSamsungFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' order by price desc limit 1", nativeQuery = true)
      ProductEntity findSamsungFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Samsung' order by price asc limit 1", nativeQuery = true)
      ProductEntity findSamsungFridgeMinPrice(@Param("keyword") String keyword);


//    Code for Bosch fridges
      @Query(value="select * from products where image_url like '%Bosch%' ", nativeQuery = true)
      List<ProductEntity> findBoschRange(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' ", nativeQuery = true)
      List<ProductEntity> findBoschFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' order by price desc", nativeQuery = true)
      List<ProductEntity> findBoschFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='Bosch' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Bosch' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Bosch' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findBoschFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' order by price desc limit 1", nativeQuery = true)
      ProductEntity findBoschFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Bosch' and name='Frigider' order by price asc limit 1", nativeQuery = true)
      ProductEntity findBoschFridgeMinPrice(@Param("keyword") String keyword);


      //Code for Arctic fridges
      @Query(value="select * from products where image_url like '%Arctic%' ", nativeQuery = true)
      List<ProductEntity> findArcticRange(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' and brand='Arctic' ", nativeQuery = true)
      List<ProductEntity> findArcticFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' order by price desc", nativeQuery = true)
      List<ProductEntity> findArcticFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='Arctic' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Arctic' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Arctic' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findLgArcticFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Arctic' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Arctic' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Arctic' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Arctic' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findArcticFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' order by price desc limit 1", nativeQuery = true)
      ProductEntity findArcticFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Arctic' and name='Frigider' order by price asc limit 1", nativeQuery = true)
      ProductEntity findArcticFridgeMinPrice(@Param("keyword") String keyword);


      //Code for LG fridges
      @Query(value="select * from products where image_url like '%LG%' ", nativeQuery = true)
      List<ProductEntity> findLgRange(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' and brand='LG' ", nativeQuery = true)
      List<ProductEntity> findLgFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' order by price desc", nativeQuery = true)
      List<ProductEntity> findLgFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='LG' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='LG' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='LG' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='LG' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='LG' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='LG' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='LG' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findLgFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' order by price desc limit 1", nativeQuery = true)
      ProductEntity findLgFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='LG' and name='Frigider' order by price asc limit 1", nativeQuery = true)
      ProductEntity findLgFridgeMinPrice(@Param("keyword") String keyword);


      //Code for Indesit fridges
      @Query(value="select * from products where image_url like '%Indesit%' ", nativeQuery = true)
      List<ProductEntity> findIndesitRange(@Param("keyword") String keyword);

      @Query(value="select * from products where name='Frigider' and brand='Indesit' ", nativeQuery = true)
      List<ProductEntity> findIndesitFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' order by price desc", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='Indesit' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Indesit' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Indesit' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Indesit' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Indesit' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Indesit' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Indesit' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findIndesitFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' order by price desc limit 1", nativeQuery = true)
      ProductEntity findIndesitFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where brand='Indesit' and name='Frigider' order by price asc limit 1", nativeQuery = true)
      ProductEntity findIndesitFridgeMinPrice(@Param("keyword") String keyword);

//    Code for Whirlpool fridges
      @Query(value="select * from products where image_url like '%Whirlpool%' ", nativeQuery = true)
      List<ProductEntity> findWhirlpoolRange(@Param("keyword") String keyword);

      @Query(value="select * from products where image_url like '%frWhirlpool%' ", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridges(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' order by price desc", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesDescPrices(@Param("keyword") String keyword);

      @Query(value="select * from products where brand ='Whirlpool' and name='Frigider' and short_description like 'o usa%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesDoors1(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Whirlpool' and name='Frigider' and short_description like 'doua usi%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesDoors2(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' and extra_description like '%No Frost%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesNoFrostCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' and extra_description like '%racire dinamica%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesDynamicCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' and extra_description like '%racire statica%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesStaticCoolingSystem(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' and extra_description like '%Dozator apa%' order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesWaterDispenser(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Whirlpool' and name='Frigider' and price between 1000 and 2000 order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesPrices12(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Whirlpool' and name='Frigider' and price between 2000 and 3000 order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesPrices23(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Whirlpool' and name='Frigider' and price between 3000 and 4000 order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesPrices34(@Param("keyword") String keyword);

      @Query(value="select * from products where brand='Whirlpool' and name='Frigider' and price > 4000 order by price", nativeQuery = true)
      List<ProductEntity> findWhirlpoolFridgesPrices45(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' order by price desc limit 1", nativeQuery = true)
      ProductEntity findWhirlpoolFridgeMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' and brand='Whirlpool' order by price asc limit 1", nativeQuery = true)
      ProductEntity findWhirlpoolFridgeMinPrice(@Param("keyword") String keyword);


      @Query(value="select * from products  where name='Frigider' order by price desc limit 1", nativeQuery = true)
      ProductEntity findMaxPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' order by price asc limit 1", nativeQuery = true)
      ProductEntity findMinPrice(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' order by price", nativeQuery = true)
      List<ProductEntity> findFridgesAscPrices(@Param("keyword") String keyword);

      @Query(value="select * from products  where name='Frigider' order by price desc", nativeQuery = true)
      List<ProductEntity> findFridgesDescPrices(@Param("keyword") String keyword);


      //code for total quantity of each type of fridges
      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='Samsung'", nativeQuery = true)
      Integer findSamsungFridgesTotalQuantity();

      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='Bosch'", nativeQuery = true)
      Integer findBoschFridgesTotalQuantity();

      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='Arctic'", nativeQuery = true)
      Integer findArcticFridgesTotalQuantity();

      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='LG'", nativeQuery = true)
      Integer findLgFridgesTotalQuantity();

      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='Indesit'", nativeQuery = true)
      Integer findIndesitFridgesTotalQuantity();

      @Query(value="select sum(quantity) from products  where name='Frigider' and brand='Whirlpool'", nativeQuery = true)
      Integer findWhirlpoolFridgesTotalQuantity();

      @Query(value="select * from products where name='Frigider' and brand='Samsung' ", nativeQuery = true)
      List<ProductEntity> findNumberOfSamsungFridges();

}

