package readme.examples

import ch.tutteli.atrium.api.fluent.en_GB.and
import ch.tutteli.atrium.api.fluent.en_GB.isGreaterThanOrEqual
import ch.tutteli.atrium.api.fluent.en_GB.isLessThan
import ch.tutteli.atrium.creating.Expect
import org.spekframework.spek2.Spek
import java.util.*


/**
 * The tests and error message are written here and automatically placed into the README via generation.
 * The generation is done during the project built. To trigger it manually, you have to run:
 * ```
 * ./gradlew :readme-examples:build
 * ```
 *
 * There are currently three kind of tags supported:
 * - <ex-xy> => places code and output into the tag
 * - <exs-xy> => places code into the tag, output will be put into a tag named <exs-xy-output>
 * - <code> => is not supposed to fail and only the code is put into the code
 *
 * Moreover, all tags can reuse snippets defined in this file with corresponding markers
 */
object Between1Spec : Spek({
    test("code-own-compose-1") {
        fun <T : Date> Expect<T>.isBetween(lowerBoundInclusive: T, upperBoundExclusive: T) =
            isGreaterThanOrEqual(lowerBoundInclusive).and.isLessThan(upperBoundExclusive)
    }
})
