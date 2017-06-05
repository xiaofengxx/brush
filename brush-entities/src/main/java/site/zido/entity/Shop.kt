package site.zido.entity

import com.baomidou.mybatisplus.activerecord.Model
import com.baomidou.mybatisplus.annotations.TableName
import java.io.Serializable

/**
 * 店铺实体类
 * @author zido
 * @since 2017/6/4 0004
 */
@TableName("brush_shop")
class Shop : Model<Shop>() {
    /**
     * 主键值
     */
    override fun pkVal(): Serializable?{
        return id
    }

    var id: Long? = null

    var shopName: String? = null

    var shopType: String? = null

    var shopUrl: String? = null

    var platformId: Long? = null

    var userId: Long? = null
}