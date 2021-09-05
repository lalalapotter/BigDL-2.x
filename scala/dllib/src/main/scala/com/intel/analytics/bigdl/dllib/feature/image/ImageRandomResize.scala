/*
 * Copyright 2018 Analytics Zoo Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intel.analytics.bigdl.dllib.feature.image

import com.intel.analytics.bigdl.dllib.feature.transform.vision.image.augmentation.RandomResize
import com.intel.analytics.bigdl.dllib.feature.transform.vision.image.ImageFeature

/**
 * Randomly resize an image between minSize and maxSize and
 * scale height and width to each other.
 *
 * @param minSize Integer. The minimum size to resize to.
 * @param maxSize Integer. The maximum size to resize to.
 */
class ImageRandomResize(minSize: Int, maxSize : Int) extends ImageProcessing {
  private val internalTransformer = RandomResize(minSize, maxSize)

  override def apply(prev: Iterator[ImageFeature]): Iterator[ImageFeature] = {
    internalTransformer.apply(prev)
  }

  override def transformMat(feature: ImageFeature): Unit = {
    internalTransformer.transformMat(feature)
  }
}

object ImageRandomResize {
  def apply(minSize: Int, maxSize : Int): ImageRandomResize =
    new ImageRandomResize(minSize, maxSize)
}
