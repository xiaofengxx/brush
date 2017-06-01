package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model
import com.baomidou.mybatisplus.annotations.TableName

import java.io.Serializable

/**
 * 用户实体类
 * <p>用于账户认证，一般不用接触此类</p>
 *
 * @author zido
 * @since 2017/5/31 0031
 */
@TableName("brush_user")
class User : Model<User>() {
    /**
     * 用户id
     */
    var id: Long? = null
    /**
     * 登陆用户名
     */
    var username: String? = null
    /**
     * 用户昵称
     */
    var nickname: String? = null
    /**
     * 账号是否可用
     */
    var enabled: Int? = null
    /**
     * 用户密码
     */
    var password: String? = null

    var ip:String? = null

    /**
     * 主键值
     */
    override fun pkVal(): Serializable? {
        return this.id
    }
}
