/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.test.crudjsf.controller;

import com.crud.test.crudjsf.model.User;
import com.crud.test.crudjsf.service.UserDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Rishabh
 */
@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

    private List<User> allUsers;
    private User selectedUser;
    private User newUser;
    private UserDAO userDAO;

    public UserBean() {
        this.userDAO = new UserDAO();
        this.allUsers = userDAO.getAllUsers();
        this.newUser = new User();
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public void addUser() {
        userDAO.insertUser(newUser);
        allUsers.add(newUser);
        newUser = new User();
        PrimeFaces.current().executeScript("PF('addUserDialog').hide()");
    }

    public void editUser(User user) {
        selectedUser = user;
        PrimeFaces.current().executeScript("PF('editUserDialog').show()");
    }

    public void updateUser() {
        userDAO.updateUser(selectedUser);
        PrimeFaces.current().executeScript("PF('editUserDialog').hide()");
    }

    public void deleteUser(User user) {
        userDAO.deleteUser(user.getId());
        allUsers.remove(user);
    }

    public void cancelAddUser() {
        newUser = new User();
        PrimeFaces.current().executeScript("PF('addUserDialog').hide()");
    }

    public void cancelEditUser() {
        selectedUser = null;
        PrimeFaces.current().executeScript("PF('editUserDialog').hide()");
    }

    public void cancelDeleteUser() {
        selectedUser = null;
        PrimeFaces.current().executeScript("PF('deleteUserDialog').hide()");
    }

    public void showAddUserDialog() {
        PrimeFaces.current().executeScript("PF('addUserDialog').show()");
    }

    public String navigateToAddUser() {
        // Navigate to addUser.xhtml
        return "addUser";
    }
    
    public String navigateToDeleteUser() {
        // Navigate to deleteUser.xhtml
        return "deleteUser";
    }
    
}
