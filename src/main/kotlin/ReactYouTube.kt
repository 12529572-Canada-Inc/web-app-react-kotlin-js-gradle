@file:JsModule("react-youtube-lite")
@file:JsNonModule

import react.*

// Define interfaces
external interface ReactYouTubeProps : RProps {
    var url: String
}

// Define classes
@JsName("ReactYouTubeLite")
external val reactPlayer: RClass<ReactYouTubeProps>