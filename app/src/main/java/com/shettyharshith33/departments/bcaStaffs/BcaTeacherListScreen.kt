package com.shettyharshith33.departments.bcaStaffs


import SetStatusBarColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightestDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
import com.shettyharshith33.vcputtur.ui.theme.textColor

@Composable
fun TeacherListScreen(
    viewModel: TeacherViewModel = viewModel(),
    navController: NavController
) {
    SetStatusBarColor(lightDodgerBlue,false)
    val isLoading = viewModel.isLoading
    val teachers = viewModel.teachers
    var selectedTeacher by remember { mutableStateOf<Teacher?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchBCATeachers()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(lightestDodgerBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                "BCA - Staffs",
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = textColor,
            )
            Spacer(modifier = Modifier.height(18.dp))
        }

        if (isLoading) {
            items(15) {
                ShimmerTeacherCard(teacher = Teacher())
            }
        } else {
            items(teachers.sortedByDescending { it.experience.toIntOrNull() ?: 0 }) { teacher ->
                TeacherCard(teacher) {
                    selectedTeacher = teacher
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
        }
    }

    // Dialog shown when teacher is clicked
    selectedTeacher?.let { teacher ->
        TeacherDetailDialog(teacher = teacher, onDismiss = { selectedTeacher = null })
    }
}
