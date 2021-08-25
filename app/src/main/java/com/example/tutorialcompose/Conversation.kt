package com.example.tutorialcompose

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorialcompose.ui.theme.TutorialComposeTheme


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { msg ->
            MessageCard(message = msg)
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
fun PreviewConversation() {
    TutorialComposeTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}