/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository
 * Date: 04 September 2020
 */


package com.digital.epharmacy.repository.PrescriptionItem;

import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;
import java.util.Set;
@Repository
public interface PrescriptionItemRepository  extends JpaRepository<PrescriptionItem, String> {

}
