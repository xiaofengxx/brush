package site.zido.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商家充值管理
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
@TableName("brush_business_recharge")
public class BusinessRecharge extends Model<BusinessRecharge> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家转账金额小写
     */
	@TableField("recharge_money")
	private Double rechargeMoney;
    /**
     * 中文大写
     */
	@TableField("recharge_chinese")
	private String rechargeChinese;
    /**
     * 打款人姓名
     */
	@TableField("recharge_name")
	private String rechargeName;
    /**
     * 充值截图
     */
	@TableField("recharge_url")
	private String rechargeUrl;
    /**
     * 给平台留言
     */
	@TableField("terrace_words")
	private String terraceWords;
	@TableId(value="id", type= IdType.AUTO)
	private Long id;


	public Double getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(Double rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public String getRechargeChinese() {
		return rechargeChinese;
	}

	public void setRechargeChinese(String rechargeChinese) {
		this.rechargeChinese = rechargeChinese;
	}

	public String getRechargeName() {
		return rechargeName;
	}

	public void setRechargeName(String rechargeName) {
		this.rechargeName = rechargeName;
	}

	public String getRechargeUrl() {
		return rechargeUrl;
	}

	public void setRechargeUrl(String rechargeUrl) {
		this.rechargeUrl = rechargeUrl;
	}

	public String getTerraceWords() {
		return terraceWords;
	}

	public void setTerraceWords(String terraceWords) {
		this.terraceWords = terraceWords;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
