package com.gcolina.horoscoapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*Con estas etiquetas me aseguro que lo que me pida sea un Objeto Drawable y un objeto String.*/

data class LuckyModel(@DrawableRes val image: Int, @StringRes val text: Int)
