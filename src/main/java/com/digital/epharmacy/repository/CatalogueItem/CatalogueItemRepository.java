/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository
 * Date: 30 August 2020
 */


package com.digital.epharmacy.repository.CatalogueItem;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.repository.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CatalogueItemRepository  extends JpaRepository<CatalogueItem, String>  {

}
