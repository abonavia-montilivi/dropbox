package cat.institutmontilivi.clase17_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.clase17_10.composables.DropDown
import cat.institutmontilivi.clase17_10.composables.IntegerUpdown
import cat.institutmontilivi.clase17_10.composables.Selector
import cat.institutmontilivi.clase17_10.ui.theme.Clase1710Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Clase1710Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clase1710Theme {
        var text by remember{mutableStateOf("Hola")}
        //al hacer text by hay que importar getters y setters ya no hace falta poner text.value que se ponía en caso de text = .....
        Column {

            TextField(
                value = text,
                onValueChange = {nouText -> text=nouText})
            Button(onClick = { text="" })
            {
                Text(text = "Esborra")
            }
            IntegerUpdown(
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .padding(bottom=10.dp)
            )
            Text ("Dia triat", modifier = Modifier.width(300.dp))
            Selector (
                opcions = listOf("DG", "DL", "DM", "DC", "DJ", "DV", "DS"),
                onSeleccionChanged = {textSeleccionat: String, posicio: Int ->
                    text=textSeleccionat
                },
                modifier = Modifier.width(300.dp)
            )
            Text ("Dia triat", modifier = Modifier.width(300.dp))
            DropDown(opcions = listOf("DG", "DL", "DM", "DC", "DJ", "DV", "DS"), modifier = Modifier.width(300.dp))
        }

    }
}
//Equivalente landa pero forma de siempre
fun onClick(textSeleccionat:String, posicio:Int){
//    text = textSeleccionat
}
