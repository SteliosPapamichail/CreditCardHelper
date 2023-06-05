# CreditCardHelper🖊️
A Jetpack-Compose library providing useful credit card utilities such as card type recognition and TextField ViewTransformations!

[![](https://jitpack.io/v/SteliosPapamichail/CreditCardHelper.svg)](https://jitpack.io/#SteliosPapamichail/CreditCardHelper)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=SteliosPapamichail_CreditCardHelper&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=SteliosPapamichail_CreditCardHelper)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=SteliosPapamichail_CreditCardHelper&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=SteliosPapamichail_CreditCardHelper)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=SteliosPapamichail_CreditCardHelper&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=SteliosPapamichail_CreditCardHelper)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=SteliosPapamichail_CreditCardHelper&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=SteliosPapamichail_CreditCardHelper)

## What's included?📜
- 🗂️Automatic card type recognition that supports the following cards:
  - Visa
  - Mastercard
  - Maestro
  - American Express
  - Dinners Club
  - JCB
  - Discover

- 🤩Simple VisualTransformation subclasses for the following use-cases:
  - Card expiration date
  - Card number (with custom separators, digit masking for the first twelve digits & more)

## Adding the library to your project✨

Add the following to your **root** `build.gradle` file:
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

Next, add the dependency below to your **module**'s `build.gradle` file:
```gradle
dependencies {
  implementation 'com.github.SteliosPapamichail:CreditCardHelper:v1.0.0'
}
```

## Usage📓

### Masks🎭
You can use the `ExpirationDateMask` or `CardNumberMask` VisualTransformations, by simply passing the respective composable to the `visualTransfomration` field of your `TextField`. For example:

```Kotlin
@Composable
fun Expiration() {
    var expiration by remember { mutableStateOf("") }
    OutlinedTextField(
        value = expiration,
        visualTransformation = ExpirationDateMask(),
        onValueChange = {
            if (it.length <= 4) expiration = it
        }, label = { Text("Expiration") }
    )
}
```
The above code will produce something like the following:
<p align="start">
  <img src="assets/exp_example.gif" alt="Expiration date example image" />
</p>

The `CardNumberMask` transform will use the `" "` blank separator by default. If you would like to use a custom one, you can simply pass it as a parameter to the composable like so:

```Kotlin
@Composable
fun CardNumber() {
    var number by remember { mutableStateOf("") }
    OutlinedTextField(
        value = number,
        visualTransformation = CardNumberMask("-"),
        onValueChange = {
            if (it.length <= 16) number = it
        }, label = { Text("Card number") }
    )
}
```
This will produce the following:
<p align="start">
  <img src="assets/cardnum_example.gif" alt="Card number example image" />
</p>

### Card Types🤖
You can use the provided `getCardTypeFromNumber(number: String)` function which accepts a string containing the input card number, and returning one of the recognized types or `UKNOWN` if no match was found. You can use it for building out Topup/Payment forms, card-selection or card-creation forms, and much more. Here's an example from the sample project:

<p align="start">
  <img src="assets/card_rec_example.gif" alt="Card recognition example image" />
</p>
