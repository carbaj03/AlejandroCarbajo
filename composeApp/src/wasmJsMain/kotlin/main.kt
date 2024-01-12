import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  CanvasBasedWindow(canvasElementId = "ComposeTarget") { Main() }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Main() {
  Column(
    Modifier.padding(20.dp)
  ) {

    Column(
      modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "Alejandro Carbajo",
        style = MaterialTheme.typography.displayLarge,
        color = MaterialTheme.colorScheme.primary
      )
      Text(
        text = "Kotlin Expert | Business problem solver",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.secondary
      )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Column(
      modifier = Modifier.padding(20.dp).fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Column {
        Text(
          text = """ARE YOU READY TO FINALLY 
            |MAKE YOUR APP AWESOME?""".trimMargin(),
          style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
          onClick = { },
          modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
          Text("Lets talk")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
          verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          Text(
            text = "No more lazy developers",
            style = MaterialTheme.typography.bodySmall
          )
          Text(
            text = "No more developers how doesn't care about your business",
            style = MaterialTheme.typography.bodySmall
          )
          Text(
            text = "No more delays, ship and iterate faster",
            style = MaterialTheme.typography.bodySmall
          )
        }
      }
      Spacer(modifier = Modifier.height(100.dp))
      Column {
        Text(
          text = "But, are you able to work with other mates?",
          style = MaterialTheme.typography.headlineLarge,
          modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
          text = "Yes! I am going to help you to make our team even better",
          style = MaterialTheme.typography.titleMedium,
          modifier = Modifier.align(Alignment.CenterHorizontally),
          color = MaterialTheme.colorScheme.secondary,
          fontWeight = FontWeight.Bold
        )
        Column(
          modifier = Modifier.padding(20.dp).fillMaxWidth(),
        ) {
          Text(
            text = """I am nice, kind, emphatic, love""",
            style = MaterialTheme.typography.bodyMedium,
          )
          Text(
            text = """I have one mouth and two ears, do you know?""",
            style = MaterialTheme.typography.bodyMedium
          )
          Text(
            text = "I humble, I am not the best, and for this reason I am always learning",
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
      Spacer(modifier = Modifier.height(100.dp))
      Column {
        Text(
          text = "8 years of experience in Android",
          style = MaterialTheme.typography.headlineLarge
        )
        Text(
          text = """This is just numbers
            |What I can do for you?""".trimMargin(),
          style = MaterialTheme.typography.headlineSmall
        )
        Text(
          text = "Third party integrations",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "Local and remote data storage",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "Security and privacy",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "Beautiful UIs and UX",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "Well tested code",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "High Performance and scalability",
          style = MaterialTheme.typography.bodyMedium
        )
      }
      Spacer(modifier = Modifier.height(100.dp))
      Column(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "If you love acronyms, abbreviation and buzzwords",
          style = MaterialTheme.typography.titleMedium
        )
        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp),
          maxItemsInEachRow = 5,
        ) {
          "#TDD #CleanCode #MVP #MVI #MVVM #Coroutines #Dagger #Compose #FP #OOP #SOLID #Kotlin #Java #Android #Agile #Retrofit #Ktor #CD/CI #Git".split(" ").forEach {
            Text(
              text = it,
              style = MaterialTheme.typography.headlineSmall,
              color = MaterialTheme.colorScheme.onTertiaryContainer,
              modifier = Modifier
                .background(
                  color = MaterialTheme.colorScheme.tertiaryContainer,
                  shape = MaterialTheme.shapes.small
                )
                .padding(2.dp)
            )
          }
        }
      }
    }

    Row {
      Text(
        text = "Jetpack Compose",
        style = MaterialTheme.typography.bodyLarge
      )
    }
  }
}