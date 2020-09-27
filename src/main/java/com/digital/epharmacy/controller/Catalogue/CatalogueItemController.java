package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item controller test
 * Date: 09/26/2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.service.CatalogueItem.impl.CatalogueItemServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;
public class CatalogueItemController {

    @Autowired
    private CatalogueItemServiceImpl catalogueItemService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<CatalogueItem> create(@Valid @RequestBody CatalogueItem catalogueItem, BindingResult result){

        ResponseEntity<CatalogueItem> errorMap = (ResponseEntity<CatalogueItem>) validationService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;

        CatalogueItem newCatalogueItem = CatalogueItemFactory
                .createCatalogueItem(
                        catalogueItem.getItemNumber(),
                        catalogueItem.getItemName(),
                        catalogueItem.getItemDescription(),
                        catalogueItem.getItemQuantity(),
                        catalogueItem.getItemPrice()

                );

        catalogueItemService.create(newCatalogueItem);

        return new ResponseEntity<CatalogueItem>(catalogueItem, HttpStatus.CREATED);
    }
    @GetMapping("/read/{catalogueName}")
    public ResponseEntity<CatalogueItem> read(@PathVariable String catalogueName) {
        CatalogueItem catItem = catalogueItemService.read(catalogueName);
        return new ResponseEntity<CatalogueItem>(catItem, HttpStatus.OK);
    }
    @PostMapping("/update")
    public CatalogueItem update(@Valid @RequestBody CatalogueItem catItemInfo){
        return catalogueItemService.update(catItemInfo);
    }
    @GetMapping("/all")
    public Set<CatalogueItem> getall(){
        return catalogueItemService.getAll();
    }

    @DeleteMapping("/delete/{itemName}")
    public boolean delete(@PathVariable String itemName){
        return catalogueItemService.delete(itemName);
    }
}
