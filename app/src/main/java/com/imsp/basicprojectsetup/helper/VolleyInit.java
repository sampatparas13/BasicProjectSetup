package com.imsp.basicprojectsetup.helper;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.cache.BitmapImageCache;
import com.android.volley.cache.SimpleImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by SP on 03-04-2017.
 */

public class VolleyInit {
    private static RequestQueue mRequestQueue;
    private static SimpleImageLoader mImageLoader;


    private VolleyInit() {
        // no instances
    }

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
        mImageLoader = new SimpleImageLoader(mRequestQueue, BitmapImageCache.getInstance(null));
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }

    /**
     * Returns instance of ImageLoader initialized with {@see FakeImageCache} which effectively means
     * that no memory caching is used. This is useful for images that you know that will be show
     * only once.
     *
     * @return
     */
    public static SimpleImageLoader getImageLoader() {
        if (mImageLoader != null) {
            return mImageLoader;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
