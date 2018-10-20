package com.uet.service;

import com.uet.dao.DataLoader;
import com.uet.model.ItemEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemService  extends DataLoader{

    DataLoader dataLoader;

    public ItemService(DataLoader dataLoader){
        this.dataLoader = dataLoader;
    }

    public void save(ItemEntity itemEntity){
        try {
            dataLoader.insertItem(itemEntity);
        } catch (Exception e){}
    }

    public List convertData() throws SQLException {
        List<ItemEntity> itemEntities = dataLoader.resolveItems();
        return itemEntities == null ? new ArrayList(): itemEntities;
    }

    public Object[][] generateItemObject(List<ItemEntity> itemEntities){
        Object[][] itemObj = new Object[itemEntities.size()][9];
        for(int i = 0; i < itemEntities.size(); i++){
            itemObj[i][0] = i + 1;
            itemObj[i][1] = itemEntities.get(i).name;
            itemObj[i][2] = itemEntities.get(i).code;
            itemObj[i][3] = itemEntities.get(i).type;
            itemObj[i][4] = itemEntities.get(i).provider;
            itemObj[i][5] = itemEntities.get(i).quantity;
            itemObj[i][6] = itemEntities.get(i).priceImport;
            itemObj[i][7] = itemEntities.get(i).priceExport;
            itemObj[i][8] = itemEntities.get(i).note;

        }

        return itemObj;
    }

    public Object[] generateItemObject(int index, ItemEntity itemEntity){
        Object[] itemObj = new Object[9];
        itemObj[0] = index;
        itemObj[1] = itemEntity.name;
        itemObj[2] = itemEntity.code;
        itemObj[3] = itemEntity.type;
        itemObj[4] = itemEntity.provider;
        itemObj[5] = itemEntity.quantity;
        itemObj[6] = itemEntity.priceImport;
        itemObj[7] = itemEntity.priceExport;
        itemObj[8] = itemEntity.note;

        return itemObj;
    }
}
