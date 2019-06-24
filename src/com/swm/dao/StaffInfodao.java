package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.StaffInfo;

public interface StaffInfodao {
	public String delete(String StaffNum);
    public String insert(String StaffNum,String StaffName,String StaffSex,String StaffJob,String IDNum);
    public String update(String StaffNum,String DeptName);
    public StaffInfo select(String StaffNum);
    public ArrayList<StaffInfo> select();
}
