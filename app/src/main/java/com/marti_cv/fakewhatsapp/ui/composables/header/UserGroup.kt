package com.marti_cv.fakewhatsapp.ui.composables.header

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marti_cv.fakewhatsapp.R
import com.marti_cv.fakewhatsapp.ui.theme.TopIconTint

@Composable
fun UserGroup(modifier: Modifier, onClickBack: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back button",
            tint = TopIconTint,
            modifier = modifier
                .clickable { onClickBack() })
        Image(
            painterResource(id = R.drawable.test_image),
            contentDescription = "Receptor image",
            modifier = modifier
                .clip(CircleShape)
                .size(36.dp)
        )
        Text(
            text = "Receptor", color = TopIconTint, modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
fun UserGroupPreview() {
    UserGroup(modifier = Modifier, onClickBack = {})
}