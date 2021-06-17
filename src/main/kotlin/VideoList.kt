import react.*
import react.dom.*

@JsExport
class VideoList: RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        for (video in unwatchedVideos) {
            p {
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}