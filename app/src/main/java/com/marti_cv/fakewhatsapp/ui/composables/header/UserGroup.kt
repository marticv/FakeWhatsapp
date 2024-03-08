package com.marti_cv.fakewhatsapp.ui.composables.header

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.marti_cv.fakewhatsapp.R
import com.marti_cv.fakewhatsapp.ui.theme.TopIconTint

@Composable
fun UserGroup(
    isDefaultImageSelected: Boolean,
    uri: Uri,
    chatName: String,
    modifier: Modifier,
    onClickBack: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back button",
            tint = TopIconTint,
            modifier = modifier
                .clickable { onClickBack() })
        if (!isDefaultImageSelected) {
            Image(
                painter = rememberAsyncImagePainter(model = uri),
                contentDescription = "user imager",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(CircleShape)
                    .size(36.dp)
            )
        } else {
            Image(
                painterResource(id = R.drawable.avatar),
                contentDescription = "Receptor image",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(CircleShape)
                    .size(36.dp)
            )
        }

        Text(
            text = chatName,
            color = TopIconTint,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}