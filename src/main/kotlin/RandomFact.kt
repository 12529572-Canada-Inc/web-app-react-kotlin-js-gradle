import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import react.*
import react.dom.h3

// Define functional component
val randomFact = functionalComponent<RProps> {
    val (randomFact, setRandomFact) = useState<String?>(null)
    useEffect(emptyList()) {
        GlobalScope.launch {
            val fortyTwoFact = window.fetch("http://numbersapi.com/42").await().text().await()
            setRandomFact(fortyTwoFact)
        }
    }
    h3 { +(randomFact ?: "Fetching...") }
}

// Define HOFs
fun RBuilder.randomFact(handler: RProps.() -> Unit): ReactElement = child(randomFact) {
    attrs {
        handler()
    }
}