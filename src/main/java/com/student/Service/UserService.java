package com.student.Service;

import com.student.Dao.UserDao;
import com.student.Pojo.Code;
import com.student.Pojo.Result;
import com.student.Pojo.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public Result login(String userName, String password) {
        if(userName == null || "".equals(userName)){
            return new Result(Code.Login_Error,Code.Login_nameNull_Error);
        }
        if(password == null || "".equals(password)){
            return new Result(Code.Login_Error,Code.Login_psdNull_Error);
        }
        User user = userDao.getByName(userName);
//        System.out.println(user);
        if(user.getUserName() == null){
            return new Result(Code.Login_Error,Code.Login_nameAppear_Error);
        }
        if (user.getPassword().equals(password)){
//            登录成功
            return new Result(Code.Login_Success,Code.Login_Sql_Succ,user);
        }else {
            return new Result(Code.Login_Error,Code.Login_psd_Error);
        }
    }
}
