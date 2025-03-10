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
package org.catrobat.paintroid.model

import android.graphics.Bitmap
import android.graphics.Color
import org.catrobat.paintroid.contract.LayerContracts

open class Layer(override var bitmap: Bitmap?) : LayerContracts.Layer {
    override var transparentBitmap: Bitmap? = null
    override var isVisible: Boolean = true

    init {
        bitmap?.apply {
            transparentBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        }
    }

    override fun switchBitmaps(isUnhide: Boolean) {
        val tmpBitmap = transparentBitmap?.apply { copy(config, isMutable) }
        transparentBitmap = bitmap
        bitmap = tmpBitmap
        if (isUnhide) {
            transparentBitmap?.eraseColor(Color.TRANSPARENT)
        }
    }
}
