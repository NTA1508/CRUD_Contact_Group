/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.controller;

import com.mycompany.ktgk_demon.database.DBConnect;
import com.mycompany.ktgk_demon.implement.ContactServiceImplement;
import com.mycompany.ktgk_demon.models.Contacts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/add_contact")
public class AddContactController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int groupId = Integer.parseInt(req.getParameter("groupId"));
            String phoneNumber = req.getParameter("phoneNumber");
            
            Contacts contact = new Contacts(firstName, lastName, groupId, phoneNumber);
            ContactServiceImplement cs = new ContactServiceImplement(DBConnect.getConnection());
            
            boolean boo = cs.addContacts(contact);
            if(boo){
                resp.sendRedirect("/KTGK_Demon/index.jsp");
            }else{
                resp.sendRedirect("/KTGK_Demon/add_contact.jsp");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
