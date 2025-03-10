/*
 * Paintroid: An image manipulation application for Android.
 * Copyright (C) 2010-2021 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.paintroid.tools

import android.graphics.Bitmap
import android.graphics.PointF
import android.graphics.RectF
import org.catrobat.paintroid.command.serialization.CommandSerializationUtilities
import org.catrobat.paintroid.ui.Perspective

interface Workspace {
    val height: Int
    val width: Int
    val surfaceWidth: Int
    val surfaceHeight: Int
    val bitmapOfAllLayers: Bitmap?
    val bitmapLisOfAllLayers: List<Bitmap?>
    val bitmapOfCurrentLayer: Bitmap?
    val currentLayerIndex: Int
    val scaleForCenterBitmap: Float
    var scale: Float
    var perspective: Perspective

    fun contains(point: PointF): Boolean

    fun intersectsWith(rectF: RectF): Boolean

    fun resetPerspective()

    fun getSurfacePointFromCanvasPoint(coordinate: PointF): PointF

    fun getCanvasPointFromSurfacePoint(surfacePoint: PointF): PointF

    fun invalidate()

    fun getCommandSerializationHelper(): CommandSerializationUtilities
}
