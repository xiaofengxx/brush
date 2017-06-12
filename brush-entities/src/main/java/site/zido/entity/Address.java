package site.zido.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 收货地址
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_address")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;
	
	private Long id;
    /**
     * 地址字符串
     */
	private String address;
    /**
     * 用户id
     */
	private Long userId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
