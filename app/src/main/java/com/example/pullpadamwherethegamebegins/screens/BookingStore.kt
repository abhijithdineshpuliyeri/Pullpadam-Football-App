package com.example.pullpadamwherethegamebegins.screens

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import org.json.JSONArray
import org.json.JSONObject

object BookingStore {

    private const val PREFS_NAME = "pullpadam_bookings"
    private const val BOOKINGS_KEY = "bookings"

    private var initialized = false

    private lateinit var appContext: Context

    // =========================================================
    // BOOKINGS
    // =========================================================

    val bookings = mutableStateListOf<Booking>()


    // =========================================================
    // INITIALIZE
    // =========================================================

    fun initialize(context: Context) {

        if (initialized) {
            return
        }

        appContext = context.applicationContext

        loadBookings()

        initialized = true
    }


    // =========================================================
    // NORMALIZE TEXT
    // =========================================================

    private fun normalize(
        value: String
    ): String {

        return value
            .trim()
            .replace(
                Regex("\\s+"),
                " "
            )
            .uppercase()
    }


    // =========================================================
    // CHECK WHETHER SLOT IS AVAILABLE
    // =========================================================

    fun isSlotAvailable(
        turfName: String,
        format: String,
        date: String,
        time: String
    ): Boolean {

        val checkTurf =
            normalize(turfName)

        val checkFormat =
            normalize(format)

        val checkDate =
            normalize(date)

        val checkTime =
            normalize(time)


        return bookings.none { booking ->

            val sameTurf =
                normalize(
                    booking.turfName
                ) == checkTurf


            val sameFormat =
                normalize(
                    booking.format
                ) == checkFormat


            val sameDate =
                normalize(
                    booking.date
                ) == checkDate


            val sameTime =
                normalize(
                    booking.time
                ) == checkTime


            val activeBooking =
                !booking.cancelled


            activeBooking &&
                    sameTurf &&
                    sameFormat &&
                    sameDate &&
                    sameTime
        }
    }


    // =========================================================
    // ADD BOOKING
    // =========================================================

    fun addBooking(
        turfName: String,
        format: String,
        session: String,
        date: String,
        time: String,
        price: String
    ): Boolean {

        // =====================================================
        // CHECK DUPLICATE
        // =====================================================

        if (
            !isSlotAvailable(
                turfName = turfName,
                format = format,
                date = date,
                time = time
            )
        ) {

            return false
        }


        // =====================================================
        // CREATE BOOKING
        // =====================================================

        val booking =
            Booking(

                turfName =
                    turfName.trim(),

                format =
                    format.trim(),

                session =
                    session.trim(),

                date =
                    date.trim(),

                time =
                    time.trim(),

                price =
                    price.trim(),

                bookingTimeMillis =
                    0L,

                cancelled =
                    false
            )


        // =====================================================
        // ADD TO LIST
        // =====================================================

        bookings.add(
            booking
        )


        // =====================================================
        // SAVE
        // =====================================================

        saveBookings()


        return true
    }


    // =========================================================
    // CANCEL BOOKING
    // =========================================================

    fun cancelBooking(
        booking: Booking
    ) {

        val index =
            bookings.indexOfFirst {

                it === booking
            }


        if (index != -1) {

            bookings[index] =
                bookings[index].copy(
                    cancelled = true
                )


            saveBookings()
        }
    }


    // =========================================================
    // SAVE BOOKINGS
    // =========================================================

    private fun saveBookings() {

        if (!initialized) {
            return
        }


        val jsonArray =
            JSONArray()


        bookings.forEach { booking ->

            val jsonObject =
                JSONObject()


            jsonObject.put(
                "turfName",
                booking.turfName
            )

            jsonObject.put(
                "format",
                booking.format
            )

            jsonObject.put(
                "session",
                booking.session
            )

            jsonObject.put(
                "date",
                booking.date
            )

            jsonObject.put(
                "time",
                booking.time
            )

            jsonObject.put(
                "price",
                booking.price
            )

            jsonObject.put(
                "bookingTimeMillis",
                booking.bookingTimeMillis
            )

            jsonObject.put(
                "cancelled",
                booking.cancelled
            )


            jsonArray.put(
                jsonObject
            )
        }


        appContext
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .putString(
                BOOKINGS_KEY,
                jsonArray.toString()
            )
            .apply()
    }


    // =========================================================
    // LOAD BOOKINGS
    // =========================================================

    private fun loadBookings() {

        bookings.clear()


        val preferences =
            appContext
                .getSharedPreferences(
                    PREFS_NAME,
                    Context.MODE_PRIVATE
                )


        val savedBookings =
            preferences.getString(
                BOOKINGS_KEY,
                null
            )


        if (
            savedBookings.isNullOrEmpty()
        ) {

            return
        }


        try {

            val jsonArray =
                JSONArray(
                    savedBookings
                )


            for (
            i in 0 until jsonArray.length()
            ) {

                val jsonObject =
                    jsonArray.getJSONObject(i)


                val booking =
                    Booking(

                        turfName =
                            jsonObject.optString(
                                "turfName"
                            ),

                        format =
                            jsonObject.optString(
                                "format"
                            ),

                        session =
                            jsonObject.optString(
                                "session"
                            ),

                        date =
                            jsonObject.optString(
                                "date"
                            ),

                        time =
                            jsonObject.optString(
                                "time"
                            ),

                        price =
                            jsonObject.optString(
                                "price"
                            ),

                        bookingTimeMillis =
                            jsonObject.optLong(
                                "bookingTimeMillis",
                                0L
                            ),

                        cancelled =
                            jsonObject.optBoolean(
                                "cancelled",
                                false
                            )
                    )


                bookings.add(
                    booking
                )
            }

        } catch (
            e: Exception
        ) {

            bookings.clear()
        }
    }


    // =========================================================
    // CLEAR ALL BOOKINGS
    // =========================================================

    fun clearAllBookings() {

        bookings.clear()


        if (!initialized) {
            return
        }


        appContext
            .getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
            )
            .edit()
            .remove(
                BOOKINGS_KEY
            )
            .apply()
    }
}