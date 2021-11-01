package com.sb.projectapi.controllers;

import com.sb.projectapi.model.CfaItem;
import com.sb.projectapi.services.CfaItemService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cfa-menu/item/")
public class CfaItemController{
    CfaItemService cfaItemService;
    public CfaItemController(CfaItemService cfaItemService){
        this.cfaItemService = cfaItemService;
    }


    @GetMapping ({"/allItems"})
    public ResponseEntity<List<CfaItem>> getAllItems(){
        List<CfaItem> items = cfaItemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping({"/{itemId}"})
    public ResponseEntity<CfaItem> getItem(@PathVariable Long itemId){
        return new ResponseEntity<>(cfaItemService.getItemById(itemId),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CfaItem> saveItem(@RequestBody CfaItem item){
        CfaItem item1 = cfaItemService.insert(item);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("item", "/api/cfa-menu/item/" + item1.getId().toString());
        return new ResponseEntity<>(item1, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{itemId}"})
    public ResponseEntity<CfaItem> updateItem(@PathVariable("itemId") Long itemId, @RequestBody CfaItem item){
        cfaItemService.updateCfaItem(itemId, item);
        return  new ResponseEntity<>(cfaItemService.getItemById(itemId), HttpStatus.OK);
    }

    @DeleteMapping({"/{itemId}"})
    public ResponseEntity<CfaItem> deleteItem(@PathVariable("itemId") Long itemId){
        cfaItemService.deleteCfaItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
