package com.dream.city.base.model.enu;

/**
 * @author Wvv
 */

public enum ReturnStatus {
    SUCCESS(200,"成功"),
    CLOSE(512,"已关闭"),
    INVALID(-1,"不可用"),
    ACCOUNT_PASS_REQUIRED(401,"请输入用户名和密码"),
    ERROR_PHONE(402,"请输入正确的手机号码"),
    PHONE_REQUIRED(403,"请输入手机号"),
    CODE_REQUIRED(404,"请输入验证码"),
    ERROR_CHARS(405,"8-16位字符,可包含数字,字母,下划线"),
    ERROR(500,"服务错误"),
    ACCOUNT_EXISTS(501,"账号存在"),
    NICK_EXISTS(502,"昵称存在"),
    ERROR_INVITE(503,"邀请码错误"),
    ERROR_CODE(504,"验证码错误"),
    CODE_EXPIRED(505,"验证码过期"),
    ERROR_ACCOUNT(506,"已账号或密码错误"),
    ERROR_RECEIVED(507,"获取失败"),
    SET_SUCCESS(200,"设置成功"),
    SET_FAILED(509,"设置失败"),
    WAITE_OPT(200,"操作成功，请耐心等待审核"),
    RETRY_OPT(511,"操作失败，请重试");

    // 成员变量
    private int status;
    private String desc;

    ReturnStatus(int status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public String getCode() {
        return this.name();
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}