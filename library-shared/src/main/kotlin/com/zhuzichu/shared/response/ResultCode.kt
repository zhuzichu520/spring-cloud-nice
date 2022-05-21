package com.zhuzichu.shared.response

enum class ResultCode(
    val code: Int,
    val message: String
) {

    /**
     * 通用类
     */
    RC200(200, "成功"),
    RC999(999, "失败"),
    RC403(403, "没有操作权限"),
    RC401(401, "登录失效"),
    RC40004(40004, "业务处理失败"),
    RC800(800,"用户名错误"),
    RC801(801,"密码不正确"),

    /**
     * 服务类
     */
    RC500(500, "服务器内部错误"),
    RC503(503, "服务器正忙，请稍后再试"),
    RC504(504, "请求方法不支持"),
    RC505(505, "类型转换异常"),
    RC404(404, "未找到该资源"),
    RC3001(3001, "网关异常"),
    RC3002(3002, "签名异常"),
    RC506(506, "解密出现异常"),
    RC507(507, "存在NULL值"),
    RC508(508, "上传文件过大"),
    RC509(509, "网络不给力"),

}