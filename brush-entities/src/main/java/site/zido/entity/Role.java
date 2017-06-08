package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 角色名
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
