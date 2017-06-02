package site.zido.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 银行卡数据
 * </p>
 *
 * @author zido
 * @since 2017-06-01
 */
@TableName("brush_bank_card")
public class BankCard extends Model<BankCard> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 开户银行名
     */
	private String bankName;
    /**
     * 银行卡号
     */
	private String bankCardNumber;
    /**
     * 开户手机号
     */
	private String phoneNumber;
    /**
     * 银行卡号绑定的手机号
     */
	private String bindName;
    /**
     * 银行卡号绑定的身份证号
     */
	private String bindCard;
    /**
     * 归属用户id（注意对应的User表）
     */
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
