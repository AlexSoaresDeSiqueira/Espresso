package alex.com.br.espresso.matchers

import android.support.design.widget.TextInputLayout
import android.support.test.espresso.matcher.BoundedMatcher
import android.view.View
import org.hamcrest.Description

fun withTextError(textToCheck: String): BoundedMatcher<View, TextInputLayout> {
    return object : BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

        override fun describeTo(description: Description) {
            description.appendText(" with error text")
        }

        override fun matchesSafely(item: TextInputLayout): Boolean {
            return item.error == textToCheck
        }
    }
}