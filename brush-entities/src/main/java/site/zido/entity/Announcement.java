package site.zido.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商家和刷手的公告
 * </p>
 *
 * @author zido
 * @since 2017-06-26
 */
@TableName("brush_announcement")
public class Announcement extends Model<Announcement> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长
     */
	private Long id;
    /**
     * 商家:1  刷手:2
     */
	@TableField("pub_type")
	private Integer pubType;
    /**
     * 标题
     */
	@TableField("pub_title")
	private String pubTitle;
    /**
     * 公告发布的时间
     */
	@TableField("announcement_time")
	private Date announcementTime;
    /**
     * 公告内容
     */
	@TableField("announcement_text")
	private String announcementText;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPubType() {
		return pubType;
	}

	public void setPubType(Integer pubId) {
		this.pubType = pubType;
	}

	public String getPubTitle() {
		return pubTitle;
	}

	public void setPubTitle(String pubTitle) {
		this.pubTitle = pubTitle;
	}

	public Date getAnnouncementTime() {
		return announcementTime;
	}

	public void setAnnouncementTime(Date announcementTime) {

		this.announcementTime = announcementTime;
	}

	public String getAnnouncementText() {
		return announcementText;
	}

	public void setAnnouncementText(String announcementText) {
		this.announcementText = announcementText;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
