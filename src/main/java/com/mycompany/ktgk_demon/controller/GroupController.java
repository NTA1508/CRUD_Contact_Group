/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.controller;

import com.mycompany.ktgk_demon.database.DBConnect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.ktgk_demon.models.Group;
import com.mycompany.ktgk_demon.implement.GroupsServiceImplement;
/**
 *
 * @author Admin
 */
@WebServlet("/add_group")
public class GroupController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String groupName = req.getParameter("group_name");
            String desription = req.getParameter("desription");
            
            Group group = new Group(groupName, desription);
            GroupsServiceImplement gs = new GroupsServiceImplement(DBConnect.getConnection());
            
            boolean boo = gs.addGroup(group);
            if(boo){
                System.out.println("Success");
                resp.sendRedirect("/KTGK_Demon/groups.jsp");
            }else{
                System.out.println("/KTGK_Demon/add_group.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
