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
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueItemRepository  extends JpaRepository<CatalogueItem, String>  {

}
