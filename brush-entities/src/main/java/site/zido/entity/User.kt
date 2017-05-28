package site.zido.entity

import com.baomidou.mybatisplus.activerecord.Model
import com.baomidou.mybatisplus.annotations.TableName
import java.io.Serializable

/**
 * description:
 * <p>fill description</p>
 * @author zido
 * date: 2017/5/25 0025 11:59
 */
@TableName("brush_user")
class User : Model<User>() {
    var id : Int? = null
    var name : String? = null
    override fun pkVal(): Serializable? {
        return this.id
    }

}