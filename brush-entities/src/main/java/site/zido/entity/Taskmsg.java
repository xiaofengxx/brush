package site.zido.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 任务详情列表
 * </p>
 *
 * @author zido
 * @since 2017-06-28
 */
@TableName("brush_taskmsg")
public class Taskmsg extends Model<Taskmsg> {

    private static final long serialVersionUID = 1L;

	private Long id;
    /**
     * 序号
     */
	private Long sort;
    /**
     * 任务价格
     */
	@TableField("task_price")
	private Double taskPrice;
    /**
     * 任务数量
     */
	@TableField("task_num")
	private Long taskNum;
    /**
     * 商店id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 用户id
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 商家id
     */
	@TableField("business_id")
	private Long businessId;
    /**
     * 商品图片
     */
	@TableField("product_img")
	private String productImg;
    /**
     * 支付方式
     */
	@TableField("payment_type")
	private String paymentType;
    /**
     * 商品链接
     */
	@TableField("produck_link")
	private String produckLink;
    /**
     * 商品款式
     */
	@TableField("product_style")
	private String productStyle;
    /**
     * 商品初始价格
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
     * 价格区间
     */
	@TableField("price_limit")
	private String priceLimit;
    /**
     * 浏览时间
     */
	@TableField("browse_time")
	private String browseTime;
    /**
     * 是否评论
     */
	private String evaluation;
    /**
     * 其他要求
     */
	private String requirements;
    /**
     * 任务审核 状态: 1.未提交审批，2.提交审批，3.审批通过，4.审批未通过（提示修改）
     */
	private String state;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 发布时间
     */
	@TableField("release_time")
	private Date releaseTime;
    /**
     * 任务的接受间隔时长
     */
	@TableField("interval_time")
	private Long intervalTime;
    /**
     * 任务总价
     */
	@TableField("task_price_count")
	private Double taskPriceCount;
    /**
     * 商品总价
     */
	@TableField("product_price_count")
	private Double productPriceCount;
    /**
     * 任务已完成数量
     */
	@TableField("task_complete_num")
	private Long taskCompleteNum;
    /**
     * 任务审核驳回理由
     */
	@TableField("state_reject_msg")
	private String stateRejectMsg;
    /**
     * 任务天数,最多为七天单
     */
	@TableField("task_duration")
	private Long taskDuration;
    /**
     * 是否收藏
     */
	private String collection;

	@TableField("task_sort")
	private Long taskSrot;

	public Long getTaskSrot() {
		return taskSrot;
	}

	public Taskmsg setTaskSrot(Long taskSrot) {
		this.taskSrot = taskSrot;
		return this;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public Double getTaskPrice() {
		return taskPrice;
	}

	public void setTaskPrice(Double taskPrice) {
		this.taskPrice = taskPrice;
	}

	public Long getTaskNum() {
		return taskNum;
	}

	public void setTaskNum(Long taskNum) {
		this.taskNum = taskNum;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getProduckLink() {
		return produckLink;
	}

	public void setProduckLink(String produckLink) {
		this.produckLink = produckLink;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getProductOriginalPrice() {
		return productOriginalPrice;
	}

	public void setProductOriginalPrice(String productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}

	public String getProductPresentPrice() {
		return productPresentPrice;
	}

	public void setProductPresentPrice(String productPresentPrice) {
		this.productPresentPrice = productPresentPrice;
	}

	public String getProductKeywords() {
		return productKeywords;
	}

	public void setProductKeywords(String productKeywords) {
		this.productKeywords = productKeywords;
	}

	public String getRankingWay() {
		return rankingWay;
	}

	public void setRankingWay(String rankingWay) {
		this.rankingWay = rankingWay;
	}

	public String getRankingLimit() {
		return rankingLimit;
	}

	public void setRankingLimit(String rankingLimit) {
		this.rankingLimit = rankingLimit;
	}

	public String getRegionLimit() {
		return regionLimit;
	}

	public void setRegionLimit(String regionLimit) {
		this.regionLimit = regionLimit;
	}

	public String getPriceLimit() {
		return priceLimit;
	}

	public void setPriceLimit(String priceLimit) {
		this.priceLimit = priceLimit;
	}

	public String getBrowseTime() {
		return browseTime;
	}

	public void setBrowseTime(String browseTime) {
		this.browseTime = browseTime;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Long getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Long intervalTime) {
		this.intervalTime = intervalTime;
	}

	public Double getTaskPriceCount() {
		return taskPriceCount;
	}

	public void setTaskPriceCount(Double taskPriceCount) {
		this.taskPriceCount = taskPriceCount;
	}

	public Double getProductPriceCount() {
		return productPriceCount;
	}

	public void setProductPriceCount(Double productPriceCount) {
		this.productPriceCount = productPriceCount;
	}

	public Long getTaskCompleteNum() {
		return taskCompleteNum;
	}

	public void setTaskCompleteNum(Long taskCompleteNum) {
		this.taskCompleteNum = taskCompleteNum;
	}

	public String getStateRejectMsg() {
		return stateRejectMsg;
	}

	public void setStateRejectMsg(String stateRejectMsg) {
		this.stateRejectMsg = stateRejectMsg;
	}

	public Long getTaskDuration() {
		return taskDuration;
	}

	public void setTaskDuration(Long taskDuration) {
		this.taskDuration = taskDuration;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
