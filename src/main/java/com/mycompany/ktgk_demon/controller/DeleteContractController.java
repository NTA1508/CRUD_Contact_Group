/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ktgk_demon.controller;

import com.mycompany.ktgk_demon.database.DBConnect;
import com.mycompany.ktgk_demon.implement.ContactServiceImplement;
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
@WebServlet("/delete_contact")
public class DeleteContractController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            ContactServiceImplement cs = new ContactServiceImplement(DBConnect.getConnection());
            boolean boo = cs.deleteContacts(id);
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
