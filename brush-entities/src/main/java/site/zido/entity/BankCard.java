package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 银行卡数据
 * </p>
 *
 * @author zido
 * @since 2017-06-12
 */
@TableName("brush_bank_card")
public class BankCard extends Model<BankCard> {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 开户银行名
	 */
	@TableField("bank_name")
	private String bankName;
	/**
	 * 银行卡号
	 */
	@TableField("bank_card_number")
	private String bankCardNumber;
	/**
	 * 开户手机号
	 */
	@TableField("phone_number")
	private String phoneNumber;
	/**
	 * 银行卡号绑定的姓名
	 */
	@TableField("bind_name")
	private String bindName;
	/**
	 * 银行卡号绑定的身份证号
	 */
	@TableField("bind_card")
	private String bindCard;
	/**
	 * 归属用户id（注意对应的User表）
	 */
	@TableField("user_id")
	private Long userId;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBindName() {
		return bindName;
	}

	public void setBindName(String bindName) {
		this.bindName = bindName;
	}

	public String getBindCard() {
		return bindCard;
	}

	public void setBindCard(String bindCard) {
		this.bindCard = bindCard;
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