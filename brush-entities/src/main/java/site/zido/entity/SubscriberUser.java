package site.zido.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 刷手信息表
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_subscriber_user")
public class SubscriberUser extends Model<SubscriberUser> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 刷手手机号
     */
	private String phoneNumber;
    /**
     * 身份证正面图片URL
     */
	private String IDCardFrontUrl;
    /**
     * 身份证背面图片URL
     */
	private String IDCardBehindUrl;
    /**
     * 身份证号
     */
	private String IDCard;
    /**
     * 真实姓名
     */
	private String realName;
    /**
     * 头像
     */
	private String avatar;
    /**
     * 支付宝账号
     */
	private String aliPay;
    /**
     * 阿里旺旺账号
     */
	private String aliTM;
    /**
     * 微信账号
     */
	private String wechat;
    /**
     * 淘宝星级
     */
	private Integer taobaoStar;
    /**
     * 性别
     */
	private Integer sex;
    /**
     * 出生日期
     */
	private Date birthDay;
    /**
     * QQ账号
     */
	private String Qq;
    /**
     * 是否刷过单
     */
	private Integer brushed;
    /**
     * 评论截图URL
     */
	private String recommandScreenShotUrl;
    /**
     * 星级截图URL
     */
	private String starScreenShotUrl;
    /**
     * 支付宝截图URL
     */
	private String aliPayScreenShotUrl;
    /**
     * 对应用户id
     */
	private String userId;

	/**
	 * 刷手审核状态
	 * @return
	 */
	private Integer state;


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

	public String getIDCardFrontUrl() {
		return IDCardFrontUrl;
	}

	public void setIDCardFrontUrl(String IDCardFrontUrl) {
		this.IDCardFrontUrl = IDCardFrontUrl;
	}

	public String getIDCardBehindUrl() {
		return IDCardBehindUrl;
	}

	public void setIDCardBehindUrl(String IDCardBehindUrl) {
		this.IDCardBehindUrl = IDCardBehindUrl;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String IDCard) {
		this.IDCard = IDCard;
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

	public String getAliTM() {
		return aliTM;
	}

	public void setAliTM(String aliTM) {
		this.aliTM = aliTM;
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
		return Qq;
	}

	public void setQq(String Qq) {
		this.Qq = Qq;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
