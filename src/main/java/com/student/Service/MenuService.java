package com.student.Service;

import com.student.Dao.MenuDao;
import com.student.Pojo.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao = new MenuDao();
    public List<Menu> getLeftList(int roleId) {
        return menuDao.getLeftList(roleId);
    }
}
