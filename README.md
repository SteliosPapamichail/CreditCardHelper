# 🖊️CreditCardHelper
A Jetpack-Compose library providing useful credit card utilities such as card type recognition and TextField ViewTransformations!

## What's included?
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
## Adding the library to your project

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
  implementation 'com.github.SteliosPapamichail:CreditCardHelper:Tag'
}
```

## Usage
