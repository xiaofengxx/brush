package site.zido.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by FZC on 2017/6/21.
 */
public class SubscriberCondition {

    public static String[] SORTS = {"bs.id","bs.creat_time","bs.birth_day"};

    private String sortName = SORTS[0];

    @ApiModelProperty(value = "倒叙/正序")
    private boolean DESC = true;

    @ApiModelProperty(value = "排序方式")
    private Integer sort;

    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "开始时间")
    private Date stime;

    @ApiModelProperty(value = "结束时间")
    private Date etime;

    @ApiModelProperty(value = "状态")
    private Integer[] states;



    public boolean isDESC() {
        return DESC;
    }

    public Date getStime() {
        return stime;
    }

    public SubscriberCondition setStime(Date stime) {
        this.stime = stime;
        return this;
    }

    public Date getEtime() {
        return etime;
    }

    public SubscriberCondition setEtime(Date etime) {
        this.etime = etime;
        return this;
    }

    public SubscriberCondition setDESC(boolean DESC) {
        this.DESC = DESC;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public SubscriberCondition setSort(Integer sort) {
        if(sort < SORTS.length){
            sortName = SORTS[sort];
        }
        this.sort = sort;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SubscriberCondition setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Integer[] getStates() {
        return states;
    }

    public SubscriberCondition setStates(Integer[] states) {
        this.states = states;
        return this;
    }

    public String getSortName() {
        return sortName;
    }

    public SubscriberCondition setSortName(String sortName) {
        this.sortName = sortName;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public SubscriberCondition setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }
}
