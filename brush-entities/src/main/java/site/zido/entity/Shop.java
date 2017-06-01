package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 店铺信息表
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_shop")
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

	private Long id;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
