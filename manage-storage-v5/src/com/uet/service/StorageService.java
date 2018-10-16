package com.uet.service;

import com.uet.model.StorageEntity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageService {
  private FileUtil fileUtil;

  public StorageService(String fileName){
    fileUtil = new FileUtil(fileName);
  }

  public void save(List<StorageEntity> storageEntities){
    try {
      List<String> data = new ArrayList<>();

      for(StorageEntity storeEntity: storageEntities){
        data.add(storeEntity.toString());
      }
      fileUtil.writeData(data);
    } catch (Exception e){}
  }

  public List convertData() throws IOException {
    List<StorageEntity> storageEntities = new ArrayList<>();

    List<String[]> dataFromFile = fileUtil.readData();
    for(String[] arr: dataFromFile){
      StorageEntity storageEntity = new StorageEntity();
      storageEntity.name = arr[0];
      storageEntity.code = arr[1];
      storageEntity.person = arr[2];
      storageEntity.createdAt = arr[3];
      storageEntity.type = arr[4];
      storageEntity.quantity = Integer.parseInt(arr[5]);
      storageEntity.price = Integer.parseInt(arr[6]);
      storageEntity.total = Integer.parseInt(arr[7]);

      try{
        storageEntity.note = arr[7];
      } catch (Exception e){
        storageEntity.note = "";
      }


      storageEntities.add(storageEntity);
    }

    return storageEntities;
  }

  public Object[][] generateStoreObject(List<StorageEntity> storageEntities){
    Object[][] storeObj = new Object[storageEntities.size()][9];
    for(int i = 0; i < storageEntities.size(); i++){
      storeObj[i][0] = i + 1;
      storeObj[i][1] = storageEntities.get(i).name;
      storeObj[i][2] = storageEntities.get(i).code;
      storeObj[i][3] = storageEntities.get(i).person;
      storeObj[i][4] = storageEntities.get(i).createdAt;
      storeObj[i][5] = storageEntities.get(i).type;
      storeObj[i][6] = storageEntities.get(i).quantity;
      storeObj[i][7] = storageEntities.get(i).price;
      storeObj[i][8] = storageEntities.get(i).total;

    }

    return storeObj;
  }
}
