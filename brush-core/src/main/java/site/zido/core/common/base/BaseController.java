package site.zido.core.common.base;

import site.zido.core.dto.AjaxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * controller基类
 * <p>封装通用controller方法</p>
 *
 * @author zido
 * @since 2017/5/25
 */
public class BaseController {

    /**
     * 成功,返回状态
     *
     * @return ajax result
     */
    protected AjaxResult success() {
        return new AjaxResult(true);
    }

    /**
     * 成功,返回状态
     *
     * @param message the message
     * @return ajax result
     */
    protected AjaxResult success(final String message) {
        return new AjaxResult(true, message);
    }

    /**
     * 成功，返回成功数据
     * @param data 数据
     * @return ajax result
     */
    protected AjaxResult successData(final Object data){
        return success("操作成功",data);
    }

    /**
     * Success ajax result.
     *
     * @param message the message
     * @param data    the data
     * @return the ajax result
     */
    protected AjaxResult success(final String message, final Object data) {
        return new AjaxResult(true, message, data);
    }

    /**
     * 返回json数据
     *
     * @param success 状态true/false
     * @param data    实体
     * @return ajax result
     */
    protected AjaxResult json(final Boolean success, final Object data) {
        return new AjaxResult(success, data);
    }

    /**
     * 失败,返回状态及原因
     *
     * @param message 消息
     * @return ajax result
     */
    protected AjaxResult fail(final String message) {
        return new AjaxResult(false, message);
    }

    /**
     * Fail ajax result.
     *
     * @param message the message
     * @param data    the data
     * @return the ajax result
     */
    protected AjaxResult fail(final String message, final Object data) {
        return new AjaxResult(false, message, data);
    }

    /**
     * 转换为ajax需要的 JSON
     *
     * @param success 状态
     * @param message 消息
     * @param entity  实体
     * @return json json
     */
    protected Map<String, Object> setJson(final boolean success, final String message, final Object entity) {
        Map<String, Object> json = new HashMap<>();
        json.put("success", success);
        json.put("message", message);
        json.put("data", entity);
        return json;
    }

    /**
     * ajax成功/失败
     *
     * @param success 状态
     * @return json json
     */
    protected Map<String, Object> setJson(final boolean success) {
        Map<String, Object> json = new HashMap<>();
        json.put("success", success);
        return json;
    }

    /**
     * ajax成功/失败 + 消息
     *
     * @param success 状态
     * @param message 消息
     * @return json json
     */
    protected Map<String, Object> setJson(final boolean success, final String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("success", success);
        return json;
    }

    /**
     * 返回的是工程项目的相对路径
     *
     * @return context path
     */
    protected String getContextPath(HttpServletRequest request) {
        return request.getContextPath();
    }

    /**
     * 重定向至地址 url
     *
     * @param url 请求地址
     * @return string string
     */
    protected String redirectTo(final String url) {
        return "redirect:" + url;
    }
}
