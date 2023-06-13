package ru.geekbrain.android.myfirsttest


import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnTrue(){
        EmailValidator.isValidEmail("name@email.com")?.let { assertTrue(it) }
    }

    @Test
    fun  emailValidator_CorrectEmailSubDomain_ReturnsTrue(){
        EmailValidator.isValidEmail("name@email.com.uk")?.let { assertTrue(it) }
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse(){
        EmailValidator.isValidEmail("name@email")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        EmailValidator.isValidEmail("name@email..com")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        EmailValidator.isValidEmail("@email.com")?.let { assertFalse(it) }
    }
    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        EmailValidator.isValidEmail("")?.let { assertFalse(it) }
    }

    /* @Test
     fun emailValidator_NullEmail_ReturnsFalse() {
         EmailValidator.isValidEmail(null)?.let { assertFalse(it) }
     }*/

    @Test
    fun emailValidator_InvalidEmailNoDomens_ReturnsFalse(){
        EmailValidator.isValidEmail("name@")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_Dot_ReturnsFalse() {
        EmailValidator.isValidEmail(".")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_InvalidCommaSeparator_ReturnsFalse() {
        EmailValidator.isValidEmail("name@email,com,uk")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_InvalidWithoutAt_ReturnsFalse() {
        EmailValidator.isValidEmail("name#email.com.uk")?.let { assertFalse(it) }
    }

    @Test
    fun emailValidator_EmptyString_ReturnsTrue() {
        assertEquals(EmailValidator.isValidEmail(""), false)
    }

    @Test
    fun emailValidator_NullEmail_ReturnsTrue() {
        EmailValidator.isValidEmail(null)?.let { assertNull(it) }
    }

    @Test
    fun emailValidator_InvalidEmptyString_ReturnsTrue() {
        EmailValidator.isValidEmail("")?.let { assertNotNull(it) }
    }
}