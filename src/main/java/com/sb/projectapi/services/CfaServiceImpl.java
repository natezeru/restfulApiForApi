package com.sb.projectapi.services;

import com.sb.projectapi.model.CfaItem;
import com.sb.projectapi.repositories.CfaMenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CfaServiceImpl implements CfaItemService{
    CfaMenuRepository cfaMenuRepository;
    public CfaServiceImpl(CfaMenuRepository cfaMenuRepository){
        this.cfaMenuRepository = cfaMenuRepository;
    }



    @Override
    public List<CfaItem> getItems() {
        List<CfaItem> items = new ArrayList<>();
        cfaMenuRepository.findAll().forEach(items::add);
        return items;

    }

    @Override
    public CfaItem getItemById(Long id) {
        return cfaMenuRepository.findById(id).get();
    }

    @Override
    public CfaItem insert(CfaItem item) {
        return cfaMenuRepository.save(item);
    }

    @Override
    public void updateCfaItem(Long id, CfaItem item) {
        CfaItem itemFromDb = cfaMenuRepository.findById(id).get();
        System.out.println(itemFromDb.toString());

        itemFromDb.setItemName(item.getItemName());
        itemFromDb.setCalories(item.getCalories());
        itemFromDb.setDescription(item.getDescription());
        cfaMenuRepository.save(itemFromDb);
    }

    @Override
    public void deleteCfaItem(Long itemId) {
        cfaMenuRepository.deleteById(itemId);

    }
}
