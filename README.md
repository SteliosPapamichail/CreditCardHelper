# CreditCardHelper🖊️
A Jetpack-Compose library providing useful credit card utilities such as card type recognition and TextField ViewTransformations!

## What's included?📜
- 🗂️Automatic card type recognition that supports the following card types:
  - Visa
  - Mastercard
  - Maestro
  - American Express
  - Dinners Club
  - JCB
  - Discover

- 🤩Beautiful VisualTransformation subclasses for the following use-cases:
  - Card expiration date
  - Card number (with custom separators)

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
  <img src="assets/exp_example.gif" alt="Expiration Date Example Image" />
</p>
The `CardNumberMask` transform will use the `" "` blank separator by default. If you would like to use a custom one, you can simply pass it as a parameter to the composable like so:
```kotlin
@Composable
fun CardNumber() {
    var number by remember { mutableStateOf("") }
    OutlinedTextField(
        value = number,
        visualTransformation = CardNumberMask("-"),
        onValueChange = {
            if (it.length <= 16) number = it
            Log.d("MYLIB", getCardTypeFromNumber(number).name)
        }, label = { Text("Card number") }
    )
}
```
This will produce the following:
<p align="start">
  <img src="assets/cardnum_example.gif" alt="Expiration Date Example Image" />
</p>
