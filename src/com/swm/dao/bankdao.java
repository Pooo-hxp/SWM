package com.swm.dao;

import java.util.ArrayList;

import com.swm.model.banklist;

public interface bankdao {
    public String delete(String IDNum);
    public String insert();
    public String update();
    public banklist select(String IDNum);
    public ArrayList<banklist> select();
}
