package com.steliospapamichail.creditcardmask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.steliospapamichail.creditcardmask.ui.theme.CreditCardMaskTheme
import com.steliospapamichail.creditcardmasker.utils.CardType
import com.steliospapamichail.creditcardmasker.utils.getCardTypeFromNumber
import com.steliospapamichail.creditcardmasker.viewtransformations.CardNumberMask
import com.steliospapamichail.creditcardmasker.viewtransformations.ExpirationDateMask

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreditCardMaskTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    expiration()
                    Spacer(modifier = Modifier.height(10.dp))
                    cardNumber()
                }
            }
        }
    }
}

@Composable
fun expiration() {
    var expiration by remember { mutableStateOf("") }
    OutlinedTextField(
        value = expiration,
        visualTransformation = ExpirationDateMask(),
        onValueChange = {
            if (it.length <= 4) expiration = it
        }, label = { Text("Expiration") }
    )
}

@Composable
fun cardNumber() {
    var number by remember { mutableStateOf("") }
    OutlinedTextField(
        value = number,
        visualTransformation = CardNumberMask("-", true),
        trailingIcon = {
            val iconRes = when (getCardTypeFromNumber(number)) {
                CardType.VISA -> R.drawable.visa
                CardType.MASTERCARD -> R.drawable.mastercard
                CardType.AMERICAN_EXPRESS -> R.drawable.american_express
                CardType.MAESTRO -> R.drawable.maestro
                CardType.DINNERS_CLUB -> R.drawable.dinners_club
                CardType.DISCOVER -> R.drawable.discover
                CardType.JCB -> R.drawable.jcb
                else -> R.drawable.ic_launcher_background
            }
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "card_type",
                modifier = Modifier
                    .height(30.dp)
                    .width(40.dp)
                    .padding(end = 10.dp)
            )
        },
        onValueChange = {
            if (it.length <= 16) number = it
        }, label = { Text("Card number") }
    )
}