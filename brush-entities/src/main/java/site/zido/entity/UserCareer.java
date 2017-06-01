package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户与职业关联表
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_user_career")
public class UserCareer extends Model<UserCareer> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	private Long userId;
    /**
     * 职业id
     */
	private Long careerId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCareerId() {
		return careerId;
	}

	public void setCareerId(Long careerId) {
		this.careerId = careerId;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

}