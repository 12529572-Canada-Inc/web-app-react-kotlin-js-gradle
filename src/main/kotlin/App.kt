import react.*
import react.dom.*

// Define interfaces
external interface Video {
    val id: Int
    val title: String
    val speaker: String
    val videoUrl: String
}

// Define data classes
data class KotlinVideo(
    override val id: Int,
    override val title: String,
    override val speaker: String,
    override val videoUrl: String
) : Video

// Define data
val unwatchedVideos = listOf(
    KotlinVideo(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    KotlinVideo(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    KotlinVideo(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E"),
)

val watchedVideos = listOf(
    KotlinVideo(4, "Mouse-less development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)

// Define state
external interface AppState : RState {
    var currentVideo: Video?
}

// Define React component class
@JsExport
class App : RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            videoList {
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
            h3 {
                +"Videos watched"
            }
            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }
        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
            }
        }
    }
}