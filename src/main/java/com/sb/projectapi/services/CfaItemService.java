package com.sb.projectapi.services;

import com.sb.projectapi.model.CfaItem;

import java.util.List;

public interface CfaItemService {

    List<CfaItem> getItems();

    CfaItem getItemById(Long id);

    CfaItem insert(CfaItem item);

    void updateCfaItem(Long id, CfaItem item);

    void deleteCfaItem(Long itemId);
}
