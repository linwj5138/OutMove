package com.project.tank.outmove.utils;

/**
 * @description: Urls
 * @auther linweijie
 * @time 2018/10/31 17:14
 */

public class Urls {
    private static String baseUrl = "http://www.gxhsc.cn/wf/outbound/api/";

    //登录
    private static String loginUrl = baseUrl + "appLogin?LOGINID=maonan&PASSWORD=123456";

    //查询外访记录列表
    private static String taskListUrl = baseUrl + "getOutRecordList?OPERUSERID=1&STATUS=1";

    //查询案件基本信息
    private static String taskDetailUrl = baseUrl + "getCaseDetail?CASENO=EDS0258369000";

    //查询案件联系人列表
    private static String contactListUrl = baseUrl + "getContactList?CASENO=f06b21e028026dea1fdb3c339ec3a1f5";

    //查询电催记录列表
    private static String telRecordListUrl = baseUrl + "getTelRecordList?CASENO=12e2a64e2ac07f504fc99a7cd5b4f8ce";

    //查询还款记录列表
    private static String backMoneyListUrl = baseUrl + "getBackMoneyList?CASENO=123";

    //更新外访记录
    private static String updateOutRecordUrl = baseUrl + "updateOutRecord?CASENO=123";

    //上报APP外访轨迹
    private static String uplaodLocationUrl = baseUrl + "uploadLocation?LONGITUDE=1&LATITUDE=2&INPUTTIME=2018/12/12 22:22:22";

    //检查版本更新
    private static String checkUpdateUrl = baseUrl + "checkUpdate?VERSION=123";

    //APP签到
    private static String singInUrl = baseUrl + "signIn";

    //APP退出
    private static String loginOut = baseUrl + "api/appLogout";
}
