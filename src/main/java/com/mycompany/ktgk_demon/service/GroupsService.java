/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.service;
import com.mycompany.ktgk_demon.models.Group;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface GroupsService {
    public boolean addGroup(Group group);
    public List<Group> getGroup();
    public Group getGroupByID(int id);
    
}
