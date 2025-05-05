package com.shettyharshith33.beforeLoginScreens.departments.bcaStaffs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily

@Composable
fun TeacherCard(teacher: Teacher, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }, // Make it clickable
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(teacher.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Teacher Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = teacher.name, fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold)
                Text(text = teacher.desig, fontFamily = poppinsFontFamily, fontWeight = FontWeight.SemiBold)
                Text(text = "Qualification: ${teacher.qualification}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Experience: ${teacher.experience} yrs", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
