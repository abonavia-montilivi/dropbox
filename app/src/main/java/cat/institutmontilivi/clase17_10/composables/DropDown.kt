package cat.institutmontilivi.clase17_10.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview  (backgroundColor = 0xFFBBAACC, heightDp = 800, widthDp = 400)
@Composable
fun PreviewDropDown(
){
    val dies = listOf("DG", "DL", "DM", "DC", "DJ", "DV", "DS")
    DropDown(dies)
}

@Composable
fun DropDown(
    opcions: List<String>,
    modifier: Modifier = Modifier,
    opcioInicial:Int =0,
    colorBotons: Color = MaterialTheme.colorScheme.secondary,
    colorMarc: Color = MaterialTheme.colorScheme.onErrorContainer,
    colorDesplegable: Color = MaterialTheme.colorScheme.background,
    gruixmarc: Int = 1)
{
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(opcions.getOrNull(opcioInicial) ?: "") }

    Column(modifier
        .background(Color.White)
    )
    {
            Text(text = selectedText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(
                            width = (gruixmarc.dp),
                            color = colorMarc
                        )
                    )
                    .background(colorBotons)
                    .clickable { expanded = !expanded })
        if (expanded){
            opcions.map {valor ->
                Text(valor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorDesplegable)
                        .border(
                            border = BorderStroke(
                                width = (gruixmarc.dp),
                                color = colorMarc
                            )
                        )
                        .clickable {
                            selectedText=valor
                            expanded=false
                        }
                )
            }
        }
        }
}

