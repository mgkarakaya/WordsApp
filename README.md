# WordsApp
Words App in Kotlin
# Introduction
Words app allows you to select a letter and use Intents to navigate to an Activity that presents a number of words starting with that letter. Each word can be looked up via a web search.

Words app contains a scrollable list of 26 letters A to Z in a RecyclerView. The orientation of the RecyclerView can be changed between a vertical list or a grid of items.


# Summary
Explicit intents are used to navigate to specific activities in your app.
Implicit intents correspond to specific actions (like opening a link, or sharing an image) and let the system determine how to fulfill the intent.
Menu options allow you to add buttons and menus to the app bar.
Companion objects provide a way to associate reusable constants with a type, rather than an instance of that type.
To perform an intent:

Get a reference to the context.
Create an Intent object providing either an activity or intent type (depending on whether it's explicit or implicit).
Pass any needed data by calling putExtra().
Call startActivity() passing in the intent object.
