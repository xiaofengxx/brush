package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职业信息表
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_career")
public class Career extends Model<Career> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 职业名
     */
	private String name;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
