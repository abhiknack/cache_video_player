// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.videoplayer;

public class VideoPlayerOptions {
  public boolean mixWithOthers = false;
  public long maxCacheSize = 2L * 1024 * 1024 * 1024; // 2GB default
  public int connectTimeoutMs = 15000;
  public int readTimeoutMs = 15000;
  public boolean blockOnCache = true;
  public boolean ignoreCacheOnError = true;
  
  // Buffer durations
  public int minBufferMs = 2500;
  public int maxBufferMs = 30000;
  public int bufferForPlaybackMs = 1500;
  public int bufferForPlaybackAfterRebufferMs = 2000;
}
