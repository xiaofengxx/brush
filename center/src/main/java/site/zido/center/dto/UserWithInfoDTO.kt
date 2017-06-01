 package site.zido.dto

 import java.util.*

 /**
 * Created by CDDC on 2017/6/1.
 */
class UserWithInfoDTO{
    /**
     * 用户id
     */
    var id: Long? = null
    /**
     * 登陆用户名
     */
    var username: String = ""
    /**
     * 用户昵称
     */
    var nickname: String = ""
    /**
     * 账号是否可用
     */
    var enabled: Int = 1
    /**
     * 用户密码
     */
    var password: String = "123456"
     /**
      * 序号
      */
    var sort:Int? = null

    var state:Int? = null

    var createTime:Date? = null

     /**
      * 银行账户
      */
     var bankCarNumber:String = ""
     /**
      * 持卡人姓名
      */
     var bindname:String = ""
 }