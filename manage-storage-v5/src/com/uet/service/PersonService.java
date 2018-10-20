/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uet.service;

import com.uet.dao.DataLoader;
import com.uet.model.PersonEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Storm Spirit
 */
public class PersonService extends DataLoader {
    private DataLoader dataLoader;
    private String type;

    public PersonService(DataLoader dataLoader, String type){
        this.dataLoader = dataLoader;
        this.type = type;
    }

    public void save(PersonEntity personEntity){
        try {
            dataLoader.insertPerson(personEntity, type);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List convertData() throws SQLException {
        List<PersonEntity> personEntities = dataLoader.resolvePersonsByType(type);

        return personEntities == null ? new ArrayList(): personEntities;
    }

    public Object[][] generatePersonObject(List<PersonEntity> personEntities) {
        Object[][] personObj = new Object[personEntities.size()][7];

        for(int i = 0; i < personEntities.size(); i++){
            personObj[i][0] = i + 1;
            personObj[i][1] = personEntities.get(i).name;
            personObj[i][2] = personEntities.get(i).address;
            personObj[i][3] = personEntities.get(i).phone;
            personObj[i][4] = personEntities.get(i).createdAt;
            personObj[i][5] = personEntities.get(i).total;
            personObj[i][6] = personEntities.get(i).note;
        }

        return personObj;
    }

    public Object[] generatePersonObject(int index, PersonEntity personEntity){
        Object[] personObj = new Object[7];
        personObj[0] = index;
        personObj[1] = personEntity.name;
        personObj[2] = personEntity.address;
        personObj[3] = personEntity.phone;
        personObj[4] = personEntity.createdAt;
        personObj[5] = personEntity.total;
        personObj[6] = personEntity.note;

        return personObj;
    }
}
