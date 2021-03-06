//TODO remove file with 0.17.0
@file:Suppress("DEPRECATION")

package ch.tutteli.atrium.domain.builders.reporting

import ch.tutteli.atrium.core.CoreFactory
import ch.tutteli.atrium.domain.builders.reporting.impl.AssertionFormatterControllerOptionImpl
import ch.tutteli.atrium.reporting.AssertionFormatterController
import ch.tutteli.atrium.reporting.ObjectFormatter
import ch.tutteli.atrium.reporting.translating.Translator

/**
 * Provides options to create an [AssertionFormatterController].
 */
@Deprecated("Configure components via withOptions when creating an expectation verb instead; will be removed with 0.17.0")
interface AssertionFormatterControllerOption {

    /**
     * The previously chosen [ObjectFormatter].
     */
    val objectFormatter: ObjectFormatter

    /**
     * The previously chosen [Translator].
     */
    val translator: Translator

    /**
     * Uses [CoreFactory.newAssertionFormatterController] as [AssertionFormatterController].
     */
    fun withDefaultAssertionFormatterController(): AssertionFormatterFacadeOption

    /**
     * Uses the given [assertionFormatterController] as custom [AssertionFormatterController].
     */
    fun withAssertionFormatterController(assertionFormatterController: AssertionFormatterController): AssertionFormatterFacadeOption

    companion object {
        fun create(objectFormatter: ObjectFormatter, translator: Translator): AssertionFormatterControllerOption =
            AssertionFormatterControllerOptionImpl(objectFormatter, translator)
    }
}
