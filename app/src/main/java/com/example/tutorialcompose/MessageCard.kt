package com.example.tutorialcompose

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorialcompose.ui.theme.TutorialComposeTheme

@Composable
fun MessageCard(message: Message) {
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        Image(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .border(
                    2.dp,
                    MaterialTheme.colors.secondary,
                    CircleShape
                ),
            painter = painterResource(id = R.drawable.ic_android_logo),
            contentDescription = "Imagem de perfil de ${message.author}"
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }
        ) {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.message,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.body2,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                )
            }
        }
    }
}

@Preview(
    name = "Light mode",
    showBackground = true
)
@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMessageCard() {
    TutorialComposeTheme {
        MessageCard(
            Message(
                author = "Google",
                message = "JetPack Compose"
            )
        )
    }
}