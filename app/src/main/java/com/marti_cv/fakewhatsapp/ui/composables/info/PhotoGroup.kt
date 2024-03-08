package com.marti_cv.fakewhatsapp.ui.composables.info

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.marti_cv.fakewhatsapp.R

@Composable
fun PhotoGroup(
    isDefaultPhotoSelected: Boolean,
    imageUri: Uri,
    onUriCHanged: (Uri) -> Unit,
    onPhotoClicked: () -> Unit
) {

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                onUriCHanged(it)
            }
        }
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painterResource(id = R.drawable.avatar),
            contentDescription = "unknown user image",
            contentScale = ContentScale.Crop,
            modifier = if (isDefaultPhotoSelected) {
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(BorderStroke(2.dp, Color.Magenta), shape = CircleShape)
                    .clickable { onPhotoClicked() }
            } else {
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { onPhotoClicked() }
            }
        )
        Button(onClick = {
            galleryLauncher.launch("image/*")
        }) {
            Text(text = "elegir imagen")
        }
        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(model = imageUri),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = if (isDefaultPhotoSelected) {
                    Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .clickable { onPhotoClicked() }
                } else {
                    Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .border(BorderStroke(2.dp, Color.Magenta), shape = CircleShape)
                        .clickable { onPhotoClicked() }
                }
            )
        }
    }

}
