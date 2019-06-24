package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.CheckInfo;

public interface CheckInfodao {
	public String delete(String StaffNum);
    public String insert(String StaffNum,String Sleep,String OverTime);
    public String update(String StaffNum,String Sleep,String OverTime,String Payroll);
    public CheckInfo select(String StaffNum);
    public ArrayList<CheckInfo> select();
}
