package ir.ah.app.bumgard.di

import ir.ah.app.bumgard.BuildConfig



object EndPoints {
    const val STAGE_BASE_URL = BuildConfig.STAGE_BASE_URL
    const val API_PRODUCTION_URL = BuildConfig.API_PRODUCTION_URL

    const val loginWithMobileNumber = "auth/login"
    const val sendVerificationCode = "auth/verification-code/send"
    const val sendPersonalInformation = ""
    const val getTopCityRequest = "topCity/"
    const val getPopularCityRequest = "popularCity/"
    const val getSearchRequest = "Search/"
    const val fakeApiKey = "Fake api key"
    const val itemsCountPerPage = 10
    const val profileRequest = ""
    const val profileFeedRequest = ""
    const val refreshToken = "auth/refresh-token"
}