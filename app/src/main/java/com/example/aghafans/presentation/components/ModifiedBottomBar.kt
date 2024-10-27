package com.example.aghafans.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.aghafans.presentation.navigations.listOfBottomScreens
import com.example.aghafans.ui.theme.primaryLight

@Composable
fun ModifiedBottomBar(modifier: Modifier = Modifier, currentScreenIndex: Int, onItemSelected: (Int, Any) -> Unit) {

    val context = LocalContext.current

//    val isDarkTheme = PrefsManager.getInstance(context).isDArkTheme.collectAsStateWithLifecycle(
//        initialValue = false
//    )

    val color = animateColorAsState(
        targetValue = MaterialTheme.colorScheme.onBackground,
        label = "",
        animationSpec = tween(durationMillis = 1000)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .clip(RoundedCornerShape(25))
            .border(1.dp, primaryLight, RoundedCornerShape(25))
            .background(
                Color.Transparent
            )
            .padding(start = 18.dp, end = 18.dp, bottom = 12.dp, top = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listOfBottomScreens.forEachIndexed { index, screen ->
            if (index == currentScreenIndex) {
                Row(
                    modifier = Modifier
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessHigh
                            )
                        )
                        .background(color.value, RoundedCornerShape(25.dp))
                        .padding(vertical = 8.dp, horizontal = 10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { onItemSelected(index, screen.route) },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = screen.selectedIcon,
                        contentDescription = screen.text,
                        tint = MaterialTheme.colorScheme.background
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = screen.text,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.background
                    )
                }
            } else {
                Icon(
                    modifier = Modifier
                        .animateContentSize()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = { onItemSelected(index, screen.route) }),
                    imageVector = screen.icon,
                    contentDescription = screen.text,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}