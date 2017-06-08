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
@TableName("brush_user")
public class User extends Model<User>{
    private String id;
    private String username;
    private String password;
    private Integer enabled;
    private String ip;
    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return id;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public User setEnabled(Integer enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public User setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
