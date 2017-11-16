package com.base.helper

import android.content.SharedPreferences
import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.`when`

/**
 * Created by Burak Eregar on 16.11.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
class SpHelperTest {

    private val sharedPreferences: SharedPreferences = mock()
    private val gson: Gson = mock()
    private lateinit var spHelper: SpHelper
    private val key = "testKey"
    private val editor: SharedPreferences.Editor = mock()

    @Before
    fun setUp(){
        `when`(sharedPreferences.edit()).thenReturn(editor)
        spHelper = SpHelper(sharedPreferences, gson)
    }

    @Test
    fun getDataFromSharedPref_should_returnInt() {
        val result = spHelper.getDataFromSharedPref(Int::class.java, key)
        verify(sharedPreferences).getInt(key, 0)
        assertEquals(result, 0)
    }

    @Test
    fun getDataFromSharedPref_should_returnString() {
        val result = spHelper.getDataFromSharedPref(String::class.java, key)
        verify(sharedPreferences).getString(key, null)
        assertEquals(result, null)
    }

    @Test
    fun getDataFromSharedPref_should_returnLong() {
        val result = spHelper.getDataFromSharedPref(Long::class.java, key)
        verify(sharedPreferences).getLong(key, 0)
        assertEquals(result, 0L)
    }

    @Test
    fun getDataFromSharedPref_should_returnBool() {
        val result = spHelper.getDataFromSharedPref(Boolean::class.java, key)
        verify(sharedPreferences).getBoolean(key, false)
        assertEquals(result, false)
    }

    @Test
    fun getDataFromSharedPref_should_returnNull() {
        val result = spHelper.getDataFromSharedPref(Double::class.java, key)
        assertEquals(result, null)
    }

    @Test
    fun putDatatoSharedPref_should_putInt() {
        spHelper.putDatatoSharedPref(0, Int::class.java, key)
        verify(editor).putInt(key, 0)
        verify(editor).commit()
    }

    @Test
    fun putDatatoSharedPref_should_putString() {
        spHelper.putDatatoSharedPref("testString", String::class.java, key)
        verify(editor).putString(key, "testString")
        verify(editor).commit()
    }

    @Test
    fun putDatatoSharedPref_should_putLong() {
        spHelper.putDatatoSharedPref(10L, Long::class.java, key)
        verify(editor).putLong(key, 10L)
        verify(editor).commit()
    }

    @Test
    fun putDatatoSharedPref_should_putBool() {
        spHelper.putDatatoSharedPref(true, Boolean::class.java, key)
        verify(editor).putBoolean(key, true)
        verify(editor).commit()
    }

}