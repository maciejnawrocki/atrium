package ch.tutteli.atrium.api.fluent.en_GB

import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.logic._logic
import ch.tutteli.atrium.logic._logicAppend
import ch.tutteli.atrium.logic.isEmpty
import ch.tutteli.atrium.logic.isNotEmpty
import ch.tutteli.atrium.logic.size
import ch.tutteli.kbox.identity

/**
 * Expects that the subject of `this` expectation (a [Collection]) is an empty [Collection].
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.fluent.en_GB.samples.deprecated.CollectionAssertionSamples.isEmpty
 */
fun <T : Collection<*>> Expect<T>.isEmpty(): Expect<T> =
    _logicAppend { isEmpty(::identity) }

/**
 * Expects that the subject of `this` expectation (a [Collection]) is not an empty [Collection].
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.fluent.en_GB.samples.deprecated.CollectionAssertionSamples.isNotEmpty
 */
fun <T : Collection<*>> Expect<T>.isNotEmpty(): Expect<T> =
    _logicAppend { isNotEmpty(::identity) }

/**
 * Expects that the subject of `this` expectation (a [Collection]) has the given [expected] size.
 *
 * Shortcut for `size.toBe(expected)`.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.fluent.en_GB.samples.deprecated.CollectionAssertionSamples.hasSize
 */
fun <T : Collection<*>> Expect<T>.hasSize(expected: Int): Expect<T> =
    size { toBe(expected) }

/**
 * Creates an [Expect] for the property [Collection.size] of the subject of `this` expectation,
 * so that further fluent calls are assertions about it.
 *
 * @return The newly created [Expect] for the extracted feature.
 *
 * @sample ch.tutteli.atrium.api.fluent.en_GB.samples.deprecated.CollectionAssertionSamples.sizeFeature
 */
val <T : Collection<*>> Expect<T>.size: Expect<Int>
    get() = _logic.size(::identity).transform()

/**
 * Expects that the property [Collection.size] of the subject of `this` expectation
 * holds all assertions the given [assertionCreator] creates for it and
 * returns an [Expect] for the current subject of `this` expectation.
 *
 * @return an [Expect] for the subject of `this` expectation.
 *
 * @sample ch.tutteli.atrium.api.fluent.en_GB.samples.deprecated.CollectionAssertionSamples.size
 */
fun <E, T : Collection<E>> Expect<T>.size(assertionCreator: Expect<Int>.() -> Unit): Expect<T> =
    _logic.size(::identity).collectAndAppend(assertionCreator)
