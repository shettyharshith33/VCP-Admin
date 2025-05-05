package com.shettyharshith33.beforeLoginScreens.departments.bcaStaffs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily

@Composable
fun TeacherDetailDialog(teacher: Teacher, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = teacher.imageUrl,
                    contentDescription = "Expanded Teacher Image",
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = teacher.name, fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = poppinsFontFamily)
                Text(text = teacher.desig, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, fontFamily = poppinsFontFamily)
                Text(text = "Qualification: ${teacher.qualification}", fontSize = 14.sp)
                Text(text = "Experience: ${teacher.experience} yrs", fontSize = 14.sp)
            }
        }
    }
}
