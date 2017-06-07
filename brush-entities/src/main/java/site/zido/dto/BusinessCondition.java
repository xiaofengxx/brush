package site.zido.dto;

import java.util.Date;

/**
 * description
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/6/6 0006
 */
public class BusinessCondition {
    public static final String[] SORTS = {"sort", "states", "create_time"};
    /**
     * 排序字段
     */
    private String sortName = SORTS[0];

    private Integer sort = 0;
    /**
     * 倒序
     */
    private Boolean desc = true;
    /**
     * 关键字
     */
    private String key;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 状态
     */
    private Integer[] states;

    public String getSortName() {
        return sortName;
    }

    public BusinessCondition setSortName(String sortName) {
        this.sortName = sortName;
        return this;
    }

    public Boolean getDesc() {
        return desc;
    }

    public BusinessCondition setDesc(Boolean desc) {
        this.desc = desc;
        return this;
    }

    public String getKey() {
        return key;
    }

    public BusinessCondition setKey(String key) {
        this.key = key;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public BusinessCondition setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public BusinessCondition setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer[] getStates() {
        return states;
    }

    public BusinessCondition setStates(Integer[] states) {
        this.states = states;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public BusinessCondition setSort(Integer sort) {
        this.sort = sort;
        if (sort < 0 || sort > 2)
            sort = 0;
        this.sortName = SORTS[sort];
        return this;
    }
}
