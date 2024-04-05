/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.implement;

import com.mycompany.ktgk_demon.models.Contacts;
import com.mycompany.ktgk_demon.service.ContactsService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ContactServiceImplement implements ContactsService {

    private Connection connect;

    public ContactServiceImplement(Connection connect) {
        this.connect = connect;
    }

    @Override
    public boolean addContacts(Contacts contacts) {
        boolean boo = false;
        try {
            String sql = "insert into contact_db(firstName, lastName, groupId, phoneNumber) values(?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, contacts.getFirstName());
            ps.setString(2, contacts.getLastName());
            ps.setInt(3, contacts.getGroupId());
            ps.setString(4, contacts.getPhoneNumber());

            int i = ps.executeUpdate();
            if (i == 1) {
                boo = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boo;
    }

    @Override
    public List<Contacts> getContacts() {
        List<Contacts> contactList = new ArrayList<Contacts>();
        Contacts contact = null;
        try {
            String sql = "select * from contact_db";
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contact = new Contacts();
                contact.setId(rs.getInt(1));
                contact.setFirstName(rs.getString(2));
                contact.setLastName(rs.getString(3));
                contact.setGroupId(rs.getInt(4));
                contact.setPhoneNumber(rs.getString(5));
                contactList.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactList;
    }

    @Override
    public boolean updateContacts(Contacts contacts) {
        boolean boo = true;
        try {
            String sql = "update contact_db set firstName=?, lastName=?, groupId=?, phoneNumber=? where id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, contacts.getFirstName());
            ps.setString(2, contacts.getLastName());
            ps.setInt(3, contacts.getGroupId());
            ps.setString(4, contacts.getPhoneNumber());
            ps.setInt(5, contacts.getId());

            int i = ps.executeUpdate();
            if (i == 1) {
                boo = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================" + boo);
        return boo;
    }

    @Override
    public Contacts getContactsByID(int id) {
        Contacts contact = null;
        try {
            String sql = "select * from contact_db where id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contact = new Contacts();
                contact.setId(rs.getInt(1));
                contact.setFirstName(rs.getString(2));
                contact.setLastName(rs.getString(3));
                contact.setGroupId(rs.getInt(4));
                contact.setPhoneNumber(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public boolean deleteContacts(int id) {
        boolean boo =false;
        try{
            String sql = "delete from contact_db where id =?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            
            int  i =ps.executeUpdate();
            if(i == 1){
                boo = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return boo;
    }

}
