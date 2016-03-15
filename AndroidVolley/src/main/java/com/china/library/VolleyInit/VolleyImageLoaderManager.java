package com.china.library.VolleyInit;

import com.android.volley.toolbox.ImageLoader;


/**
 * Created by xiaao on 4/9/15.
 */
public class VolleyImageLoaderManager {

    public static VolleyImageLoaderManager instance;
    private ImageLoader imageLoader;
    private LruBitmapCache lruBitmapCache;

    public static synchronized VolleyImageLoaderManager getInstance() {
        if (instance == null) {
            synchronized (VolleyImageLoaderManager.class) {
                if (instance == null) {
                    instance = new VolleyImageLoaderManager();
                }
            }
        }
        return instance;
    }


    private VolleyImageLoaderManager() {
        getLruBitmapCache();
        imageLoader = new ImageLoader(VolleyQueueManager.getInstance().getRequestQueue(), lruBitmapCache);
    }

    private LruBitmapCache getLruBitmapCache() {
        if (lruBitmapCache == null) {
            lruBitmapCache = new LruBitmapCache();
        }
        return this.lruBitmapCache;
    }

    public ImageLoader getImageLoader() {
        return this.imageLoader;
    }
}
