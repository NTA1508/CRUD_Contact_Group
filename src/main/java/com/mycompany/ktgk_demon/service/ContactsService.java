/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.service;
import com.mycompany.ktgk_demon.models.Contacts;

/**
 *
 * @author Admin
 */
import java.util.List;
public interface ContactsService {
    public boolean addContacts(Contacts contacts);
    public List <Contacts> getContacts();
    public boolean updateContacts(Contacts contacts);
    public boolean deleteContacts(int id);
    public Contacts getContactsByID(int id);
}
