package site.zido.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by FZC on 2017/6/21.
 */
public class SubscriberCondition {

    public static String[] SORTS = {"id","creat_time","birth_day"};

    private String sortName = SORTS[0];

    @ApiModelProperty(value = "排序方式")
    private Integer sort;

    @ApiModelProperty(value = "电话号码")
    private String phonenumber;

    @ApiModelProperty(value = "状态")
    private Integer[] states;

    public Integer getSort() {
        return sort;
    }

    public SubscriberCondition setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public SubscriberCondition setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public Integer[] getStates() {
        return states;
    }

    public SubscriberCondition setStates(Integer[] states) {
        this.states = states;
        return this;
    }
}
