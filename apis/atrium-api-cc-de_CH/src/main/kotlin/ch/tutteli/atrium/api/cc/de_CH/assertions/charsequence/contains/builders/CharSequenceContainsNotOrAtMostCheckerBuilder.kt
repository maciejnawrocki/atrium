package ch.tutteli.atrium.api.cc.de_CH.assertions.charsequence.contains.builders

import ch.tutteli.atrium.creating.charsequence.contains.CharSequenceContains.SearchBehaviour
import ch.tutteli.atrium.creating.charsequence.contains.builders.CharSequenceContainsBuilder

/**
 * Represents the builder of a `contains not or at most` check within the fluent API of a
 * sophisticated `contains` assertion for [CharSequence].
 *
 * @param T The input type of the search.
 * @param S The search behaviour which should be applied for the input of the search.
 *
 * @constructor Represents the builder of a `contains not or at most` check within the fluent API of a
 *   sophisticated `contains` assertion for [CharSequence].
 * @param times The number which the check will compare against the actual number of times an expected object is
 *   found in the input of the search.
 * @param containsBuilder The previously used [CharSequenceContainsBuilder].
 */
@Deprecated("use the builder from the package creating, will be removed with 1.0.0", ReplaceWith("ch.tutteli.atrium.api.cc.de_CH.creating.charsequence.contains.builders.CharSequenceContainsNotOrAtMostCheckerBuilder"))
open class CharSequenceContainsNotOrAtMostCheckerBuilder<out T : CharSequence, out S : SearchBehaviour>(
    times: Int,
    containsBuilder: CharSequenceContainsBuilder<T, S>
) : ch.tutteli.atrium.api.cc.de_CH.creating.charsequence.contains.builders.CharSequenceContainsNotOrAtMostCheckerBuilder<T, S>(
    times,
    containsBuilder
)