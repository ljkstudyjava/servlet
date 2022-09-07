package com.student.Service;

import com.student.Dao.StudentDao;
import com.student.Dao.UserDao;
import com.student.Pojo.Code;
import com.student.Pojo.DoRegisterInfo;
import com.student.Pojo.Result;
import com.student.Pojo.User;

import static com.student.Pojo.Code.*;

public class UserService {
    private final UserDao userDao = new UserDao();

    private final StudentDao studentDao = new StudentDao();

    public Result login(String userName, String password) {
        if (userName == null || "".equals(userName)) {
            return new Result(Code.Login_Error, Code.Login_nameNull_Error);
        }
        if (password == null || "".equals(password)) {
            return new Result(Code.Login_Error, Code.Login_psdNull_Error);
        }
        User user = userDao.getByName(userName);
//        System.out.println(user);
        if (user.getUserName() == null) {
            return new Result(Code.Login_Error, Code.Login_nameAppear_Error);
        }
        if (user.getPassword().equals(password)) {
//            登录成功
            return new Result(Code.Login_Success, Code.Login_Sql_Succ, user);
        } else {
            return new Result(Code.Login_Error, Code.Login_psd_Error);
        }
    }

    public Result doRegister(DoRegisterInfo doRegisterInfo) {

        //用户名判空
        if (doRegisterInfo.getUserName() == null || "".equals(doRegisterInfo.getUserName())) {
            return new Result(ERROR_CODE_EMPTY_USERNAME, ERROR_MSG_EMPTY_USERNAME);
        }

        //密码判空
        if (doRegisterInfo.getPassword() == null || "".equals(doRegisterInfo.getPassword())) {
            return new Result(ERROR_CODE_EMPTY_PASSWORD, ERROR_MSG_EMPTY_PASSWORD);
        }

        //姓名判空
        if (doRegisterInfo.getSname() == null || "".equals(doRegisterInfo.getSname())) {
            return new Result(ERROR_CODE_EMPTY_SNAME, ERROR_MSG_EMPTY_SNAME);
        }

        //判断用户名是否存在，
        if (userDao.getUserName(doRegisterInfo.getUserName())) {
            //注册
            return userDao.doRegister(doRegisterInfo);
        }

        //否则用户已存在
        return new Result(ERROR_CODE_USER_EXIST, ERROR_MSG_USER_EXIST);
    }

    public void doInsertStudent(DoRegisterInfo doRegisterInfo) {
        studentDao.doInsertStudent(doRegisterInfo);
    }
}
