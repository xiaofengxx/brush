package site.zido.dto;

/**
 * 数据传输json实体对象
 * <p>包装成功失败结果集，信息，数据等</p>
 *
 * @author zido
 *         date: 2017/5/25 0025 14:52
 */
public class AjaxResult {

    /**
     * 返回结果
     */
    private boolean success;
    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public AjaxResult(boolean success) {
        this.success = success;
        this.message = null;
    }

    /**
     * Instantiates a new Ajax result.
     *
     * @param success the success
     * @param message the message
     */
    public AjaxResult(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    /**
     * Instantiates a new Ajax result.
     *
     * @param success the success
     * @param data    the data
     */
    public AjaxResult(boolean success, Object data) {
        super();
        this.success = success;
        this.data = data;
    }

    /**
     * Instantiates a new Ajax result.
     *
     * @param success the success
     * @param message the message
     * @param data    the data
     */
    public AjaxResult(boolean success, String message, Object data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
