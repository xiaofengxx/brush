 package site.zido.dto

 import site.zido.entity.BankCard
 import java.util.*
 import kotlin.collections.ArrayList

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


    var bankCards:List<BankCard>? = ArrayList()

     /**
      * 职业
      */
     var name:String = ""
 }