package dao;

/**
 * Created by woshi on 2016/5/23.
 */

public interface HttpCallbackListener {
    void    onFinish(String response);
    void    onError(Exception e);
}
