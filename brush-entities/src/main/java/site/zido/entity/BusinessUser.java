package site.zido.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import site.zido.brush.utils.DateUtils;

import java.io.Serializable;

/**
 * <p>
 * 商家信息表
 * </p>
 *
 * @author zido
 * @since 2017-06-05
 */
@TableName("brush_business_user")
public class BusinessUser extends Model<BusinessUser> {

    private static final long serialVersionUID = 1L;

	private Long id;
	private Long userId;
    /**
     * 序号
     */
	private Integer sort;
    /**
     * 审核状态（0：未审核，1：审核通过，2：审核未通过）
     */
	private Integer state;
    /**
     * 入驻时间
     */
	private Date createTime;
	/**
	 * 格式化时间戳
	 */
	@TableField(exist=false)
	private String createTimeLabel;
    /**
     * 联系人姓名
     */
	private String contactName;
    /**
     * 联系QQ号
     */
	private String qq;
    /**
     * 联系手机号
     */
	private String phoneNumber;
    /**
     * 联系微信号
     */
	private String wechat;
    /**
     * 介绍人id（注意对应user表）
     */
	private Long introduceId;
    /**
     * 商家名
     */
	private String nickname;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.setCreateTimeLabel(DateUtils.formatDateTime(createTime));
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Long getIntroduceId() {
		return introduceId;
	}

	public void setIntroduceId(Long introduceId) {
		this.introduceId = introduceId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getCreateTimeLabel() {
		return createTimeLabel;
	}

	public BusinessUser setCreateTimeLabel(String createTimeLabel) {
		this.createTimeLabel = createTimeLabel;
		return this;
	}
}
