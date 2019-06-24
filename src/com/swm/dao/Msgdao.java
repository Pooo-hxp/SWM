package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.Msg;

public interface Msgdao {
	public String delete();
    public String insert(String StaffNum,String StaffName,String Txt,String DateTime);
    public String update();
    public Msg select();
    public ArrayList<Msg> select(String StaffNum,String StaffNum1);
}
