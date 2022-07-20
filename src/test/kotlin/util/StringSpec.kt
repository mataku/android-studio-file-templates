package util

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringSpec : DescribeSpec({
    describe("#slashedPackageName") {
        it("should replace . with /") {
            val input = "com.android.app"
            input.slashedPackageName() shouldBe "com/android/app"
        }
    }
})