package com.steliospapamichail.creditcardmasker.utils

import java.util.regex.Pattern

fun getCardTypeFromNumber(number: String): CardType {
    val visaRegex = Pattern.compile("^4[0-9]*\$")
    val mastercardRegex =
        Pattern.compile("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[01]|2720)[0-9]*\$")
    val americanExpressRegex = Pattern.compile("^3[47][0-9]*\$")
    val jcbRegex = Pattern.compile("^(?:2131|1800|35)[0-9]*\$")
    val maestroRegex = Pattern.compile("^(5[06789]|6)[0-9]*\$")
    val dinnersRegex = Pattern.compile("^3(?:0[0-59]|[689])[0-9]*\$")
    val discoverRegex =
        Pattern.compile("^(6011|65|64[4-9]|62212[6-9]|6221[3-9]|622[2-8]|6229[01]|62292[0-5])[0-9]*\$")

    return when {
        visaRegex.matcher(number).matches() ->
            CardType.VISA
        mastercardRegex.matcher(number).matches() ->
            CardType.MASTERCARD
        americanExpressRegex.matcher(number)
            .matches() ->
            CardType.AMERICAN_EXPRESS
        jcbRegex.matcher(number).matches() -> CardType.JCB
        maestroRegex.matcher(number).matches() -> CardType.MAESTRO
        dinnersRegex.matcher(number).matches() -> CardType.DINNERS_CLUB
        discoverRegex.matcher(number).matches() -> CardType.DISCOVER
        else ->
            CardType.UNKNOWN

    }
}