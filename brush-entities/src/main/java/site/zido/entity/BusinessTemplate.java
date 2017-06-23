package site.zido.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商家模板表
 * </p>
 *
 * @author zido
 * @since 2017-06-20
 */
@TableName("brush_business_template")
public class BusinessTemplate extends Model<BusinessTemplate> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	private Long id;
    /**
     * 模板对应的商店id
     */
	@TableField("shop_id")
	private Long shopId;
	@TableField("user_id")
	private Long userId;
	@TableField("business_id")
	private Long businessId;
    /**
     * 产品主图
     */
	@TableField("product_img")
	private String productImg;
    /**
     * 付款方式
     */
	@TableField("payment_type")
	private String paymentType;
    /**
     * 模板标签
     */
	@TableField("template_tags")
	private String templateTags;
    /**
     * 产品链接
     */
	@TableField("product_link")
	private String productLink;
    /**
     * 商品款式
     */
	@TableField("product_style")
	private String productStyle;
    /**
     * 商品原价
     */
	@TableField("product_original_price")
	private String productOriginalPrice;
    /**
     * 商品改价
     */
	@TableField("product_present_price")
	private String productPresentPrice;
    /**
     * 商品关键字
     */
	@TableField("product_keywords")
	private String productKeywords;
    /**
     * 排名方式
     */
	@TableField("ranking_way")
	private String rankingWay;
    /**
     * 排名区间
     */
	@TableField("ranking_limit")
	private String rankingLimit;
    /**
     * 卡地区
     */
	@TableField("region_limit")
	private String regionLimit;
    /**
     * 价格区间用&连接如 10&20
     */
	@TableField("price_limit")
	private String priceLimit;
    /**
     * 浏览时间
     */
	@TableField("browse_time")
	private String browseTime;
    /**
     * 是否需要评价
     */
	private String evaluation;
    /**
     * 其他要求
     */
	private String requirements;

	/**
	 * 模板状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
	 */
	private Long state;

	/**
	 * 编号
	 */
	private Long sort;


	public Long getSort() {
		return sort;
	}

	public BusinessTemplate setSort(Long sort) {
		this.sort = sort;
		return this;
	}

	public Long getState() {
		return state;
	}

	public BusinessTemplate setState(Long state) {
		this.state = state;
		return this;
	}

	public Long getId() {
		return id;
	}

	public BusinessTemplate setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public BusinessTemplate setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public BusinessTemplate setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public BusinessTemplate setBusinessId(Long businessId) {
		this.businessId = businessId;
		return this;
	}

	public String getProductImg() {
		return productImg;
	}

	public BusinessTemplate setProductImg(String productImg) {
		this.productImg = productImg;
		return this;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public BusinessTemplate setPaymentType(String paymentType) {
		this.paymentType = paymentType;
		return this;
	}

	public String getTemplateTags() {
		return templateTags;
	}

	public BusinessTemplate setTemplateTags(String templateTags) {
		this.templateTags = templateTags;
		return this;
	}

	public String getProductLink() {
		return productLink;
	}

	public BusinessTemplate setProductLink(String productLink) {
		this.productLink = productLink;
		return this;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public BusinessTemplate setProductStyle(String productStyle) {
		this.productStyle = productStyle;
		return this;
	}

	public String getProductOriginalPrice() {
		return productOriginalPrice;
	}

	public BusinessTemplate setProductOriginalPrice(String productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
		return this;
	}

	public String getProductPresentPrice() {
		return productPresentPrice;
	}

	public BusinessTemplate setProductPresentPrice(String productPresentPrice) {
		this.productPresentPrice = productPresentPrice;
		return this;
	}

	public String getProductKeywords() {
		return productKeywords;
	}

	public BusinessTemplate setProductKeywords(String productKeywords) {
		this.productKeywords = productKeywords;
		return this;
	}

	public String getRankingWay() {
		return rankingWay;
	}

	public BusinessTemplate setRankingWay(String rankingWay) {
		this.rankingWay = rankingWay;
		return this;
	}

	public String getRankingLimit() {
		return rankingLimit;
	}

	public BusinessTemplate setRankingLimit(String rankingLimit) {
		this.rankingLimit = rankingLimit;
		return this;
	}

	public String getRegionLimit() {
		return regionLimit;
	}

	public BusinessTemplate setRegionLimit(String regionLimit) {
		this.regionLimit = regionLimit;
		return this;
	}

	public String getPriceLimit() {
		return priceLimit;
	}

	public BusinessTemplate setPriceLimit(String priceLimit) {
		this.priceLimit = priceLimit;
		return this;
	}

	public String getBrowseTime() {
		return browseTime;
	}

	public BusinessTemplate setBrowseTime(String browseTime) {
		this.browseTime = browseTime;
		return this;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public BusinessTemplate setEvaluation(String evaluation) {
		this.evaluation = evaluation;
		return this;
	}

	public String getRequirements() {
		return requirements;
	}

	public BusinessTemplate setRequirements(String requirements) {
		this.requirements = requirements;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
