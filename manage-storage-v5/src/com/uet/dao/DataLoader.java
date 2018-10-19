package com.uet.dao;

import com.uet.model.ItemEntity;
import com.uet.model.PersonEntity;
import com.uet.model.StorageEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    Connection connection;
    Statement st;
    ResultSet rs;

    public DataLoader(){
        connection = new DBConnection().createConnection();
    }

    public List<PersonEntity> resolvePersonsByType(String type) throws SQLException {
        List<PersonEntity> personEntities = new ArrayList<>();

        String sql = "SELECT * FROM person";
        st = connection.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()){
            PersonEntity personEntity = new PersonEntity();
            personEntity.id = rs.getInt("id");
            personEntity.name = rs.getString("name");
            personEntity.address = rs.getString("address");
            personEntity.total = rs.getInt("total");
            personEntity.phone = rs.getString("phone");
            personEntity.createdAt = rs.getString("created_at");
            personEntity.note = rs.getString("note");

            if(rs.getString("type").equals(type)){
                personEntities.add(personEntity);
            }
        }

        return personEntities;
    }

    public void updatePerson(PersonEntity personEntity) {
        try{
            String sql = "UPDATE person set name = ?, address = ?, total = ?, phone = ?, note = ? where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, personEntity.name);
            ((PreparedStatement) st).setString(2, personEntity.address);
            ((PreparedStatement) st).setInt(3, personEntity.total);
            ((PreparedStatement) st).setString(4, personEntity.note);
            ((PreparedStatement) st).execute();
        } catch (Exception e){}
    }

    public boolean insertPerson(PersonEntity personEntity, String type) throws SQLException {
        String sql = "INSERT into person (name, address, total, phone, created_at, note, type) values (?, ?, ?, ?, ?, ?, ?)";
        st = connection.prepareStatement(sql);
        ((PreparedStatement) st).setString(1, personEntity.name);
        ((PreparedStatement) st).setString(2, personEntity.address);
        ((PreparedStatement) st).setInt(3, personEntity.total);
        ((PreparedStatement) st).setString(4, personEntity.phone);
        ((PreparedStatement) st).setString(5, personEntity.createdAt);
        ((PreparedStatement) st).setString(6, personEntity.note);
        ((PreparedStatement) st).setString(7, type);
        return ((PreparedStatement) st).execute();
    }

    public void deletePerson(PersonEntity personEntity) {
        try{
            String sql = "delete from person where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setInt(1, personEntity.id);
            ((PreparedStatement) st).execute();
        } catch (Exception e){}
    }

    public List<StorageEntity> resolveStoragesByType(String type) throws SQLException {
        List<StorageEntity> storageEntities = new ArrayList<>();

        String sql = "SELECT * FROM storage";
        st = connection.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()){
            StorageEntity storageEntity = new StorageEntity();
            storageEntity.id = rs.getInt("id");
            storageEntity.name = rs.getString("name");
            storageEntity.code = rs.getString("code");
            storageEntity.total = rs.getInt("total");
            storageEntity.person = rs.getString("person");
            storageEntity.createdAt = rs.getString("created_at");
            storageEntity.note = rs.getString("note");
            storageEntity.type = rs.getString("type");
            storageEntity.quantity = rs.getInt("quantity");
            storageEntity.price = rs.getInt("price");

            if (rs.getString("type_data").equals(type))
                storageEntities.add(storageEntity);
        }

        return storageEntities;
    }

    public void updateStorage(StorageEntity storageEntity) {
        try {
            String sql = "UPDATE storage set name = ?, code = ?, total = ?, person = ?, create_at = ?, note = ?, type = ?, quantity = ?, price = ? where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, storageEntity.name);
            ((PreparedStatement) st).setString(2, storageEntity.code);
            ((PreparedStatement) st).setInt(3, storageEntity.total);
            ((PreparedStatement) st).setString(4, storageEntity.person);
            ((PreparedStatement) st).setString(5, storageEntity.createdAt);
            ((PreparedStatement) st).setString(6, storageEntity.note);
            ((PreparedStatement) st).setString(7, storageEntity.type);
            ((PreparedStatement) st).setInt(8, storageEntity.quantity);
            ((PreparedStatement) st).setInt(9, storageEntity.price);
            ((PreparedStatement) st).setInt(10, storageEntity.id);

            ((PreparedStatement) st).execute();
        } catch (Exception e){}
    }

    public boolean insertStorage(StorageEntity storageEntity, String type) throws SQLException {
        String sql = "INSERT into storage (name, code, total, person, created_at, note, type, quantity, price, type_data) values (?, ?, ?, ?, ?, ?, ?)";
        st = connection.prepareStatement(sql);
        ((PreparedStatement) st).setString(1, storageEntity.name);
        ((PreparedStatement) st).setString(2, storageEntity.code);
        ((PreparedStatement) st).setInt(3, storageEntity.total);
        ((PreparedStatement) st).setString(4, storageEntity.person);
        ((PreparedStatement) st).setString(5, storageEntity.createdAt);
        ((PreparedStatement) st).setString(6, storageEntity.note);
        ((PreparedStatement) st).setString(7, storageEntity.type);
        ((PreparedStatement) st).setInt(8, storageEntity.quantity);
        ((PreparedStatement) st).setInt(9, storageEntity.price);
        ((PreparedStatement) st).setString(10, type);

        return ((PreparedStatement) st).execute();
    }

    public void deleteStorage(StorageEntity storageEntity) {
        try {
            String sql = "delete from storage where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setInt(1, storageEntity.id);
            ((PreparedStatement) st).execute();
        } catch (Exception e){}
    }

    public List<ItemEntity> resolveItems() throws SQLException {
        List<ItemEntity> itemEntities = new ArrayList<>();

        String sql = "SELECT * FROM item";
        st = connection.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()){
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.id = rs.getInt("id");
            itemEntity.name = rs.getString("name");
            itemEntity.code = rs.getString("code");
            itemEntity.type = rs.getString("type");
            itemEntity.provider = rs.getString("provider");
            itemEntity.quantity = rs.getInt("quantity");
            itemEntity.priceImport = rs.getInt("price_import");
            itemEntity.priceExport = rs.getInt("price_export");
            itemEntity.note = rs.getString("note");

            itemEntities.add(itemEntity);
        }

        return itemEntities;
    }

    public void updateItem(ItemEntity itemEntity) {
        try {
            String sql = "UPDATE person set name = ?, code = ?, type = ?, provider = ?, quantity = ?, priceImport = ?, priceExport = ?, note = ? where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setString(1, itemEntity.name);
            ((PreparedStatement) st).setString(2, itemEntity.code);
            ((PreparedStatement) st).setString(3, itemEntity.type);
            ((PreparedStatement) st).setString(4, itemEntity.provider);
            ((PreparedStatement) st).setInt(5, itemEntity.quantity);
            ((PreparedStatement) st).setInt(6, itemEntity.priceImport);
            ((PreparedStatement) st).setInt(7, itemEntity.priceExport);
            ((PreparedStatement) st).setString(7, itemEntity.note);
            ((PreparedStatement) st).execute();
        } catch (Exception e){}
    }

    public boolean insertItem(ItemEntity itemEntity) throws SQLException {
        String sql = "INSERT into item (name, code, type, provider, quantity, priceImport, priceExport, note) values (?, ?, ?, ?, ?, ?, ?)";
        st = connection.prepareStatement(sql);
        ((PreparedStatement) st).setString(1, itemEntity.name);
        ((PreparedStatement) st).setString(2, itemEntity.code);
        ((PreparedStatement) st).setString(3, itemEntity.provider);
        ((PreparedStatement) st).setInt(4, itemEntity.quantity);
        ((PreparedStatement) st).setInt(5, itemEntity.priceImport);
        ((PreparedStatement) st).setInt(6, itemEntity.priceExport);
        ((PreparedStatement) st).setString(7, itemEntity.note);
        return ((PreparedStatement) st).execute();
    }

    public void deleteItem(ItemEntity itemEntity) {
        try {
            String sql = "delete from item where id = ?";
            st = connection.prepareStatement(sql);
            ((PreparedStatement) st).setInt(1, itemEntity.id);
            ((PreparedStatement) st).execute();
        }catch (Exception e){}
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

}
