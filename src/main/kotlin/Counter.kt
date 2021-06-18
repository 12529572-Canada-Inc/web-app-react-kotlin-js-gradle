import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button
import react.dom.h2

// Define props
external interface CounterProps: RProps {
    var name: String
}

// Define functional component
val counter = functionalComponent<CounterProps> { props ->
    val (count, setCount) = useState(0)
    h2 {
        +props.name
    }
    button {
        attrs.onClickFunction = { setCount(count + 1) }
        +count.toString()
    }
}

// Define HOFs
fun RBuilder.counter(handler: CounterProps.() -> Unit): ReactElement = child(counter) {
    attrs {
        handler()
    }
}