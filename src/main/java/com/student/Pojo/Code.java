package com.student.Pojo;

public class Code {
    public static final String Register_nameAppear_Error = "用户名已存在";
    public static final String Register_nameNull_Error = "用户名不能为空";
    public static final String Register_psdNull_Error = "密码不能为空";
    public static final String Register_Sql_Error = "操作失败";
    public static final String Register_Sql_Succ = "注册成功";
    public static final int Register_Success = 100;
    public static final int Register_Error = 101;


    public static final String Login_psd_Error = "密码错误";
    public static final String Login_nameAppear_Error = "用户名不存在";
    public static final String Login_nameNull_Error = "用户名不能为空";
    public static final String Login_psdNull_Error = "密码不能为空";
//    public static final String Login_Sql_Error = "操作失败";
    public static final String Login_Sql_Succ = "登录成功";
    public static final int Login_Success = 200;
    public static final int Login_Error = 201;


    public static final int SUCCESS_CODE = 400;//通用成功码
    public static final String SUCCESS_MSG = "成功";//通用成功码

    public static final int DB_SUCCESS_CODE = 200;

    public static final int DB_ERROR_CODE = 101;

    public static final String DB_SUCCESS_MSG = "成功";

    public static final String DB_ERROR_MSG_INSERT = "插入失败";

    public static final int PageNumber_Defined=1;
    public static final int PageSize_Defined=3;


    public static final int ERROR_CODE_EMPTY_USERNAME = 103;
    public static final String ERROR_MSG_EMPTY_USERNAME = "用户名为空";

    public static final int ERROR_CODE_EMPTY_PASSWORD = 104;

    public static final String ERROR_MSG_EMPTY_PASSWORD = "密码为空";

    public static final int ERROR_CODE_EMPTY_SNAME = 105;

    public static final String ERROR_MSG_EMPTY_SNAME = "姓名不能为空";

    public static final int ERROR_CODE_USER_EXIST = 106;

    public static final String ERROR_MSG_USER_EXIST = "该用户已存在";

    public static final int SUCCESS_CODE_NOT_UNQUALIFIED_SCORE = 107;
    public static final String SUCCESS_MSG_NOT_UNQUALIFIED_SCORE ="恭喜全部合格";


}
