package info.xiancloud.yy.sender;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import info.xiancloud.core.socket.ConnectTimeoutException;
import info.xiancloud.core.thread_pool.ThreadPoolManager;
import info.xiancloud.core.util.HttpUtil;

import java.net.SocketTimeoutException;


/**
 * 测试广播发送器
 *
 * @author happyyangyuan
 */
public class TestBroadcast {
    public static void main(String... args) {
        for (int i = 0; i < 100; i++) {
            ThreadPoolManager.execute(() -> {
                try {
                    System.out.println(
                            JSON.toJSONString(
                                    JSON.parseObject(HttpUtil.postWithEmptyHeader("http://localhost:9124/v1.0/testService/testBroadcast", new JSONObject().toJSONString())),
                                    true
                            )
                    );
                } catch (SocketTimeoutException | ConnectTimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
