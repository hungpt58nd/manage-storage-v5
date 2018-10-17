package com.uet.service;

import com.uet.model.ItemEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private FileUtil fileUtil;

    public ItemService(String fileName){
        fileUtil = new FileUtil(fileName);
    }

    public void save(List<ItemEntity> itemEntities){
        try {
            List<String> data = new ArrayList<>();

            for(ItemEntity itemEntity: itemEntities){
                data.add(itemEntity.toString());
            }
            fileUtil.writeData(data);
        } catch (Exception e){}
    }

    public List convertData() throws IOException {
        List<ItemEntity> itemEntities = new ArrayList<>();

        List<String[]> dataFromFile = fileUtil.readData();
        for(String[] arr: dataFromFile){
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.name = arr[0];
            itemEntity.code = arr[1];
            itemEntity.type = arr[2];
            itemEntity.provider = arr[3];
            itemEntity.quantity = Integer.parseInt(arr[4]);
            itemEntity.priceImport = Integer.parseInt(arr[5]);
            itemEntity.priceExport = Integer.parseInt(arr[6]);

            try {
              itemEntity.note = arr[7];
            } catch (Exception e){
              itemEntity.note = "";
            }

            itemEntity.note = arr[7] != null ? arr[7]:"";

            itemEntities.add(itemEntity);
        }
        return itemEntities;
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
