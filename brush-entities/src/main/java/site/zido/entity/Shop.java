package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/8 0008
 */
@TableName("brush_shop")
public class Shop extends Model<Shop> {
    private String id;
    private String shopName;
    private String shopType;
    private String shopUrl;
    private String platformId;
    private String userId;
    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getId() {
        return id;
    }

    public Shop setId(String id) {
        this.id = id;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public Shop setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getShopType() {
        return shopType;
    }

    public Shop setShopType(String shopType) {
        this.shopType = shopType;
        return this;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public Shop setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
        return this;
    }

    public String getPlatformId() {
        return platformId;
    }

    public Shop setPlatformId(String platformId) {
        this.platformId = platformId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Shop setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
