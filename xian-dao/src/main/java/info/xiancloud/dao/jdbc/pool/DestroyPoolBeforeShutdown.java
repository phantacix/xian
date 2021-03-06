package info.xiancloud.dao.jdbc.pool;

import info.xiancloud.core.init.shutdown.ShutdownHook;
import info.xiancloud.core.util.LOG;

/**
 * @author happyyangyuan
 */
public class DestroyPoolBeforeShutdown implements ShutdownHook {
    @Override
    public boolean shutdown() {
        try {
            PoolFactory.getPool().destroyPool();
        } catch (Throwable e) {
            LOG.warn("注销数据库连接池出错", e);
            return false;
        }
        return true;
    }
}
