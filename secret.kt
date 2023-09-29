package xyz.corbolabs.concretecalculator

import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

object SlabCalculator {

    val boldFont = FontFamily(Font(R.font.bsb))
    val regularFont = FontFamily(Font(R.font.br))


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SlabsPage(
    ) {
        // Init
        var width by rememberSaveable { mutableStateOf("0.00") }
        var length by rememberSaveable { mutableStateOf("0.00") }
        var height by rememberSaveable { mutableStateOf("0.00") }
        var volume by rememberSaveable { mutableStateOf("--") }
        var resistance by rememberSaveable { mutableStateOf("210") }
        var waterPercentage by rememberSaveable { mutableStateOf("15") }
        var cement by rememberSaveable { mutableStateOf("0.00") }
        var gravel by rememberSaveable { mutableStateOf("0.00") }
        var sand by rememberSaveable { mutableStateOf("0.00") }
        var water by rememberSaveable { mutableStateOf("0.00") }
        var resistanceLabelText by remember { mutableStateOf("Resistance") }

        var expanded by remember { mutableStateOf(false) }
        val resistanceItems = listOf("", "", "", "")
        var selectedResistanceItem by remember { mutableStateOf("") }
        val icon = if (expanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown


        // Function to calculate the volume based on entered values
        fun calculateVolume() {
            // Parse the values to integers (you may need to handle parsing errors)
            val widthValue = width.toFloatOrNull() ?: 0f
            val lengthValue = length.toFloatOrNull() ?: 0f
            val heightValue = height.toFloatOrNull() ?: 0f

            // Perform the calculation (e.g., volume = width * length * height)
            val newVolume = widthValue * lengthValue * heightValue
            // Format the volume to have two decimal places
            val formattedVolume = String.format("%.2f", newVolume)

            // Update the volume state variable
            volume = formattedVolume
            val concreteAggregates = AggregatesCalculator.aggregatesCalculation(volume, resistance, waterPercentage)

            // Update the materials values
            cement = concreteAggregates.cement.toString()
            gravel = concreteAggregates.gravel.toString()
            sand = concreteAggregates.sand.toString()
            water = concreteAggregates.water.toString()
        }

        // Column for all things
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.backgroundColor)),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // Header text
            Text( text = stringResource(id = R.string.headerTextSlab),
                fontFamily = boldFont,
                fontSize =  28.sp,
                color = colorResource(id = R.color.normalTextColor),
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Content Description
            Text( text = stringResource(id = R.string.descriptionTextSlab),
                fontFamily = regularFont,
                fontSize =  16.sp,
                color = colorResource(id = R.color.normalTextColor),
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )

            // New row for thumbnail and inputs that will be 50/50
            Row(){
                Image(
                    painter = painterResource(id = R.drawable.slab_act_one),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                )
                // Column for inputs that will have 3 items
                Column() {
                    Spacer( modifier = Modifier.height(15.dp))

                    // Width
                    Row(){
                        Text( text = stringResource(id = R.string.width),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        Box(
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)) // Add border
                                .background(colorResource(id = R.color.backgroundColor)),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            BasicTextField(
                                value = width,
                                onValueChange = { width = it },
                                textStyle = TextStyle.Default.copy(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    fontFamily = regularFont, 
                                    color = colorResource(id = R.color.normalTextColor)
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 10.dp, top = 8.dp)
                            )
                        }
                        Text( text = stringResource(id = R.string.metresShort),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                    Spacer( modifier = Modifier.height(15.dp))

                    // Length
                    Row(){
                        Text( text = stringResource(id = R.string.length),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        Box(
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)) // Add border
                                .background(colorResource(id = R.color.backgroundColor)),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            BasicTextField(
                                value = length,
                                onValueChange = { length = it },
                                textStyle = TextStyle.Default.copy(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    fontFamily = regularFont,
                                    color = colorResource(id = R.color.normalTextColor)
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 10.dp, top = 8.dp)
                            )
                        }
                        Text( text = stringResource(id = R.string.metresShort),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                    Spacer( modifier = Modifier.height(15.dp))

                    // Height
                    Row(){
                        Text( text = stringResource(id = R.string.height),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                        Box(
                            modifier = Modifier
                                .height(36.dp)
                                .fillMaxWidth(0.75f)
                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)) // Add border
                                .background(colorResource(id = R.color.backgroundColor)),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            BasicTextField(
                                value = height,
                                onValueChange = { height = it },
                                textStyle = TextStyle.Default.copy(
                                    fontSize = 16.sp,
                                    lineHeight = 16.sp,
                                    fontFamily = regularFont,
                                    color = colorResource(id = R.color.normalTextColor)
                                ),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 10.dp, top = 8.dp)
                            )
                        }
                        Text( text = stringResource(id = R.string.metresShort),
                            fontFamily = regularFont,
                            fontSize =  16.sp,
                            color = colorResource(id = R.color.normalTextColor),
                            modifier = Modifier
                                .padding(bottom = 0.dp, top = 0.dp, start = 5.dp, end = 10.dp)
                                .align(alignment = Alignment.CenterVertically)
                        )
                    }
                }
            }
            // Concrete properties
            Text( text = stringResource(id = R.string.concretePropertiesTitle),
                fontFamily = regularFont,
                fontSize =  16.sp,
                color = colorResource(id = R.color.normalTextColor),
                modifier = Modifier.padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Row that gets split in half
            Row(){

                // First half for resistance
                Row(
                    modifier = Modifier.fillMaxWidth(0.5f)
                        .padding (start = 10.dp, end = 10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .height(36.dp)
                            .fillMaxWidth(1f)
                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                            .background(colorResource(id = R.color.backgroundColor)),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        BasicTextField(
                            value = resistanceLabelText,
                            onValueChange = { },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 16.sp,
                                lineHeight = 16.sp, // Reduce line height
                                fontFamily = FontFamily.Default,
                                color = colorResource(id = R.color.normalTextColor)
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 10.dp, top = 8.dp), // Add left padding
                            readOnly = true // Make it read-only
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable { expanded = !expanded }
                                .padding(start = 4.dp)
                                .align(Alignment.CenterEnd) // Add left padding to the icon
                        )
                    }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.background(colorResource(id = R.color.backgroundColor))
                            ) {
                            // Item 110 weak
                            DropdownMenuItem(
                                text = { Text(
                                            text = "1:2.5:4 weak (110kg/cm²)",
                                            style = TextStyle.Default.copy(
                                                fontSize = 16.sp,
                                                lineHeight = 16.sp,
                                                fontFamily = FontFamily.Default,
                                                color = colorResource(id = R.color.normalTextColor)
                                            )
                                ) },
                                onClick = { resistanceLabelText = "110kg/cm²"
                                            expanded = false},
                                modifier = Modifier.background(colorResource(id = R.color.backgroundColor))
                            )
                            // Item 190 general
                            DropdownMenuItem(
                                text = { Text(
                                    text = "1:2:2.5 general use (190kg/cm²)",
                                    style = TextStyle.Default.copy(
                                        fontSize = 16.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        color = colorResource(id = R.color.normalTextColor)
                                    )
                                ) },
                                onClick = { resistanceLabelText = "190kg/cm²"
                                    expanded = false},
                                modifier = Modifier.background(colorResource(id = R.color.backgroundColor))
                            )
                            // Item 220 strong
                            DropdownMenuItem(
                                text = { Text(
                                    text = "1:2:2 strong (220kg/cm²)",
                                    style = TextStyle.Default.copy(
                                        fontSize = 16.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        color = colorResource(id = R.color.normalTextColor)
                                    )
                                ) },
                                onClick = { resistanceLabelText = "220kg/cm²"
                                    expanded = false},
                                modifier = Modifier.background(colorResource(id = R.color.backgroundColor))
                            )
                            // Item 270 very strong
                            DropdownMenuItem(
                                text = { Text(
                                    text = "1:1.5:2 very strong (270kg/cm²)",
                                    style = TextStyle.Default.copy(
                                        fontSize = 16.sp,
                                        lineHeight = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        color = colorResource(id = R.color.normalTextColor)
                                    )
                                ) },
                                onClick = { resistanceLabelText = "270kg/cm²"
                                    expanded = false},
                                modifier = Modifier.background(colorResource(id = R.color.backgroundColor))
                            )
                    }


                }

                // Second row for water %
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text( text = stringResource(id = R.string.water),
                        fontFamily = regularFont,
                        fontSize =  16.sp,
                        color = colorResource(id = R.color.normalTextColor),
                        modifier = Modifier
                            .padding(bottom = 0.dp, top = 0.dp, start = 10.dp, end = 10.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                    Box(
                        modifier = Modifier
                            .height(36.dp)
                            .fillMaxWidth(0.75f)
                            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)) // Add border
                            .background(colorResource(id = R.color.backgroundColor)),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        BasicTextField(
                            value = waterPercentage,
                            onValueChange = { waterPercentage = it },
                            textStyle = TextStyle.Default.copy(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                fontFamily = regularFont,
                                color = colorResource(id = R.color.normalTextColor)
                            ),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 10.dp, top = 8.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            // Calculate Button
            Button(onClick = { calculateVolume() },
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightBackgroundColor)),
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text( text = stringResource(id = R.string.calculateButtonText),
                    fontFamily = boldFont,
                    fontSize =  24.sp,
                    color = colorResource(id = R.color.whiteTextColor),
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
                    .background(colorResource(id = R.color.darkBackgroundColor)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.volume),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = stringResource(id = R.string.cubeMetresShort),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = volume.toString(),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.headerTextColor),
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 1, cement
                Column(modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .background(colorResource(id = R.color.lightBackgroundColor)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.Cement),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = stringResource(id = R.string.kilogramsShort),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = cement,
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.headerTextColor),
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 2, gravel
                Column(modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .background(colorResource(id = R.color.lightBackgroundColor)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.Gravel),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = stringResource(id = R.string.cubeMetresShort),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = gravel,
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.headerTextColor),
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 3, sand
                Column(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .background(colorResource(id = R.color.lightBackgroundColor)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.Sand),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = stringResource(id = R.string.cubeMetresShort),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = sand,
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.headerTextColor),
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }

                // Row 4, water
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.lightBackgroundColor)),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = stringResource(id = R.string.waterResult),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(text = stringResource(id = R.string.litres),
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.whiteTextColor),
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = water,
                        fontFamily = regularFont,
                        color = colorResource(id = R.color.headerTextColor),
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
            }

            // BACK BUTTON HERE

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun dropDownMenu() {


    }

}
