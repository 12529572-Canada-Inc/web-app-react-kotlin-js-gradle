import react.dom.*
import kotlinx.browser.document

external interface Video {
    val id: Int
    val title: String
    val speaker: String
    val videoUrl: String
}

data class KotlinVideo(
    override val id: Int,
    override val title: String,
    override val speaker: String,
    override val videoUrl: String
) : Video

fun main() {
    render(document.getElementById("root")) {
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            p {
                +"John Doe: Building and breaking things"
            }
            p {
                +"Jane Smith: The development process"
            }
            p {
                +"Matt Miller: The Web 7.0"
            }

            h3 {
                +"Videos watched"
            }
            p {
                +"Tom Jerry: Mouseless development"
            }
        }
        div {
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    }
}