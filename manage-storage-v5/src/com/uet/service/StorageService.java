package com.uet.service;

import com.uet.dao.DataLoader;
import com.uet.model.StorageEntity;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageService extends DataLoader {
  private String type;
  private DataLoader dataLoader;

  public StorageService(DataLoader dataLoader, String type){
    this.dataLoader = dataLoader;
    this.type = type;
  }

  public void save(StorageEntity storageEntity){
    try {
      dataLoader.insertStorage(storageEntity, type);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public List convertData() throws SQLException {
    List<StorageEntity> storageEntities = dataLoader.resolveStoragesByType(type);
    return storageEntities;
  }

  public Object[][] generateStoreObject(List<StorageEntity> storageEntities){
    Object[][] storeObj = new Object[storageEntities.size()][9];
    for(int i = 0; i < storageEntities.size(); i++){
      storeObj[i][0] = i + 1;
      storeObj[i][1] = storageEntities.get(i).name;
      storeObj[i][2] = storageEntities.get(i).code;
      storeObj[i][3] = storageEntities.get(i).type;
      storeObj[i][4] = storageEntities.get(i).person;
      storeObj[i][5] = storageEntities.get(i).quantity;
      storeObj[i][6] = storageEntities.get(i).price;
      storeObj[i][7] = storageEntities.get(i).total;
      storeObj[i][8] = storageEntities.get(i).createdAt;

    }

    return storeObj;
  }

  public Object[] generateStoreObject(int index, StorageEntity storageEntity){
    Object[] storeObj = new Object[9];
    storeObj[0] = index;
    storeObj[1] = storageEntity.name;
    storeObj[2] = storageEntity.code;
    storeObj[3] = storageEntity.type;
    storeObj[4] = storageEntity.person;
    storeObj[5] = storageEntity.quantity;
    storeObj[6] = storageEntity.price;
    storeObj[7] = storageEntity.total;
    storeObj[8] = storageEntity.createdAt;

    return storeObj;
  }
}
