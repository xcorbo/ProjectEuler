package xyz.corbolabs.concretecalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object SlabCalculator {
    val headerText = "Concrete Slab Calculator"
    val contentText = "Your typical slab for ground floorings, concrete floors, squared or rectangular footings and/or concrete walls. You need only provide a length (l), width (w) and height (h)."
    val normalTextColor = Color(68,68,68)
    val headerTextColor = Color(247, 149, 3)
    val backgroundColor = Color(234, 234, 234)
    val lightBackgroundColor = Color(68,68,68)
    val darkBackgroundColor = Color(51,51,51)
    val whiteTextColor = Color(255, 255, 255)
    val boldFont = FontFamily(Font(R.font.bsb))
    val regularFont = FontFamily(Font(R.font.br))


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SlabsPage(
    ) {
        // Column for all things
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // Header text
            Text( text = headerText,
                fontFamily = boldFont,
                fontSize =  28.sp,
                color = normalTextColor,
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Content Description
            Text( text = contentText,
                fontFamily = regularFont,
                fontSize =  16.sp,
                color = normalTextColor,
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )

            // New row for thumbnail and inputs that will be 50/50
            Row(){
                Image(
                    painter = painterResource(id = R.drawable.slabt),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                )
                // Column for inputs that will have 3 items
                Column() {

                    // Width
                    Row(){
                        Text( text = "width (w)",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        var text = "text"
                        OutlinedTextField(value = text,
                            onValueChange = {text = it},
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                        )
                        Text( text = "m",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                    Spacer( modifier = Modifier.height(15.dp))

                    // Length
                    Row(){
                        Text( text = "length (l)",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        var text = "text"
                        OutlinedTextField(value = text,
                            onValueChange = {text = it},
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                        )
                        Text( text = "m",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                    Spacer( modifier = Modifier.height(15.dp))

                    // Height
                    Row(){
                        Text( text = "height (h)",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        var text = "text"
                        OutlinedTextField(value = text,
                            onValueChange = {text = it},
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                        )
                        Text( text = "m",
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = normalTextColor,
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                }
            }
            // Concrete properties
            Text( text = "CONCRETE PROPERTIES",
                fontFamily = regularFont,
                fontSize =  16.sp,
                color = normalTextColor,
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Row that gets split in half
            Row(){

                // First half for resistance
                Row(
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text( text = "Resistance",
                        fontFamily = regularFont,
                        fontSize =  16.sp,
                        color = normalTextColor,
                        modifier = Modifier
                            .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                    var text = "text"
                    OutlinedTextField(value = text,
                        onValueChange = {text = it},
                        modifier = Modifier
                            .height(36.dp)
                            .fillMaxWidth()
                    )
                }

                // Second row for water %
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text( text = "Water (%)",
                        fontFamily = regularFont,
                        fontSize =  16.sp,
                        color = normalTextColor,
                        modifier = Modifier
                            .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                    var text = "text"
                    OutlinedTextField(value = text,
                        onValueChange = {text = it},
                        modifier = Modifier
                            .height(36.dp)
                            .padding(end = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            // Calculate Button
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(lightBackgroundColor),
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text( text = "CALCULATE",
                    fontFamily = boldFont,
                    fontSize =  24.sp,
                    color = whiteTextColor,
                    modifier = Modifier
                        .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                        .align(alignment = Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            // Results Bar
            Row(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .height(100.dp)
                .fillMaxWidth()
            ){
                // first 25%
                Column(modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .background(darkBackgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Volume",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = "(m³)",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "0",
                        fontFamily = regularFont,
                        color = headerTextColor,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 1, cement
                Column(modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .background(lightBackgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Cement",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = "(kg)",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "0",
                        fontFamily = regularFont,
                        color = headerTextColor,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 2, gravel
                Column(modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .background(lightBackgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Gravel",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = "(m³)",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "0",
                        fontFamily = regularFont,
                        color = headerTextColor,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 3, sand
                Column(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .background(lightBackgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Sand",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = "(m³)",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "0",
                        fontFamily = regularFont,
                        color = headerTextColor,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 4, water
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(lightBackgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Water",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = "(l)",
                        fontFamily = regularFont,
                        color = whiteTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "0",
                        fontFamily = regularFont,
                        color = headerTextColor,
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
