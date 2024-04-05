/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.models;

/**
 *
 * @author Admin
 */
public class Group {
    private int id;
    private String groupName;
    private String desription;

        public Group(String groupName, String desription) {
        this.groupName = groupName;
        this.desription = desription;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", groupName=" + groupName + ", desription=" + desription + '}';
    }
    
}
