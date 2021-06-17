import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*

// Define props
external interface VideoListProps: RProps {
    var videos: List<Video>
}

// Define state
external interface VideoListState: RState {
    var selectedVideo: Video?
}

// Define class
@JsExport
class VideoList: RComponent<VideoListProps, RState>() {
    override fun RBuilder.render() {
        for (video in props.videos) {
            p {
                key = video.id.toString()
                attrs {
                    onClickFunction = {
                        window.alert("Clicked $video!")
                    }
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

// Define HOFs
fun RBuilder.videoList(handler: VideoListProps.() -> Unit): ReactElement {
    return child(VideoList::class) {
        this.attrs(handler)
    }
}