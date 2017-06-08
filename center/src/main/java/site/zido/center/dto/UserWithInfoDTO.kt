 package site.zido.center.dto

 import site.zido.entity.BankCard
 import java.util.*
 import kotlin.collections.ArrayList

 /**
 * Created by CDDC on 2017/6/1.
 */
class UserWithInfoDTO {
    /**
     * 用户昵称
     */
    var nickname: String = ""


    var bankCards:List<BankCard>? = ArrayList()

     /**
      * 职业
      */
     var CareerName:String = ""
 }