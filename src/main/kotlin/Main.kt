import react.dom.*
import kotlinx.browser.document

fun main() {
    // Render the components
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}