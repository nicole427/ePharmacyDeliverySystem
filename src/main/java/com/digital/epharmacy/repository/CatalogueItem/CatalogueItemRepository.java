/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository
 * Date: 30 August 2020
 */


package com.digital.epharmacy.repository.CatalogueItem;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CatalogueItemRepository  extends JpaRepository<CatalogueItem, String>  {
    List<CatalogueItem> findAllItemsByproductCategory(String productCategory);
    Page<CatalogueItem> findAllProductByBrand(@Param("searchTerm")String searchTerm, @Param("category")String category, Pageable pageable);
}
