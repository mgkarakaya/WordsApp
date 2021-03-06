# WordsApp
Words App in Kotlin
# Introduction
Words app allows you to select a letter and use Intents to navigate to an Activity that presents a number of words starting with that letter. Each word can be looked up via a web search.

Words app contains a scrollable list of 26 letters A to Z in a RecyclerView. The orientation of the RecyclerView can be changed between a vertical list or a grid of items.

# Summary v2.0
Fragments are reusable pieces of UI that can be embedded in activities.
The lifecycle of a fragment differs from the lifecycle of an activity, with view setup occurring in onViewCreated(), rather than onCreateView().
A FragmentContainerView is used to embed fragments in other activities and can manage navigation between fragments.
Using the Navigation Component

Setting the navGraph attribute of a FragmentContainerView allows you to navigate between fragments within an activity.
The NavGraph editor allows you to add navigation actions and specify arguments between different destinations.
While navigating using intents requires you to pass in extras, the Navigation component uses SafeArgs to auto-generate classes and methods for your navigation actions, ensuring type safety with arguments.
Use cases for fragments.

Using the Navigation component, many apps can manage their entire layout within a single activity, with all navigation occurring between fragments.
Fragments make common layout patterns possible, such as master-detail layouts on tablets, or multiple tabs within the same activity.
