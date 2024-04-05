import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.CanvasBasedWindow

@Stable
val Color.Companion.Pink: Color
  get() = Color(0xFFFF6969)

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
  CanvasBasedWindow(canvasElementId = "ComposeTarget") { Main() }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Main() {
//  val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
  Scaffold(
//    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      Row {
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
            color = Color.Black
          )
          Text(
            text = "Kotlin Expert | Business problem solver",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Pink
          )
        }
        ClickableText(
          text = AnnotatedString("Contact me"),
          onClick = {
            println("Clicked")
          }
        )
      }
    },
    bottomBar = {

    }
  ) {

    Column(
//      Modifier.padding(it).verticalScroll(rememberScrollState())
    ) {

      Spacer(modifier = Modifier.height(20.dp))
      Column(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Column {
          Text(
            text = """Elevate your business today!""".trimMargin(),
            style = MaterialTheme.typography.headlineLarge
          )
          Spacer(modifier = Modifier.height(50.dp))
//        Button(
//          onClick = { },
//          elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp, pressedElevation = 0.dp),
//          colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Black,
//          ),
//        ) {
//          Text("Join waitlist")
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//        example()
          MyButton(
            modifier = Modifier.padding(0.dp).align(Alignment.CenterHorizontally),
            spread = 4f,
            shadowColor = Color.Pink,
            color = Color.Black,
          ) {
            Text(
              text = "Apply",
              modifier = Modifier.align(Alignment.CenterVertically),
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
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
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "But, are you able to work with other mates?",
            style = MaterialTheme.typography.headlineLarge,
          )
          Spacer(modifier = Modifier.height(20.dp))
          Text(
            text = "Yes! I am going to help you to make our team even better",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(20.dp))
          Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = """I am nice 😊, kind 💕 , emphatic 🤗, love ❤️""",
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
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "8 years of experience in Android",
            style = MaterialTheme.typography.headlineLarge
          )
          Spacer(modifier = Modifier.height(20.dp))
          Text(
            text = """This is just numbers
            |What you can do for me?""".trimMargin(),
            style = MaterialTheme.typography.headlineSmall
          )
          Spacer(modifier = Modifier.height(20.dp))
          Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
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
        }
        Spacer(modifier = Modifier.height(100.dp))
        Column(
          modifier = Modifier.padding(20.dp).fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "If you love acronyms, abbreviation and buzzwords",
            style = MaterialTheme.typography.titleLarge,
          )
          Spacer(modifier = Modifier.height(20.dp))
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            maxItemsInEachRow = 5,
          ) {
            "#TDD #CleanCode #MVP #MVI #MVVM #Coroutines #Dagger #Compose #FP #OOP #SOLID #Kotlin #Java #Android #Agile #Retrofit #Ktor #CD/CI #Git".split(" ").forEach {
              Text(
                text = it,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                modifier = Modifier
                  .background(
                    color = Color.Pink,
                    shape = RectangleShape
                  )
                  .padding(4.dp)
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
}