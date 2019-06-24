package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.user;


public interface userdao {
	public String delete(String StaffNum);
    public String insert(String StaffNum,String PassWord,String RoleID);
    public String update(String StaffNum,String PassWord);
    public String select(String StaffNum,String PassWord);
    public ArrayList<user> select();
}
