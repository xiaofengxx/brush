package site.zido.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zido
 * @since 2017-06-22
 */
@TableName("brush_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 管理员名字
     */
	@TableField("ad_name")
	private String adName;
    /**
     * 管理员拼音名字
     */
	@TableField("ad_pname")
	private String adPname;
    /**
     * 管理员年龄
     */
	@TableField("ad_age")
	private Integer adAge;
    /**
     * 管理员性别
     */
	@TableField("ad_sex")
	private Integer adSex;
    /**
     * 管理员电话
     */
	@TableField("ad_phonenumber")
	private String adPhonenumber;
    /**
     * 管理员身份证
     */
	@TableField("ad_idcard")
	private String adIdcard;
	@TableField("ad_card_front_url")
	private String adCardFrontUrl;
	@TableField("ad_card_behind_url")
	private String adCardBehindUrl;
	@TableField("ad_state")
	private Integer adState;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdPname() {
		return adPname;
	}

	public void setAdPname(String adPname) {
		this.adPname = adPname;
	}

	public Integer getAdAge() {
		return adAge;
	}

	public void setAdAge(Integer adAge) {
		this.adAge = adAge;
	}

	public Integer getAdSex() {
		return adSex;
	}

	public void setAdSex(Integer adSex) {
		this.adSex = adSex;
	}

	public String getAdPhonenumber() {
		return adPhonenumber;
	}

	public void setAdPhonenumber(String adPhonenumber) {
		this.adPhonenumber = adPhonenumber;
	}

	public String getAdIdcard() {
		return adIdcard;
	}

	public void setAdIdcard(String adIdcard) {
		this.adIdcard = adIdcard;
	}

	public String getAdCardFrontUrl() {
		return adCardFrontUrl;
	}

	public void setAdCardFrontUrl(String adCardFrontUrl) {
		this.adCardFrontUrl = adCardFrontUrl;
	}

	public String getAdCardBehindUrl() {
		return adCardBehindUrl;
	}

	public void setAdCardBehindUrl(String adCardBehindUrl) {
		this.adCardBehindUrl = adCardBehindUrl;
	}

	public Integer getAdState() {
		return adState;
	}

	public void setAdState(Integer adState) {
		this.adState = adState;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
