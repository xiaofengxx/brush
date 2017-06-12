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
	 * 介绍人姓名
	 */
	@TableField(exist = false)
	private String introduceName;
    /**
     * 商家名
     */
	private String nickname;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Long getId() {
		return id;
	}

	public BusinessUser setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public BusinessUser setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Integer getSort() {
		return sort;
	}

	public BusinessUser setSort(Integer sort) {
		this.sort = sort;
		return this;
	}

	public Integer getState() {
		return state;
	}

	public BusinessUser setState(Integer state) {
		this.state = state;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public BusinessUser setCreateTime(Date createTime) {
		this.createTime = createTime;
		this.setCreateTimeLabel(DateUtils.formatDateTime(createTime));
		return this;
	}

	public String getCreateTimeLabel() {
		return createTimeLabel;
	}

	public BusinessUser setCreateTimeLabel(String createTimeLabel) {
		this.createTimeLabel = createTimeLabel;
		return this;
	}

	public String getContactName() {
		return contactName;
	}

	public BusinessUser setContactName(String contactName) {
		this.contactName = contactName;
		return this;
	}

	public String getQq() {
		return qq;
	}

	public BusinessUser setQq(String qq) {
		this.qq = qq;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public BusinessUser setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getWechat() {
		return wechat;
	}

	public BusinessUser setWechat(String wechat) {
		this.wechat = wechat;
		return this;
	}

	public Long getIntroduceId() {
		return introduceId;
	}

	public BusinessUser setIntroduceId(Long introduceId) {
		this.introduceId = introduceId;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public BusinessUser setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getIntroduceName() {
		return introduceName;
	}

	public BusinessUser setIntroduceName(String introduceName) {
		this.introduceName = introduceName;
		return this;
	}
}
