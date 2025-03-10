// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.videoplayer;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import java.io.File;

/** Class responsible for managing video cache. */
public final class VideoCacheManager {
  private static SimpleCache simpleCache;

  /** Maximum cache size (2GB) */
  private static final long MAX_CACHE_SIZE = 2 * 1024 * 1024 * 1024L;

  /**
   * Returns the singleton cache instance, creating it if necessary.
   *
   * @param context The application context.
   * @return The cache instance.
   */
  @NonNull
  public static synchronized Cache getCache(@NonNull Context context) {
    if (simpleCache == null) {
      File cacheDir = new File(context.getCacheDir(), "media_cache");
      if (!cacheDir.exists()) {
        cacheDir.mkdirs();
      }
      LeastRecentlyUsedCacheEvictor evictor = new LeastRecentlyUsedCacheEvictor(MAX_CACHE_SIZE);
      StandaloneDatabaseProvider databaseProvider = new StandaloneDatabaseProvider(context);
      simpleCache = new SimpleCache(cacheDir, evictor, databaseProvider);
    }
    return simpleCache;
  }
} 