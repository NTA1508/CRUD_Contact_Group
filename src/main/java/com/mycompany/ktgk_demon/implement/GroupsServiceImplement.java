/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.implement;

import com.mycompany.ktgk_demon.models.Group;
import com.mycompany.ktgk_demon.service.GroupsService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GroupsServiceImplement implements GroupsService {

    private Connection connect;

    public GroupsServiceImplement(Connection connect) {
        this.connect = connect;
    }

    @Override
    public boolean addGroup(Group group) {
        boolean boo = false;
        try {
            String sql = "insert into group_db(groupName, desription) values (?, ?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, group.getGroupName());
            ps.setString(2, group.getDesription());

            int i = ps.executeUpdate();
            if (i == 1) {
                boo = true;
            }
            System.out.println(boo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boo;
    }

    @Override
    public List<Group> getGroup() {
        List<Group> groupList = new ArrayList<Group>();
        Group group = null;
        try {
            String sql = "Select * from group_db";
            PreparedStatement ps = connect.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                group = new Group();
                group.setId(rs.getInt(1));
                group.setGroupName(rs.getString(2));
                group.setDesription(rs.getString(3));
                groupList.add(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupList;
    }

    @Override
    public Group getGroupByID(int id) {
        Group group = null;
        try {
            String sql = "select * from group_db where id=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                group = new Group();
                group.setId(rs.getInt(1));
                System.out.println("Id" + group.getId());
                group.setGroupName(rs.getString(2));
                group.setDesription(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return group;
    }

}
