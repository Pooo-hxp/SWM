package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.change;

public interface changedao {
	public String delete(String StaffNum);
    public String insert(String StaffNum,String ChangeNum,String DeptNum,String ChangeFont);
    public String update(String StaffNum,String State);
    public change select(String StaffNum);
    public ArrayList<change> select();
}
