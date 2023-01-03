package br.com.emersonmendes.kotstudy.other

import br.com.emersonmendes.kotstudy.other.mockk.Something
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MockkTests {

    @Test
    fun `should do something with relaxed true`() {

        /**
            By default, mocks are strict. Before passing mock to a code being tested you should set behavior with every block.
            In case you do not provide expected behavior, and call is performed, library throws an exception.
            This is different from what Mockito is doing by default.
            Mockito allows you to skip specifying expected behavior and replies with some basic value alike null or 0.
            You can achieve the same and even more in MockK by declaring relaxed mock.
         */

        val relaxedMock = mockk<Something>(relaxed = true)

        Assertions.assertEquals(relaxedMock.divide(1,1), 0)

        every {
            relaxedMock.divide(any(),any())
        } answers {
            11
        }

        Assertions.assertEquals(relaxedMock.divide(1,1), 11)

    }

}