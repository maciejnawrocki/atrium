package ch.tutteli.atrium.specs.integration

import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.core.polyfills.format
import ch.tutteli.atrium.creating.Expect
import ch.tutteli.atrium.specs.*
import ch.tutteli.atrium.translations.DescriptionAnyAssertion
import ch.tutteli.atrium.translations.DescriptionCollectionAssertion
import ch.tutteli.atrium.translations.DescriptionMapLikeAssertion
import org.spekframework.spek2.dsl.Root

abstract class MapLikeContainsFormatSpecBase(spec: Root.() -> Unit) : MapLikeContainsSpecBase(spec) {

    companion object {
        val sizeDescr = DescriptionCollectionAssertion.SIZE.getDefault()
        val additionalEntriesDescr = DescriptionMapLikeAssertion.WARNING_ADDITIONAL_ENTRIES.getDefault()

        fun Expect<String>.containsSize(actual: Int, expected: Int) =
            contains.exactly(1)
                .regex("\\Q$rootBulletPoint$featureArrow$sizeDescr\\E: $actual[^:]+${DescriptionAnyAssertion.TO_BE.getDefault()}: $expected")


        fun Expect<String>.containsInAnyOrderOnlyDescr() =
            contains.exactly(1).value(
                "$rootBulletPoint${
                    DescriptionMapLikeAssertion.IN_ANY_ORDER_ONLY.getDefault()
                        .format(DescriptionMapLikeAssertion.CONTAINS.getDefault())
                }:"
            )


        fun Expect<String>.containsInOrderOnlyDescr() =
            contains.exactly(1).value(
                "$rootBulletPoint${
                    DescriptionMapLikeAssertion.IN_ORDER_ONLY.getDefault()
                        .format(DescriptionMapLikeAssertion.CONTAINS.getDefault())
                }:"
            )

        fun Expect<String>.entrySuccess(key: String, actual: Any?, expected: String): Expect<String> {
            return this.contains.exactly(1).regex(
                "$indentRootBulletPoint\\Q$successfulBulletPoint$featureArrow${entry(key)}: $actual\\E.*${separator}" +
                    "$indentRootBulletPoint$indentSuccessfulBulletPoint$indentFeatureArrow$featureBulletPoint$expected"
            )
        }

        fun Expect<String>.entryFailing(key: String?, actual: Any?, expected: String): Expect<String> {
            return this.contains.exactly(1).regex(
                "\\Q$failingBulletPoint$featureArrow${entry(key)}: $actual\\E.*${separator}" +
                    "$indentRootBulletPoint$indentSuccessfulBulletPoint$indentFeatureArrow$featureBulletPoint$expected"
            )
        }

        fun Expect<String>.entryFailingExplaining(key: String?, actual: Any?, expected: String): Expect<String> {
            return this.contains.exactly(1).regex(
                "\\Q$failingBulletPoint$featureArrow${entry(key)}: $actual\\E.*${separator}" +
                    "$indentRootBulletPoint$indentSuccessfulBulletPoint$indentFeatureArrow$indentFeatureBulletPoint$explanatoryBulletPoint$expected"
            )
        }

        fun Expect<String>.entryNonExisting(key: String, expected: String): Expect<String> {
            return this.contains.exactly(1).regex(
                "\\Q$failingBulletPoint$featureArrow${entry(key)}: $keyDoesNotExist\\E.*${separator}" +
                    "$indentRootBulletPoint$indentSuccessfulBulletPoint$indentFeatureArrow$indentFeatureBulletPoint$explanatoryBulletPoint$expected"
            )
        }

        fun Expect<String>.additionalEntries(vararg pairs: Pair<String?, Any>): Expect<String> =
            and {
                val additionalEntries =
                    "\\Q$warningBulletPoint${DescriptionMapLikeAssertion.WARNING_ADDITIONAL_ENTRIES.getDefault()}\\E: $separator"
                contains.exactly(1).regex(additionalEntries)
                pairs.forEach { (key, value) ->
                    contains.exactly(1).regex(additionalEntries + "(.|$separator)+$listBulletPoint${entry(key, value)}")
                }
            }
    }
}
