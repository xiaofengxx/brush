package site.zido.entity;

import java.text.ParseException;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import site.zido.brush.utils.DateUtils;
import site.zido.brush.utils.IDCardToAgeUtils;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 刷手信息表
 * </p>
 *
 * @author zido
 * @since 2017-06-21
 */
@TableName("brush_subscriber_user")
public class SubscriberUser extends Model<SubscriberUser> {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 刷手手机号
	 */
	@TableField("phone_number")
	private String phoneNumber;
	/**
	 * 身份证正面图片URL
	 */
	@TableField("id_card_front_url")
	private String idCardFrontUrl;
	/**
	 * 身份证背面图片URL
	 */
	@TableField("id_card_behind_url")
	private String idCardBehindUrl;
	/**
	 * 身份证号
	 */
	@TableField("id_card")
	private String idCard;
	/**
	 * 真实姓名
	 */
	@TableField("real_name")
	private String realName;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 支付宝账号
	 */
	@TableField("ali_pay")
	private String aliPay;
	/**
	 * 阿里旺旺账号
	 */
	@TableField("ali_tm")
	private String aliTm;
	/**
	 * 微信账号
	 */
	private String wechat;
	/**
	 * 淘宝星级
	 */
	@TableField("taobao_star")
	private Integer taobaoStar;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 出生日期
	 */
	@TableField("birth_day")
	private Date birthDay;
	/**
	 * QQ账号
	 */
	private String qq;
	/**
	 * 是否刷过单
	 */
	private Integer brushed;
	/**
	 * 评论截图URL
	 */
	@TableField("recommand_screen_shot_url")
	private String recommandScreenShotUrl;
	/**
	 * 星级截图URL
	 */
	@TableField("star_screen_shot_url")
	private String starScreenShotUrl;
	/**
	 * 支付宝截图URL
	 */
	@TableField("ali_pay_screen_shot_url")
	private String aliPayScreenShotUrl;
	/**
	 * 对应用户id
	 */
	@TableField("user_id")
	private Long userId;
	/**
	 * 审核状态（0：待审核，1：审核通过，2：审核未通过）
	 */
	private Integer state;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 介绍人
	 */
	@TableField("introduce_id")
	private Long introduceId;

	/**
	 * 职业id
	 */
	@TableField("career_id")
	private Integer careerId;

	/**
	 * 年龄
	 */
	private Long age;
	/**
	 * 消费水平
	 */
	@TableField("consumption_level")
	private String consumptionLevel;
	/**
	 * 收货地址
	 */
	@TableField("delivery_address")
	private String deliveryAddress;
	/**
	 * 淘宝截图
	 */
	@TableField("taobao_screen_shot_url")
	private String taobaoScreenShotUrl;
	/**
	 * 微信二维码
	 */
	@TableField("wechat_qr_code")
	private String wechatQRCode;
	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 介绍人姓名
	 */
	@TableField(exist = false)
	private String introduceName;

	/**
	 * 显示格式化时间
	 */
	@TableField(exist = false)
	private String createTimeLabel;

	@TableField(exist = false)
	private List<Career> career;


	public List<Career> getCareer() {
		return career;
	}

	public SubscriberUser setCareer(List<Career> career) {
		this.career = career;
		return this;
	}

	public String getCreateTimeLabel() {
		return createTimeLabel;
	}

	public SubscriberUser setCreateTimeLabel(String createTimeLabel) {
		this.createTimeLabel = createTimeLabel;
		return this;
	}

	public SubscriberUser setAge(Long age) {
		this.age = age;
		return this;
	}

	public String getConsumptionLevel() {
		return consumptionLevel;
	}

	public SubscriberUser setConsumptionLevel(String consumptionLevel) {
		this.consumptionLevel = consumptionLevel;
		return this;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public SubscriberUser setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
		return this;
	}

	public String getTaobaoScreenShotUrl() {
		return taobaoScreenShotUrl;
	}

	public SubscriberUser setTaobaoScreenShotUrl(String taobaoScreenShotUrl) {
		this.taobaoScreenShotUrl = taobaoScreenShotUrl;
		return this;
	}

	public String getWechatQRCode() {
		return wechatQRCode;
	}

	public SubscriberUser setWechatQRCode(String wechatQRCode) {
		this.wechatQRCode = wechatQRCode;
		return this;
	}

	public String getRemarks() {
		return remarks;
	}

	public SubscriberUser setRemarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	public String getIntroduceName() {
		return introduceName;
	}

	public SubscriberUser setIntroduceName(String introduceName) {
		this.introduceName = introduceName;
		return this;
	}

	public Integer getCareerId() {
		return careerId;
	}

	public SubscriberUser setCareerId(Integer careerId) {
		this.careerId = careerId;
		return this;
	}

	public Long getAge() {
		return age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIdCardFrontUrl() {
		return idCardFrontUrl;
	}

	public void setIdCardFrontUrl(String idCardFrontUrl) {
		this.idCardFrontUrl = idCardFrontUrl;
	}

	public String getIdCardBehindUrl() {
		return idCardBehindUrl;
	}

	public void setIdCardBehindUrl(String idCardBehindUrl) {
		this.idCardBehindUrl = idCardBehindUrl;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		try {
			Integer ageByIDCard = IDCardToAgeUtils.getAgeByIDCard(idCard);
			setAge(ageByIDCard.longValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.idCard = idCard;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAliPay() {
		return aliPay;
	}

	public void setAliPay(String aliPay) {
		this.aliPay = aliPay;
	}

	public String getAliTm() {
		return aliTm;
	}

	public void setAliTm(String aliTm) {
		this.aliTm = aliTm;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getTaobaoStar() {
		return taobaoStar;
	}

	public void setTaobaoStar(Integer taobaoStar) {
		this.taobaoStar = taobaoStar;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getBrushed() {
		return brushed;
	}

	public void setBrushed(Integer brushed) {
		this.brushed = brushed;
	}

	public String getRecommandScreenShotUrl() {
		return recommandScreenShotUrl;
	}

	public void setRecommandScreenShotUrl(String recommandScreenShotUrl) {
		this.recommandScreenShotUrl = recommandScreenShotUrl;
	}

	public String getStarScreenShotUrl() {
		return starScreenShotUrl;
	}

	public void setStarScreenShotUrl(String starScreenShotUrl) {
		this.starScreenShotUrl = starScreenShotUrl;
	}

	public String getAliPayScreenShotUrl() {
		return aliPayScreenShotUrl;
	}

	public void setAliPayScreenShotUrl(String aliPayScreenShotUrl) {
		this.aliPayScreenShotUrl = aliPayScreenShotUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public SubscriberUser setState(Integer state) {
		this.state = state;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public SubscriberUser setCreateTime(Date createTime) {
		this.setCreateTimeLabel(DateUtils.formatDateTime(createTime));
		this.createTime = createTime;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getIntroduceId() {
		return introduceId;
	}

	public void setIntroduceId(Long introduceId) {
		this.introduceId = introduceId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
