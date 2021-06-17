import kotlinx.css.*
import react.*
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv

// Define props
external interface VideoPlayerProps : RProps {
    var video: Video
}

// Define React component class
@JsExport
class VideoPlayer : RComponent<VideoPlayerProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"${props.video.speaker}: ${props.video.title}"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    }
}

// Define HOFs
fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit): ReactElement {
    return child(VideoPlayer::class) {
        this.attrs(handler)
    }
}