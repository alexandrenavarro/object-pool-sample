package com.github.objectpool;

import nf.fr.eraasoft.pool.ObjectPool;
import nf.fr.eraasoft.pool.PoolException;
import nf.fr.eraasoft.pool.PoolSettings;
import nf.fr.eraasoft.pool.PoolableObjectBase;

/**
 * <p>SeriesHelper.</p>
 *
 * @author anavarro - Mar 22, 2015
 *
 */
public class SeriesHelper {

    static final PoolSettings<StringBuilder> POOL_SEETINGS = new PoolSettings<StringBuilder>(new PoolableObjectBase<StringBuilder>() {
                                                                       @Override
                                                                       public StringBuilder make() {
                                                                           return new StringBuilder();
                                                                       }

                                                                       @Override
                                                                       public void activate(StringBuilder t) {
                                                                           t.setLength(0);
                                                                       }
                                                                   });

    static {
        POOL_SEETINGS.min(0)
            .max(16);

    }

    static final ObjectPool<StringBuilder>   OBJECT_POOL   = POOL_SEETINGS.pool();

    /**
     * Constructor.
     *
     */
    private SeriesHelper() {
    }

    public static String retrieve(int number) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < number; i++) {
            sb.append(i)
                .append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static String retrieveWithPool(int number) {
        StringBuilder sb = null;
        try {
            sb = OBJECT_POOL.getObj();
            sb.append("[");
            for (int i = 0; i < number; i++) {
                sb.append(i)
                    .append(",");
            }
            sb.append("]");
            return sb.toString();

        } catch (PoolException e) {
            e.printStackTrace();
            return "";
        } finally {
            OBJECT_POOL.returnObj(sb);
        }

    }


}
