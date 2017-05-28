package site.zido.core.exception;

/**
 * description:
 * <p>fill description</p>
 *
 * @author zido
 * @since 2017/5/26 0026
 */
public class ServiceException extends Exception {
    private String msg;
    public ServiceException(String msg){
        super(msg);
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
