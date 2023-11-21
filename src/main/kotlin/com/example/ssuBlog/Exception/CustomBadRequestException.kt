package com.example.ssuBlog.Exception

class CustomBadRequestException(badRequestCode: BadRequestCode) : RuntimeException() {
    public val badRequestCode: BadRequestCode = badRequestCode
}
