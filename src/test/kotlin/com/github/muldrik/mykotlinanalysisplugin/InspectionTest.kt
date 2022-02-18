package com.github.muldrik.mykotlinanalysisplugin

import KotlinGreetingsInspection
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class InspectionTest : LightPlatformCodeInsightFixture4TestCase() {

    override fun runInDispatchThread(): Boolean { //Required for autocompletion tests
        return false
    }

    @Test
    fun `Info appears in kt file`() {
        myFixture.configureByText("main.kt", "fun main() = println(42)")
        myFixture.enableInspections(KotlinGreetingsInspection())
        myFixture.checkHighlighting(false, true, false, false)
    }

    @Test
    fun `Info appears in kts file`() {
        myFixture.configureByText("scripts.kts", "println(42)")
        myFixture.enableInspections(KotlinGreetingsInspection())
        myFixture.checkHighlighting(false, true, false, false)
    }

    @Test
    fun `No info appears in non-koltin file`() {
        myFixture.configureByText("something", "banana")
        myFixture.enableInspections(KotlinGreetingsInspection())
        myFixture.checkHighlighting(false, false, false, false)
    }
}