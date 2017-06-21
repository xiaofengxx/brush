package site.zido.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by FZC on 2017/6/20.
 */
public class BusinessTemplateCondition {

    /**
     * 排序条件
     */
    public static String[] SORTS = {"id","create_time","payment_type","product_original_price","product_present_price"};

    @ApiModelProperty(value = "排序条件: 0:编号,1:创建时间,2:付款条件,3:原价,4:改价")
    private int sort;

    @ApiModelProperty(value = "排序方式")
    private boolean desc = true;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty("用户id")
    private Long userid;

    @ApiModelProperty("开始时间")
    private Date stime;

    @ApiModelProperty(value = "结束时间")
    private Data etime;

    private Integer[] state;

    /**
     * 排序名
     */
    private String sortName = SORTS[0];

    public int getSort() {
        return sort;
    }

    public BusinessTemplateCondition setSort(int sort) {
        if(sort < SORTS.length){
            sortName = SORTS[sort];
        }
        this.sort = sort;
        return this;
    }

    public boolean isDesc() {
        return desc;
    }

    public BusinessTemplateCondition setDesc(boolean desc) {
        this.desc = desc;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public BusinessTemplateCondition setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public Long getUserid() {
        return userid;
    }

    public BusinessTemplateCondition setUserid(Long userid) {
        this.userid = userid;
        return this;
    }

    public Date getStime() {
        return stime;
    }

    public BusinessTemplateCondition setStime(Date stime) {
        this.stime = stime;
        return this;
    }

    public Data getEtime() {
        return etime;
    }

    public BusinessTemplateCondition setEtime(Data etime) {
        this.etime = etime;
        return this;
    }

}
